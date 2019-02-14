import java.util.LinkedList;

public class Output {

    static int score = 0;

    static LinkedList<String> out = new LinkedList<>();

    static void addInstruction (int id, Command cmd, int dest, int product, int number){
        String str;
        switch (cmd){
            case Load:str = "L"; break;
            case Unload: str = "U"; break;
            case Deliver:
                str = "D";
                break;
            default: str = "";
        }
        String res = id + " " + str + " " + dest + " " + product + " " + number;
        out.addLast(res);
    }

    static void addWaitInstruction (int id, int tour){
      String res = id + " W " + tour;
      out.addLast(res);
    }

	static void updateScore(int turn) {
		score += ((Main.deadline - turn) * 100) / Main.deadline;
		System.out.println("dump score " + score);
	}

    static void writeResult (String file){
        WriteFile f = new WriteFile(file);
        int nb = out.size();
        f.write(nb+"\n");
        for(String str : out){
            f.write(str + "\n");
        }
        f.close();
        System.out.println("Score = "+score + "\n");
    }
}
