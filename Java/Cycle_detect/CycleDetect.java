package Cycle_detect;

import DFS.PP;

import java.util.LinkedList;

public class CycleDetect {

    /**
     * Détection de cycle
     * @param g tableau de liste d'Integer (liste d'adjacence)
     * @param oriented boolean exprimant si le graphe est orienté ou pas
     * @return true s'il existe un cycle, false sinon.
     */
    public static boolean hasCycle(LinkedList<Integer>[] g, boolean oriented){
        Integer[][] ppc = PP.PPC(g);
        Integer[] begin_time = ppc[0];
        Integer[] end_time = ppc[1];
        Integer[] pi = ppc[2];
        for (int i = 0; i < g.length; i++) {
            for(Integer var : g[i]){
                if(pi[var].equals(i) == false){
                    if(oriented == true || pi[i].equals(var)){
                        if(begin_time[var] < begin_time[i]
                                   && begin_time[i] < end_time[i]
                                   && end_time[i] < end_time[var]){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
