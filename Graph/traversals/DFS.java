package DSA.Graph.traversals;

import module java.base;

public class DFS {

    public static List<Integer> dfs(int source, List<List<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];
        List<Integer> res = new ArrayList<>();
        dfsHelper(source, adj, visited, res);

        return res;
    }

    // Stack Based
    public static List<Integer> dfs2(int source, List<List<Integer>> adj) {
        Deque<Integer> stack = new ArrayDeque<>();
        boolean[] visited = new boolean[adj.size()];
        List<Integer> res = new ArrayList<>();

        stack.push(source);
        visited[source] = true;

        while (!stack.isEmpty()) {
            int curr = stack.pop();
            res.add(curr);

            for (int neighbor : adj.get(curr)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    stack.push(neighbor);
                }
            }
        }
        return res;
    }

    private static void dfsHelper(int source, List<List<Integer>> adj, boolean[] visited, List<Integer> res) {
        visited[source] = true;
        res.add(source);

        for (int neighbour : adj.get(source)) {
            if (!visited[neighbour]) {
                dfsHelper(neighbour, adj, visited, res);
            }
        }
    }

    void main() {

        final int n = 5;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(1);
        graph.get(1).add(0);
        graph.get(0).add(2);
        graph.get(2).add(0);
        graph.get(1).add(3);
        graph.get(3).add(1);
        graph.get(1).add(4);
        graph.get(4).add(1);
        graph.get(3).add(4);
        graph.get(4).add(3);

        IO.println(dfs(0, graph));
        IO.println(dfs2(0, graph));
    }
}
