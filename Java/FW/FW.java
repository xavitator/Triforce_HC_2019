public class FW{

    // Ici null correspond à une distance infinie entre deux sommets

    public static boolean hasNegCycle = false;

    private static boolean compare(Integer a, Integer b, Integer c){
        Integer sum = (b == null || c == null)? null : b + c;
        if (sum == null)
            return false;
        return (a == null) || (a > sum);
    }

    /**
     * @param graphe matrice contenant null si les sommets i et j ne sont pas reliés, et
     *               la distance entre i et j sinon.
     * @return [distance entre les sommets, arbre des parents]
     */
    public static Integer[][][] floydWarshall(Integer[][] graphe){
        int nsommets = graphe.length;
        Integer[][] dist = new Integer[nsommets][nsommets];
        Integer[][] pi = new Integer[nsommets][nsommets];
        for (int i = 0; i < nsommets; i++) {
            for (int j = 0; j < nsommets; j++) {
                dist[i][j] = graphe[i][j];
                if(graphe[i][j] != null) pi[i][j] = i;
            }
        }
        for (int k = 0; k < nsommets; k++) {
            for (int i = 0; i < nsommets; i++) {
                for (int j = 0; j < nsommets; j++) {
                    if(compare(dist[i][j], dist[i][k], dist[k][j])){
                        dist[i][j] = dist[i][k] + dist[k][j];
                        pi[i][j] = pi[k][j];
                    }
                }
            }
        }

        hasNegCycle = false;
        for (int i = 0; i < nsommets; i++) {
            if(dist[i][i] < 0) {
                hasNegCycle = true;
                break;
            }
        }
        Integer[][][] res = {dist, pi};
        return res;
    }
}