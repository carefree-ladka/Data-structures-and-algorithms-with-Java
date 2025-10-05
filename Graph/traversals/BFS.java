package DSA.Graph.traversals;

import module java.base;

public class BFS {

    private record Edge(int v, int w) {
    }

    public static List<Integer> bfs(List<List<Edge>> graph, int source) {
        List<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[graph.size()];
        Queue<Edge> q = new ArrayDeque<>();

        q.offer(new Edge(source, 0));
        visited[source] = true;

        while (!q.isEmpty()) {
            Edge curr = q.poll();

            res.add(curr.v);

            for (Edge e : graph.get(curr.v)) {
                if (!visited[e.v]) {
                    visited[e.v] = true;
                    q.offer(e);
                }
            }
        }

        return res;
    }

    void main() {
        int n = 5;
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new Edge(1, 0));
        graph.get(0).add(new Edge(2, 1));
        graph.get(1).add(new Edge(2, 0));
        graph.get(1).add(new Edge(3, 1));
        graph.get(2).add(new Edge(3, 0));
        graph.get(3).add(new Edge(4, 1));

        IO.print(bfs(graph, 0));
    }
}
