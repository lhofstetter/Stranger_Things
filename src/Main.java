import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        String input = "";

        System.out.print("Enter your username:");
        input = user.nextLine();

        try {
            String[] cmd = {"/bin/sh", "-c", "stty raw </dev/tty"};
            Runtime.getRuntime().exec(cmd).waitFor();
            //DO NOT DELETE THIS, TAKES INPUT WITHOUT HITTING ENTER!!!

            Game g = new Game(input);

            while (!input.equals("q")) {
                if (System.in.available() > 0)
                    input = (char)System.in.read() + "";
                if (input.equals("w") || input.equals("s") || input.equals("d") || input.equals("a")) {
                    System.out.println(input);
                    input = "";
                    format();
                }
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void format () {
        for (int i = 0; i < 50; i++)
            System.out.print("\b");
    }
}



