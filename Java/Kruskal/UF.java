package Kruskal;

public class UF {
    int elt;
    int poids;
    UF parent;

    public UF(int s) {
        this.elt = s;
        this.poids = 0;
    }


    /**
     * @return true if it's a root
     */
    boolean isRoot() {
        return this.equals(parent);
    }

    /**
     * Join two structures together
     * @param s1 Union-Find
     * @param s2 Union-Find
     * @return the parent root
     */
    static UF Link(UF s1, UF s2) {
        if (s1.poids > s2.poids) {
            s2.parent = s1;
            return s1;
        } else {
            s1.parent = s2;
            if (s1.poids == s2.poids)
                s2.poids += 1;
            return s2;
        }
    }

    /*
    Give the head of the structure
 */
    UF find() {
        if (isRoot())
            return this;
        return  parent.find();
    }


    /* Fusion of two Unoion-Find */
    static void Union(UF s1, UF s2) {
        Link(s1.find(), s2.find());
    }

    /* Test if two UF have the same root */
    static boolean test(UF s1, UF s2) {
        return  s1.find().equals(s2.find());
    }


}