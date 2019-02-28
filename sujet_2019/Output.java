import java.util.LinkedList;

public class Output {

    static int score = 0;

    static LinkedList<String> out = new LinkedList<>();

    /**
     * Add instruction to the list of instruction
     * @param id id du drone
     * @param cmd action exécutée par le drone
     * @param dest id de destination -> si l'action est 'Deliver', c'est l'id du client, sinon c'est celle de l'entrepot
     * @param product id du produit
     * @param number nombre de produit délivré
     */
    static void addInstruction (int id, Command cmd, int dest, int product, int number){
        String str;
        switch (cmd){
            case Load:str = "L"; break;
            case Unload: str = "U"; break;
            case Deliver:
                str = "D";
                break;
            default: str = "";
        }
        String res = id + " " + str + " " + dest + " " + product + " " + number;
        out.addLast(res);
    }

    /**
     * Ajout de l'action Wait dans le output
     * @param id id du drone dont l'action est d'attendre
     * @param tour tour en cours
     */
    static void addWaitInstruction (int id, int tour){
      String res = id + " W " + tour;
      out.addLast(res);
    }

    /**
     * mise à jour du score en fonction du tour
     * @param turn tour en cours
     */
	static void updateScore(int turn) {
		score += ((Main.deadline - turn) * 100) / Main.deadline;
		System.out.println("dump score " + score);
	}

    /**
     * Fonction d'écriture du résultat dans le fichier de sortie donné en paramètre
     * @param file nom du fichier de sortie
     */
    static void writeResult (String file){
        WriteFile f = new WriteFile(file);
        int nb = out.size();
        f.write(nb+"\n");
        for(String str : out){
            f.write(str + "\n");
        }
        f.close();
        System.out.println("Score = "+score + "\n");
    }
}
