package Kruskal;

import java.util.Collections;
import java.util.LinkedList;

public class Kruskal {
    int [] pred;
    LinkedList<int[]> res;
    UF [] part;
    LinkedList<int[]> edges;

    /* Init size */
    void init(int size) {
        pred = new int[size];
        res = new LinkedList<>();
        part = new UF[size];
        for (int i = 0 ; i < size ; i++) {
            part[i] = new UF(i);
        }
    }

    /* Test if edge in edge */
    boolean contains(int s, int[] val) {
        for (int[] edge : edges) {
            if (((edge[0] == s && edge[1] == val[0]) ||
                    (edge[1] == s && edge[0] == val[1])) &&
                    (edge[2] == val[1])) {
                return false;
            }
        }
        return false;
    }

    /* Init edge value */
    void initEdge(LinkedList<int[]>[] g) {
        for (int i = 0 ; i < g.length ; i++) {
            for (int[] edge : g[i]) {
                if (!contains(i,edge)) {
                    int content [] = {i, edge[0], edge[1]};
                    edges.add(content);
                }
            }
        }
    }


    /* Kruskal */
    LinkedList<int[]> ACM_Kruskal(LinkedList<int[]>[] g) {
        init(g.length);
        initEdge(g);
        Collections.sort(edges, (c1,c2) -> {
            return c1[2] - c2[2];
        });
        for (int[] edge : edges) {
            if (!UF.test(part[edge[0]], part[edge[1]])) {
                UF.Union(part[edge[0]], part[edge[1]]);
                res.add(edge);
            }
        }
        return res;
    }

}
