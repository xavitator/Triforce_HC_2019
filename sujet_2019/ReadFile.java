import java.awt.*;
import java.io.*;
import java.util.*;

public class ReadFile {
    static Iterator<String> lignes;

    /**
     * Constructeur
     * @param src fichier à lire
     */

    static void setup(String src) {
        try {
            lignes = (new BufferedReader(new InputStreamReader(
                    new FileInputStream(src)
            ))).lines().iterator(); // Itérateur sur les lignes
        } catch(Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    static LinkedList<String> getTags(String[] lines) {
        int nbTags = Integer.parseInt(lines[1]);
        LinkedList<String> tags = new LinkedList<>();
        for (int i = 2 ; i < nbTags +2 ; i++) {
            tags.add(lines[i]);
        }
        return tags;
    }

    static Photo[] getContent() {
        int nb = Integer.parseInt(lignes.next());
        Photo [] res = new Photo[nb];
        for (int i = 0 ; i < nb ; i++) {
            String [] lines = lignes.next().split(" ");
            res[i] = new Photo(i);
            res[i].vertical = lines[0].equals("V");
            res[i].tags = getTags(lines);
            System.out.print("Debug : " + res[i] + "\n");
        }
        return res;
    }



}
