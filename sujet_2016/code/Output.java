import java.util.LinkedList;

public class Output {

    static LinkedList<String> out = new LinkedList<>();

    static void addInstruction (int id, Command cmd, int dest, int product, int number){
        String str;
        switch (cmd){
            case Load:str = "L"; break;
            case Unload: str = "U"; break;
            case Deliver:str = "D"; break;
            default: str = "";
        }
        String res = id + " " + str + " " + dest + " " + product + " " + number;
        out.addLast(res);
    }

    static void addWaitInstruction (int id, int turn){
      String res = id + " W " + turn;
      out.addLast(res);
    }

    static void writeResult (String file){
        WriteFile file = new WriteFile(file);
        int nb = out.size();
        file.write(nb+"\n");
        for(String str : out){
            file.write(str + "\n");
        }
        file.close();
    }
}
