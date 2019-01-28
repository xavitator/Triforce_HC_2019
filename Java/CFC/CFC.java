package CFC;

import java.util.LinkedList;
import java.util.Stack;

public class CFC{

    private static Stack<Integer> stack = null;
    private static boolean[] visited = null;
    private static LinkedList<LinkedList<Integer>> cfc = null;
    private static int indice = 0;

    private static void PP(LinkedList<Integer>[] g, int src, boolean makecfc){
        visited[src] = true;
        if(makecfc) cfc.get(indice).add(src);
        for (Integer var : g[src]){
            if(visited[var] == false){
                PP(g, var, makecfc);
            }
        }
        stack.push(src);
    }

    private static void PPC(LinkedList<Integer>[] g, boolean makecfc){
        visited = new boolean[g.length];
        stack = new Stack<>();
        for(int i = 0; i < g.length; i++){
            if(visited[i] == false){
                PP(g, i, makecfc);
                if(makecfc) indice++;
            }
        }
    }

    /**
     * On transpose un graphe donné en argument
     * @param g graphe
     * @return transposée du graphe
     */
    public static LinkedList<Integer>[] transposeGraphe(LinkedList<Integer>[] g){
        LinkedList<Integer>[] transpose = new LinkedList[g.length];
        for (int i = 0; i < g.length; i++) {
            transpose[i] = new LinkedList<>();
        }
        for (int i = 0; i < g.length; i++) {
            for (Integer var : g[i]){
                transpose[var].add(i);
            }
        }
        return transpose;
    }



    /**
     * Renvoie une liste de liste contenant les sommets dans une même cfc.
     *
     * @param g tableau de liste d'Integer (liste d'adjacence)
     * @return CFC sous forme de liste de liste des sommets d'une même CFC
     */
    public static LinkedList<LinkedList<Integer>> getCFC(LinkedList<Integer>[] g){
        PPC(g, false);
        LinkedList<Integer>[] ng = new LinkedList[g.length];
        for (int i = g.length - 1; i >= 0; i--) {
            ng[i] = g[stack.pop()];
        }
        LinkedList<Integer>[] transpose = transposeGraphe(ng);
        cfc = new LinkedList<>();
        indice = 0;
        PPC(transpose, true);
        return cfc;
    }

}