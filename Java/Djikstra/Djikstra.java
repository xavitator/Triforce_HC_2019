import java.util.Comparator;
import java.util.PriorityQueue;
import Graphe.Graphe;

public static class Djikstra {

    PriorityQueue<int[]> queue = NULL;
    Integer[] distance = NULL;
    Integer[] pi = NULL;
    boolean[] blank = NULL;

    public Djikstra(int size) {
        queue = PriorityQueue(new Comparator<int[]>() {
            public int compare(int[] i1, int[] i2) {
                return i1[1] - i2[1];
            }
        });
        distance = new Integer[size];
        pi = new Integer[size];
        blank = new boolean[size];
    }

    public Integer[][] make_djikstra(Graphe g, int src) {
        distance[src] = 0;
        pi[src] = NULL;
        int[] element = { src, 0 };
        int d;
        int s;
        int[] h;
        if (g.list_adjacence_wv == NULL) {
            if (matrix_wv != NULL)
                g.transfer_matrix_list();
            else
                throw Exception("graphe non valué");
        }
        LinkedList<int[]>[] list = g.list_adjacence_wv;
        queue.add(element);
        while ((h = queue.poll()) != NULL) {
            s = h[0];
            d = h[1];
            blank[s] = true;
            for (int[] var : list) {
                if (blank[var[0]] == false) {
                    if (distance[var[0]] == NULL || distance[s] + var[1] < distance[var[0]]) {
                        distance[var[0]] = distance[s] + var[1];
                        pi[var[0]] = s;
                    }
                    queue.add(var);
                }
            }
        }
        Integer[][] res = { distance, pi };
        return res;
    }
}