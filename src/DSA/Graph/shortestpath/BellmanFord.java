package DSA.Graph.shortestpath;

import java.util.Arrays;
import java.util.List;

public class BellmanFord {

    private record Edge(int source, int dest, int weight) {
    }

    public static int[] bellmanFord(int V, List<Edge> edges, int source) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        for (int i = 1; i < V; i++) {
            for (Edge e : edges) {
                if(dist[e.source]){

                }
            }

        }
    }

    void main() {
    }
}
