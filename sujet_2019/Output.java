import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Output {

    static int score = 0;

    static LinkedList<String> out = new LinkedList<>();

    static List<String> privateFrom(List<String> l1, List<String> l2) {
        List<String> res = new LinkedList<>();
        for (String s : l1) {
            if (!l2.contains(s))
                res.add(s);
        }
        return res;
    }


    static int getScore(List<Picture> list) {
        int res = 0;
        for (int i = 1 ; i < list.size(); i++) {
            List<String> intersect = list.get(i).tags.stream()
                    .filter(list.get(i-1).tags::contains)
                    .collect(Collectors.toList());
            List<String> t1 = privateFrom(list.get(i).tags,list.get(i-1).tags);
            List<String> t2 = privateFrom(list.get(i-1).tags,list.get(i).tags);
            res += Math.min(Math.min(t1.size(), t2.size()), intersect.size());
        }
        return res;

    }


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
        String content = getOutput(pic);
        System.out.println(content);
        f.write(content);
        f.close();
        System.out.println("Score = "+score + "\n");
    }
}
