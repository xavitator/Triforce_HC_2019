import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.MatchResult;

public class ReadFile {
    static List<String> lignes = null;

    /**
     * Constructeur
     * @param src fichier à lire
     */
    ReadFile(String src) {
        try {
    		lignes = Files.readAllLines(Paths.get(new File(src).getAbsolutePath()));
        } catch (IOException e) {
            System.out.println("Can't find file or read it");
            System.exit(1);
        }
    }

    /**
     * Fonction de lecture ligne à ligne
     * Modifier le type retour de la fonction
     */
    void readfile() {
        for(String line : lignes) {
            readline(line);
        }
    }

    /**
     * Fonction qui lit une ligne avec une
     * regex
     * @param line la ligne à lire
     */
    void readline(String line) {
        Scanner tmp = new Scanner(line);
        tmp.findInLine("REGEX");
        MatchResult match = tmp.match();
        return;
    }


}
