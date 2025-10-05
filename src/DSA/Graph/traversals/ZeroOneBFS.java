package DSA.Graph.traversals;

import module java.base;

public class ZeroOneBFS {

    private record Edge(int v, int w) {
    }

    public static int[] zeroOneBFS(List<List<Edge>> graph, int source) {
        final int N = graph.size();
        int[] dist = new int[N];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        Deque<Integer> deque = new ArrayDeque<>();
        deque.offerFirst(source);

        while (!deque.isEmpty()) {
            int u = deque.pollFirst();

            for (Edge e : graph.get(u)) {
                int v = e.v;
                int w = e.w;

                if (dist[u] + w < dist[v]) {
                    dist[v] = w + dist[u];

                    if (w == 0) deque.offerFirst(v);
                    else deque.offerLast(v);
                }
            }
        }
        return dist;
    }

    void main() {
        final int n = 5;
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        // edges: u -> v, weight
        graph.get(0).add(new Edge(1, 0));
        graph.get(0).add(new Edge(2, 1));
        graph.get(1).add(new Edge(2, 0));
        graph.get(1).add(new Edge(3, 1));
        graph.get(2).add(new Edge(3, 0));
        graph.get(3).add(new Edge(4, 1));

        IO.println(Arrays.toString(zeroOneBFS(graph, 0))); // [0, 0, 0, 0, 1]
    }
}
