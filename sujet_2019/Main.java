public class Main {

    public static void main(String[] args) {
        System.out.println("====  PARSER ===");
        ReadFile.setup(args[0]);
        ReadFile.getContent(); // return Photo[]

        System.out.println("====  OUTPUT ===");
        Output.writeResult(args[1], null); // Write and print
    }
}
