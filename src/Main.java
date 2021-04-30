import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        String input = "";

        System.out.print("Enter your username:");
        input = user.nextLine();

        try {
            String[] cmd = {"/bin/sh", "-c", "stty raw </dev/tty"};
            String[] cmd2 = {"/bin/sh", "-c", "stty sane </dev/tty"};

            Runtime.getRuntime().exec(cmd).waitFor();

            Game g = new Game(input);
            backspace();

            while (!input.equals("q")) {
                if (System.in.available() > 0)
                    input = (char)System.in.read() + "";
                if (input.equals("w") || input.equals("s") || input.equals("d") || input.equals("a")) {
                    format();
                    System.out.println(input);
                    backspace();
                    input = "";
                }
            }

            Runtime.getRuntime().exec(cmd2).waitFor();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private static void format () {
        for (int i = 0; i < 50; i++)
            System.out.println();
    }

    private static void backspace() {
        for (int i = 0; i < 50; i++)
            System.out.print("\b");
    }
}



