package Bellman_Ford;

import java.util.LinkedList;

public class BF {

    Integer[] dist;
    Integer[] pi;
    

    /**
     * Bellman-Ford 
     * @param g graph represented with arrays and lists
     * @param s number that representes the main vertex
     * @return the dist array if it works else null
     */
    public static Integer[] BellmanFord(LinkedList<int[]>[] g, int s) {
        Integer[] dist = new Integer[g.length];
        Integer[] pi = new Integer[g.length];
        // Init
        for (int i = 0 ; i < dist.length ;i++) {
            dist[i] = null;
            pi[i] = null;
        }
        dist[s] = 0;
        pi[s] = s;
        // Main part
        for (int k = 0 ; k < g.length ; k++) {
            for (int i = 0 ; i < g.length ; i++) {
                for (int[] t : g[i]) {
                    if (dist[t[0]] == null || dist[i] + t[1] < dist[t[0]]) {
                        dist[t[0]] = dist[i] + t[1];
                        pi[t[0]] = i;
                    }
                }
            }
        }

        // Negative cycle test
        for (int i = 0 ; i < g.length ; i++) {
            for (int[] t : g[i]) {
                if (dist[t[0]] != null && dist[i] + t[1] < dist[t[0]]) {
                    return null;
                }
            }
        }

        return dist;
    }
}
