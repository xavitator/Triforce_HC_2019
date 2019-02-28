import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        System.out.println("====  PARSER ===");
        ReadFile.setup(args[0]);
        Photo[] content = ReadFile.getContent(); // return Photo[]

        LinkedList<Picture> res = Algo.startStupid(content);
        System.out.println("====  OUTPUT ===");
        Output.writeResult(args[1], res); // Write and print
    }
}
