
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;

public class Character {
	public static int level = 0;

	private Point coordinate;

	public Character (int row, int col) {
		coordinate = new Point(row, col);
	}

/*

	public void tutorial() {
		try {
			printSlightlySlower("Welcome to Stranger Things: Will's Disappearance..");
			Thread.sleep(1000);
			printSlightlySlower("It is highly recommended that you watch Stranger Things before playing this game..");
			Thread.sleep(1000);
			printSlightlySlower("With that out of the way, let's introduce you to the game..");
			System.out.println(displayMap());
			printSlightlySlower("This is you. Around you is the current room you are in (the TUTORIAL room)..");
			printSlightlySlower(
					"Let's try moving around a little bit. Use W-A-S-D and \n then hit enter (after each key is entered) to move around. Type 'exit' to leave the \nmovement tutorial..");
			testMovement();
			printSlightlySlower(
					"Now that you've become acquainted with your controls, lets get started with the game..");
			Thread.sleep(2000);
			for (int i = 0; i < 40; i++)
				System.out.println();
		} catch (Exception e) {
			System.out.println(e);
			printSlow("ERROR: INTERRUPTEDEXCEPTION. Please try restarting the program..");
		}
	}

	public static void printSlow(String str) {
		try {
			for (int i = 0; i < str.length() - 1; i++) {
				Thread.sleep(50);
				System.out.print(str.charAt(i));
			}
			System.out.println();
		} catch (Exception InterruptedException) {
			System.out.println(str);
		}
	}

	public void printSlightlySlower(String str) {
		try {
			for (int i = 0; i < str.length() - 1; i++) {
				Thread.sleep(40);
				System.out.print(str.charAt(i));
			}
			System.out.println();
		} catch (Exception InterruptedException) {
			System.out.println(str);
		}
	}

	public void testMovement() {
		Character tutorial = new Character();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String move = br.readLine();
			displayMap();

			while (true) {
				if (move.contains("exit")) {
					level++;
					break;
				} else {
					for (int i = 0; i < 40; i++)
						System.out.println();
					System.out.println(tutorial.processMovement(move + " "));
					for (int i = 0; i < 14; i++)
						System.out.println();
					move = br.readLine();
				}
			}
		} catch (Exception IOException) {
			printSlow("ERROR: IOException in BufferReader. Please try restarting the program. (Error Code: C-TM");
		}
	}

	public static void firstDecision () {
	try {
		Main.move = Main.br.readLine();

		if (Main.move.contains("1")) {
			System.out.println("You will go to Will's house.");
			Thread.sleep(2000);
			level++;
		} else if (Main.move.contains("2")) {
			System.out.println("You will go home.");
			Thread.sleep(2000);
			level += 2;
		}
	} catch (Exception e) {
		System.out.println(e);
	}

	}

	public String roomLabel() {
		if (Character.level == 1) {
			return "Mr. Clarke's Classroom";
		} else if (Character.level == 3) {
			return "Will's Bedroom";
		}
		return "";
	}

	public static void endgameOne() {
		try {
			printSlow(
					"You chose to go home and forget about Mr. Clarke's request, choosing yourself \nover your best friend Will..");
			Thread.sleep(100);
			printSlow(
					"Despite the desperate cries of your friends to help save him, you \ncontinued to ignore their needs and worry only about yourself..");
			printSlow("Will's body was found several days later in the lake near Hawkins.");
			Thread.sleep(100);
			printSlow(
					"Because of your selfishness, your best friends Mike and Lucas \nblamed you and soon stopped speaking to you entirely..");
			printSlow(
					"Many years later, you still wished you would have \nput their needs before your own.. If only there was a way of turning back time......");
			printSlow("THE END..");

			System.out.println();
			Main.move = "quit";
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Fix 'endgameOne' in Character class.");
		}
	}

	private Point[] bodyCoords(Point headCoordinate) {
	   int row = headCoordinate.getY();
	   int col = headCoordinate.getX();

	   Point rArm = new Point(col + 1, row + 1);
	   Point lArm = new Point(col - 1, row + 1);
	   Point rLeg = new Point(col + 1, row + 2);
	   Point lLeg = new Point(col - 1, row + 2);
	   Point body = new Point(col, row - 1);

	   return new Point[] { rArm, lArm, rLeg, lLeg, body };
	}


*/


}


