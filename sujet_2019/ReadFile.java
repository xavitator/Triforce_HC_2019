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

    

}
