import java.util.LinkedList;

public class Graphe {

    public int[][] matrix_nv = NULL;

    public LinkedList<Integer>[] list_adjacence_nv = NULL;

    public Integer[][] matrix_wv = NULL;

    public LinkedList<int[]>[] list_adjacence_wv = NULL;

    public Graphe(boolean matrix, boolean valued, int size) {
        if (matrix && valued) {
            matrix_wv = new Integer[size][size];
        } else if (matrix) {
            matrix_nv = new int[size][size];
        } else if (valued) {
            list_adjacence_wv = new LinkedList<>[size];
        } else {
            list_adjacence_nv = new LinkedList<>[size];
        }
    }

    public void add_value_matrix(int source, int dest, int value) {
        if (matrix_wv == NULL)
            throw new Exception("matrix with value doesn't exist\n");
        matrix_wv[source][dest] = value;
    }

    public void add_value_list(int source, int dest, int value) {
        if (list_adjacence_wv == NULL)
            throw new Exception("liste d'adjacence with value doesn't exist\n");
        int[] element = { dest, value };
        list_adjacence_wv[source].addLast(element);
    }

    public void add_node_matrix_nv(int source, int dest) {
        if (matrix_nv == NULL)
            throw new Exception("matrix with no value doesn't exist\n");
        matrix_nv[source][dest] = 1;
    }

    public void add_node_list_nv(int source, int dest) {
        if (list_adjacence_nv == NULL)
            throw new Exception("liste d'adjacence with no value doesn't exist\n");
        list_adjacence_nv[source].addLast(dest);
    }

    public void transfer_matrix_list() {
        if (matrix_nv != NULL) {
            if (list_adjacence_nv == NULL) {
                list_adjacence_nv = new LinkedList<>[matrix_nv.length];
                for (int i = 0; i < matrix_nv.length; i++) {
                    for (int j = 0; j < matrix_nv[i].length; j++) {
                        if (matrix_nv[i][j] == 1)
                            add_node_list_nv(i, j);
                    }
                }
            }
        }
        if (list_adjacence_nv != NULL) {
            if (matrix_nv == NULL) {
                matrix_nv = new int[list_adjacence_nv.length][list_adjacence_nv.length];
                for (int i = 0; i < list_adjacence_nv.length; i++) {
                    for (Integer var : list_adjacence_nv[i]) {
                        add_node_matrix_nv(i, var);
                    }
                }
            }
        }
        if (matrix_wv != NULL) {
            if (list_adjacence_wv == NULL) {
                list_adjacence_wv = new LinkedList<>[matrix_wv.length];
                for (int i = 0; i < matrix_wv.length; i++) {
                    for (int j = 0; j < matrix_wv[i].length; j++) {
                        if (matrix_wv[i][j] != NULL)
                            add_value_list(i, j, matrix_wv[i][j]);
                    }
                }
            }
        }
        if (list_adjacence_wv != NULL) {
            if (matrix_wv == NULL) {
                matrix_wv = new int[list_adjacence_wv.length][list_adjacence_wv.length];
                for (int i = 0; i < list_adjacence_wv.length; i++) {
                    for (int[] var : list_adjacence_wv[i]) {
                        add_value_matrix(i, var[0], var[1]);
                    }
                }
            }
        }
    }

}