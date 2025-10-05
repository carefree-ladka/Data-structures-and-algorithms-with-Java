package DSA.Graph.shortestpath;


import module java.base;

public class Dijkstra {

    public record Edge(int to, int weight) {
    }

    public record PathResult(int distance, List<Integer> path) {
        @Override
        public String toString() {
            return "Distance = " + distance + ", Path = " + path;
        }
    }

    public static PathResult dijkstra(List<List<Edge>> edges, int source, int target) {
        final int N = edges.size();
        int[] dist = new int[N];
        int[] parent = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        dist[source] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{source, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curWeight = cur[0];
            int curDistance = cur[1];

            if (curWeight > dist[curDistance]) continue; //  outdated entry in PQ

            for (Edge edge : edges.get(curDistance)) {
                int v = edge.to;
                int w = edge.weight;
                if (dist[curDistance] + w < dist[v]) {
                    dist[v] = dist[curDistance] + w;
                    parent[v] = curDistance;
                    pq.offer(new int[]{dist[v], v});
                }
            }
        }

        if (dist[target] == Integer.MAX_VALUE) return new PathResult(-1, Collections.emptyList());

        List<Integer> path = reconstructPath(parent, target);
        return new PathResult(dist[target], path);
    }


    private static List<Integer> reconstructPath(int[] parent, int target) {
        List<Integer> path = new ArrayList<>();

        for (int node = target; node != -1; node = parent[node]) {
            path.add(node);
        }

        Collections.reverse(path);
        return path;
    }

    void main() {
        final int N = 5;
        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new Edge(1, 4));
        graph.get(0).add(new Edge(2, 1));
        graph.get(2).add(new Edge(1, 2));
        graph.get(1).add(new Edge(3, 1));
        graph.get(2).add(new Edge(3, 5));
        graph.get(3).add(new Edge(4, 3));

        IO.println(dijkstra(graph, 0, 4)); // Distance = 7, Path = [0, 2, 1, 3, 4]
    }
}
