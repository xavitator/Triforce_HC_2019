package Dijkstra;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.LinkedList;

public class Dijkstra {

    /**
     * @param g tableau de liste de tuple d'Integer (liste d'adjacence de [i,j] avec i = id du noeud suivant, j le poids de l'arête)
     * @param src noeud source
     * @return [ {tableau distance}, {tableau des parents id} ]
     */
    public static Integer[][] dijkstra(LinkedList<int[]>[] g, int src) {

        // initialisation
        int size = g.length;
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] i1, int[] i2) {
                return i1[1] - i2[1];
            }
        });
        Integer[] distance = new Integer[size];
        Integer[] pi = new Integer[size];
        boolean[] blank = new boolean[size];
        for (int i = 0; i < size; i++) {
            distance[i] = null;
            pi[i] = null;
            blank[i] = false;
        }

        // contenu de l'algo
        distance[src] = 0;
        pi[src] = null;
        int[] element = { src, 0 };
        int s;
        int[] h;
        queue.add(element);
        while ((h = queue.poll()) != null) {
            s = h[0];
            blank[s] = true;
            for (int[] var : g[s]) {
                if (blank[var[0]] == false) {
                    if (distance[var[0]] == null || distance[s] + var[1] < distance[var[0]]) {
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
