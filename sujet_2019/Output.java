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

    static int scoreLiaison(Picture p, Picture q) {
        List<String> intersect = q.tags.stream()
                    .filter(p.tags::contains)
                    .collect(Collectors.toList());
        List<String> t1 = privateFrom(q.tags,p.tags);
        List<String> t2 = privateFrom(p.tags,q.tags);

        int i1 = t1.size() + p.additionnal_point;
        int i2 = t2.size() + q.additionnal_point;

        System.out.println(i1);
        System.out.println(i2);

        return (Math.min(Math.min(i1, i2), intersect.size()));
    }


    static int getScore(List<Picture> list) {
        int res = 0;
        for (int i = 1 ; i < list.size(); i++) {
            res += scoreLiaison(list.get(i - 1), list.get(i));
        }
        return res;

    }


    static String getOutput(LinkedList<Picture> pic) {
        String str = Integer.toString(pic.size());
        for (Picture p : pic) {
            str += "\n";
            for (int i = 0 ; i < p.id.length ; i++) {
                if (i == p.id.length-1)
                    str += p.id[i];
                else
                    str += p.id[i] + " ";
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
        score = getScore(pic);
        //System.out.println(content);
        f.write(content);
        f.close();
        System.out.println("Score = "+score + "\n");
    }
}
