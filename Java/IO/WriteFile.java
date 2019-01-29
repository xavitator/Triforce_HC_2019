import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {

    File output;
    FileWriter writer;
    BufferedWriter buff;

    /**
     * Constructeur de l'écrivain
     * @param target le fichier dans lequel écrire
     */
    WriteFile (String target) {
        FileWriter writer = null;
        try {
            output = new File(target);
            output.createNewFile();
            writer = new FileWriter(output);
        } catch (Exception e) {
            System.out.println("File creation error: " + e.getMessage());
        }
        buff = new BufferedWriter(writer);
    }

    /**
     * Fonction d'écriture
     * @param content le contenu à écrire dans target
     */
    void write (String content) {
        try {
            buff.write(content);
        } catch (Exception e) {
            System.out.println("Writing error : " + e.getMessage());
        }
    }

    /**
     * Ferme les fichiers et le buffer
     */
    void close() {
        try {
            if (buff != null)
                buff.close();
            if (writer != null)
                writer.close();
        } catch (IOException ex) {
            System.out.println("Closing error");
        }
    }


    public static void main(String[] args) {
        WriteFile f = new WriteFile("test.txt");
        String content = "Hello\n Bye !!!";
        f.write(content);
        f.close();
    }


}
