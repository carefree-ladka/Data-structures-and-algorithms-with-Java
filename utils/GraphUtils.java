package DSA.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphUtils {

    private GraphUtils() {
    }

    public static Map<Integer, List<Integer>> createGraph(int[][] edges, int n) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++)
            graph.put(i, new ArrayList<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]); // undirected
        }
        return graph;
    }
}
