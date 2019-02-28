import java.util.List;

public class Photo {
    int id;
    boolean vertical ;
    List<String> tags;


    public Photo(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "id : " + Integer.toString(id) + ((vertical)?" V ":" H ") + " tags : " + tags.toString();
    }

}
