package DSA.Graph.shortestpath;

import module java.base;

public class BFS {

    public record PathResult(int distance, List<Integer> path) {
        @Override
        public String toString() {
            return "Distance = " + distance + ", Path = " + path;
        }
    }

    public static PathResult shortestPath(List<List<Integer>> adj, int src, int dest) {
        if (src == dest) {
            return new PathResult(0, Collections.singletonList(src));
        }

        final int N = adj.size();

        boolean[] visited = new boolean[N];
        int[] dist = new int[N];
        int[] parent = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        Queue<Integer> q = new ArrayDeque<>();

        visited[src] = true;
        dist[src] = 0;
        q.offer(src);

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == dest) {
                List<Integer> path = reconstructPath(parent, src, dest);
                return new PathResult(dist[dest], path);
            }

            for (int neighbor : adj.get(cur)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    dist[neighbor] = dist[cur] + 1;
                    parent[neighbor] = cur;
                    q.offer(neighbor);
                }
            }
        }
        return new PathResult(-1, Collections.emptyList());
    }

    private static List<Integer> reconstructPath(int[] parent, int src, int target) {
        List<Integer> path = new ArrayList<>();

        for (int node = target; node != -1; node = parent[node]) {
            path.add(node);
        }

        Collections.reverse(path);
        return path;
    }

    void main() {
        final int N = 5;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).addAll(Arrays.asList(1, 2));
        graph.get(1).addAll(Arrays.asList(0, 3));
        graph.get(2).addAll(Arrays.asList(0, 3));
        graph.get(3).addAll(Arrays.asList(1, 2, 4));
        graph.get(4).add(3);

        IO.println(shortestPath(graph, 0, 4)); // Distance = 3, Path = [0, 1, 3, 4]
    }
}
