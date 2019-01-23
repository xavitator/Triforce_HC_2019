package DFS;

import java.util.LinkedList;

public class PP {

    private static Integer[] begin_time = null;
    private static Integer[] end_time = null;
    private static Integer[] pi = null;
    private static boolean[] visited = null;
    private static Integer time = null;

    private static Integer[][] return_res_copy(){
        int size = begin_time.length;
        Integer[] end = new Integer[size];
        Integer[] begin = new Integer[size];
        Integer[] npi = new Integer[size];
        for (int i = 0; i < size; i++) {
            begin[i] = begin_time[i];
            end[i] = end_time[i];
            npi[i] = pi[i];
        }
        begin_time = null;
        end_time = null;
        pi = null;
        visited = null;
        time = null;
        Integer[][] res = {begin, end, npi};
        return res;
    }

    private static void init_var(int size){
        if(begin_time == null || end_time == null || time == null || visited == null){
            end_time = new Integer[size];
            begin_time = new Integer[size];
            pi = new Integer[size];
            time = 0;
            visited = new boolean[size];
            for (int i = 0; i < size; i++) {
                begin_time[i] = null;
                end_time[i] = null;
                pi[i] = null;
                visited[i] = false;
            }
        }
    }

    public static Integer[][] make_simple(LinkedList<Integer>[] g, int src){
        init_var(g.length);
        visited[src] = true;
        time++;
        begin_time[src] = time;
        for (Integer var : g[src]){
            if(visited[var] == false){
                pi[var] = src;
                make_simple(g, var);
            }
        }
        time++;
        end_time[src] = time;
        return return_res_copy();
    }

    public static Integer[][] make_complet(LinkedList<Integer>[] g){
        init_var(g.length);
        for(int i = 0; i < g.length; i++){
            if(visited[i] == false){
                make_simple(g, i);
            }
        }
        return return_res_copy();
    }
}
