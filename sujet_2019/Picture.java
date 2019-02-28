import java.util.LinkedList;
import java.util.List;

public class Picture {

    int [] id;
    List<String> tags;


    static List<String> merge_list (List<String> l1, List<String> l2){
        for (String el : l2){
            if (! l1.contains(el)){
                l1.add(el);
            }
        }
        return l1;
    }

    public Picture(Photo h) {
        id = new int[1];
        id[0] = h.id;
        tags = h.tags;
    }

    public Picture(Photo v1, Photo v2) {
        id = new int[2];
        id[0] = v1.id;
        id[1] = v2.id;
        tags = new LinkedList<>();
        tags.addAll(v1.tags);
        tags = merge_list(tags, v2.tags);
    }
}
