import java.io.*;
import java.util.ArrayList;


public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static String move;
    public static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Character tutorial = new Character();
        Character mainCharacter = new Character();

        try {
            tutorial.tutorial();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println(mainCharacter.displayMap());
            for (int i = 0; i < 10; i++) System.out.println();
            move = br.readLine();

            while (!(move.contains("quit"))) {
                 if (Character.level == 2) {
                    System.out.println("Will you: 1. go to Will's house to look for him or 2. go home and ignore Mr.Clarke?");
                    Character.firstDecision();
                } else {
                     for (int i =    0; i < 40; i++) System.out.println();
                     list.add(mainCharacter.roomLabel());
                     list.add(mainCharacter.processMovement(move + " "));
                     System.out.println(list.get(list.size() - 2) + "\n" + list.get(list.size() - 1));
                     for (int i = 0; i < 15; i++) System.out.println();
                 }
                move = br.readLine();
            }

            br.close();
        }
    }
}
