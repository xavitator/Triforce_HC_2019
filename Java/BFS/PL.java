package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class PL {

    /**
     * @param g tableau de liste d'Integer (liste d'adjacence)
     * @param src id de la source
     * @return [ {tableau distance},{tableau parent id} ]
     */
    public static Integer[][] PL (LinkedList<Integer>[] g, int src){
        int size = g.length;
        Integer[] pi = new Integer[size];
        Integer[] distance = new Integer[size];
        boolean[] visited = new boolean[size];
        Queue<Integer> fifo = new LinkedBlockingDeque<>();
        for(int i = 0; i < size; i++){
            pi[i] = null;
            distance[i] = null;
            visited[i] = false;
        }
        pi[src] = null;
        distance[src] = 0;
        visited[src] = true;
        fifo.add(src);
        Integer x;
        while((x = fifo.poll()) != null){
            for (Integer var : g[x]){
                if(visited[var] == false){
                    visited[var] = true;
                    distance[var] = distance[x] + 1;
                    pi[var] = x;
                    fifo.add(var);
                }
            }
        }
        Integer[][] res = {distance, pi};
        return res;
    }
}
