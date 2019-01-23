import java.util.LinkedList;

public class BF {


    public static Integer[] BellmanFord(LinkedList<int[]>[] g, int s) {
        Integer[] dist = new Integer[g.length];
        // Init
        for (int i = 0 ; i < dist.length ;i++) {
            dist[i] = null;
        }
        dist[s] = 0;
        // Main part
        for (int k = 0 ; k < g.length ; k++) {
            for (int i = 0 ; i < g.length ; i++) {
                System.out.println("Arc : " + i);
                for (int[] t : g[i]) {
                    System.out.println("Loop "+t[0] + "->" + dist[t[0]] + " | " + t[1]);
                    if (dist[t[0]] == null || dist[i] + t[1] < dist[t[0]]) {
                        dist[t[0]] = dist[i] + t[1];
                        System.out.println("Dist t update :" + dist[t[0]]);
                    }
                }
            }
        }

        // Negative cycle test
        for (int i = 0 ; i < g.length ; i++) {
            for (int[] t : g[i]) {
                if (dist[t[0]] != null && dist[i] + t[1] < dist[t[0]]) {
                    dist[0] = null;
                    return dist;
                }
            }
        }

        return dist;
    }


    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        LinkedList<int[]>[] g = new LinkedList[3];
        for (int i = 0 ; i < g.length ; i++)
            g[i] = new LinkedList<>();
        int[] t1 = {1,2};
        int[] t2 = {2,4};
        int[] t3 = {2,1};
        g[0].add(t1);
        g[0].add(t2);
        g[1].add(t3);
        Integer[] dist = BellmanFord(g, 0);
        System.out.println();
        for (int i = 0 ; i < dist.length ; i++) {
            System.out.println("Dist " + i + " -> " + dist[i]);
        }
    }

}
