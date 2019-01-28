package Tri_topo;

import java.util.LinkedList;
import java.util.Stack;

public class TriTopo{

    private static Stack<Integer> stack = null;
    private static boolean[] visited = null;

    private static void PP(LinkedList<Integer>[] g, int src){
        visited[src] = true;
        for (Integer var : g[src]){
            if(visited[var] == false){
                PP(g, var);
            }
        }
        stack.push(src);
    }

    private static void PPC(LinkedList<Integer>[] g){
        visited = new boolean[g.length];
        stack = new Stack<>();
        for(int i = 0; i < g.length; i++){
            if(visited[i] == false){
                PP(g, i);
            }
        }
    }

    /**
     * PPC sur g où on met dans une pile le sommet dès qu'on a fini de parcourir tous ses fils
     * le resultat est obtenu en dépilant la pile
     * @param g tableau de liste d'Integer (liste d'adjacence)
     * @return tableau d'Integer dans l'ordre topologique sur les sommets
     */
    public static Integer[] triTopo(LinkedList<Integer>[] g){
        PPC(g);
        Integer[] res = new Integer[g.length];
        for (int i = 0; i < g.length; i++) {
            res[i] = stack.pop();
        }
        return res;
    }
}