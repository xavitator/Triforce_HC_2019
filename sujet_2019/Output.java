import java.util.LinkedList;

public class Output {

    static int score = 0;

    static LinkedList<String> out = new LinkedList<>();

    static String getOutput(LinkedList<Picture> pic) {
        String str = Integer.toString(pic.size());
        for (Picture p : pic) {
            str += "\n";
            for (int i = 0 ; i < p.id.length ; i++) {
                str += p.id[i] + " ";
                if (i == p.id.length-1)
                    str += p.id[i];
            }
        }
        return str;
    }



    /**
     * Fonction d'écriture du résultat dans le fichier de sortie donné en paramètre
     * @param file nom du fichier de sortie
     */
    static void writeResult (String file, LinkedList<Picture> pic){
        WriteFile f = new WriteFile(file);
        f.write(getOutput(pic));
        f.close();
        System.out.println("Score = "+score + "\n");
    }
}
