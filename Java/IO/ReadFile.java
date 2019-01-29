import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.MatchResult;

public class ReadFile {
    Scanner sc;

    /**
     * Constructeur
     * @param src fichier à lire
     */
    ReadFile(String src) {
        File f= new File(src);
        try {
            sc= new Scanner(f);
        } catch (FileNotFoundException e) {
            System.out.println("Can't find file");
            System.exit(1);
        }
    }

    /**
     * Fonction de lecture ligne à ligne
     * Modifier le type retour de la fonction
     */
    void readfile() {
        String line = null
        while(sc.hasNextLine()) {
            line = sc.nextLine();
            readline(line);
        }
        return;
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
