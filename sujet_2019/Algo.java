import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;

public class Algo {


    static LinkedList<Photo>[] separer(Photo[] content){
        LinkedList<Photo>[] res = new LinkedList[2];
        res[0] = new LinkedList<>();
        res[1] = new LinkedList<>();
        for (int i = 0; i < content.length; i++) {
            if(content[i].vertical){
                res[1].addLast(content[i]);
            }
            else res[0].addLast(content[i]);
        }
        return res;
    }

    static boolean haveOneCommun(Picture p1, Picture p2, Picture comp){
        boolean wp1 = false;
        boolean wp2 = false;
        for (String el : comp.tags){
            if(p1.tags.contains(el)) wp1 = true;
            if(p2.tags.contains(el)) wp2 = true;
            if(wp1 && wp2) return true;
        }
        return false;
    }

    static boolean communOne(Picture p, Picture comp){
        for (String el : comp.tags){
            if(p.tags.contains(el)) return true;
        }
        return false;
    }

    static boolean isAdded (LinkedList<Picture> pict, Picture el){
        if (pict.isEmpty()){
            pict.addLast(el);
            return true;
        }

        int rank_to_insert = -1;
        int score_to_beat = 0;

        for (int i = 0; i < pict.size() - 1; i++) {
            Picture p = pict.get(i);
            Picture q = pict.get(i + 1);
            if(haveOneCommun(p, q, el)){
                int actu = 0;
                actu -= Output.scoreLiaison(p, q);
                actu += Output.scoreLiaison(p, el);
                actu += Output.scoreLiaison(el, q);
                if (actu > score_to_beat) {
                    rank_to_insert = i + 1;
                    score_to_beat = actu;
                }
            }
        }

        if (rank_to_insert != -1) {
            pict.add(rank_to_insert, el);
            return (true);
        }

        if(communOne(pict.getFirst(), el)){
            pict.addFirst(el);
            return true;
        }
        if(communOne(pict.getLast(), el)){
            pict.addLast(el);
            return true;
        }
        return false;
    }

    static final int MAX_TURN = 1;

    static LinkedList<Picture> startAlgo(LinkedList<Picture> pict){
        int turn = MAX_TURN;
        LinkedList<Picture> res = new LinkedList<>();
        LinkedList<Picture> tmp = new LinkedList<>();
        while(turn != 0){
            for (Picture el : pict){
                if(! isAdded(res, el)){
                    tmp.addLast(el);
                }
            }
            pict = tmp;
            tmp = new LinkedList<>();
            turn --;
        }
        return res;
    }

    static void simplify(LinkedList<Picture> pict) {
        HashMap<String, Integer> numbers = new HashMap<>();

        for (Picture p : pict) {
            for (String st : p.tags) {
                numbers.put(st, 0);
            }
        }

        for (Picture p : pict) {
            for (String st : p.tags) {
                numbers.put(st, numbers.get(st) + 1);
            }
        }

        Set<String> single_tags = new TreeSet();

        for (String key : numbers.keySet()) {
            int value = numbers.get(key);
            if (value == 1) {
                single_tags.add(key);
            }
        }
        
        for (Picture p : pict) {
            for (int i = 0; i < p.tags.size(); i++) {
                if (single_tags.contains(p.tags.get(i))) {
                    p.tags.remove(i);
                    i--;
                    p.additionnal_point++;
                }
            }
        }
    }

     static LinkedList<Picture> startStupid(Photo[] content) {
        LinkedList<Photo>[] separeted = separer(content);
        LinkedList<Picture> pict = new LinkedList<>();
        for (Photo el : separeted[0]){
            pict.addLast(new Picture(el));
        }
        for (int i = 0; i < separeted[1].size() - 1; i+=2) {
            pict.addLast(new Picture(separeted[1].get(i), separeted[1].get(i+1)));
        }

        System.out.println(pict);
        simplify(pict);
        System.out.println(pict);

        Collections.sort(pict, (Picture a, Picture b) -> b.tags.size() - a.tags.size());
        LinkedList<Picture> res = startAlgo(pict);

        return res;

    }

}
