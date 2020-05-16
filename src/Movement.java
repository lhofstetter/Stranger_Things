/**
 * @deprecated
 * This class controls the movement of the character and performs checks to ensure
 * no overlapping between the character and map "objects".
 * This class is being replaced by the Map, Game,
 * Interactive Object and the Character classes.
 */


/*

public class Movement extends Map {

	public static String[][] tracked = new String[20][25];
	private int currentX = 3;
	private int currentY = 3;

	private int count = 0;

	private int qCounter = 0; //store in Character

	private int currentXR = 4;
	private int currentYAB = 4;

	private int currentXL = 2;

	private int currentYL = 5;

	private int length = tracked[0].length - 1;
	private int height = tracked.length - 1;

	String currentMap = "";


	public Movement() {
	}

	public String processMovement(String str) {
            str = str.charAt(0) + "";
            if (str.contains("w") || str.contains("s") || str.contains("d")
                    || str.contains("a")) {
                move(str);
            }

        return currentMap;
    }


	public void move(String str) {
		if (str.equalsIgnoreCase("w") && currentY - 2 >= 0) {
			if (Character.level == 1 && desk("w")) {
				System.out.println(interact("school"));
			} else if (Character.level == 3 && bed("w")) {
				System.out.println(interact("bed"));
			} else {
				currentY--;
				currentYAB--;
				currentYL--;
			}
		} else if (str.equalsIgnoreCase("d") && currentX + 4 < tracked[0].length) {
			if (Character.level == 1 && desk("d")) {
				System.out.println(interact("school"));
			} else if (Character.level == 3 && bed("d")) {
				System.out.println(interact("bed"));
			} else {
				currentX++;
				currentXR++;
				currentXL++;
			}
		} else if (str.equalsIgnoreCase("s") && currentY + 5 < tracked.length) {
			if (Character.level == 1 && desk("s")) {
				System.out.println(interact("school"));
			} else if (Character.level == 3 && bed("s")) {
				System.out.println(interact("bed"));
			} else {
				currentY++;
				currentYAB++;
				currentYL++;
			}
		} else if (str.equalsIgnoreCase("a") && currentX - 3 >= 0) {
			if (Character.level == 1 && desk("a")) {
				System.out.println(interact("school"));
			} else if (Character.level == 3 && bed("a")) {
				System.out.println(interact("bed"));
			} else {
				currentX--;
				currentXR--;
				currentXL--;
			}
		} else {
			if (hitWall() && !enterOrExit()) {
				System.out.println("Nothing to see here.");
			}
			if (enterOrExit()) {
				Character.level++;
			}

		}
		currentMap = displayMap();
    }

	public String displayMap() {
		String map = "";

		    for (int i = 1; i <= height; i++) {
		        for (int x = 1; x <= length; x++) {
		            tracked[i][x] = " ";
                }
            }

			for (int i = 1; i < height; i++) {
				tracked[i][0] = "|";
				tracked[i][length - 1] = "|";
			}

			for (int i = 0; i < length; i++) {
				tracked[0][i] = "_";
				tracked[height - 1][i] = "_";
			}

			if (Character.level == 1) {
				roomDetails("school");
			} else if (Character.level == 3) {
				roomDetails("will");
			} else if (Character.level == 4) {
				Character.endgameOne();
			}

		tracked[height - 1][0] = "\\";
		tracked[height - 1][length - 1] = "/";
		tracked[0][0] = " ";
		tracked[1][0] = "/";
		tracked[0][length - 1] = " ";
		tracked[1][0] = "/";
		tracked[1][length - 1] = "\\";

		renderCharacter();

			for (int i = 0; i < height; i++) {
				for (int x = 0; x < length; x++) {
					map += tracked[i][x];
				}
				map += "\n";
			}

		return map;

	}

	public void renderCharacter() {
		tracked[currentY][currentX] = "@";
		tracked[currentYAB][currentXR] = "\\";
		tracked[currentYAB][currentX] = "|";
		tracked[currentYAB][currentXL] = "/";
		tracked[currentYL][currentX] = "^";
	}

	public void roomDetails(String room) {
		if (room.equalsIgnoreCase("school") && Character.level == 1) {
			tracked[1][(length - 1) / 2] = "@";
			tracked[2][(length - 1) / 2] = "|";
			tracked[2][((length - 1) / 2) - 1] = "/";
			tracked[2][((length - 1) / 2) + 1] = "\\";
			tracked[3][((length - 1) / 2) - 5] = "┳";
			tracked[3][((length - 1) / 2) + 5] = "┳";
			tracked[13][23] = " ";
			tracked[14][23] = " ";
			tracked[15][23] = " ";

			for (int i = ((length - 1) / 2) - 3; i < ((length - 1) / 2) + 6; i++) {
				tracked[3][i - 1] = "━";
			}

		} else if (room.equalsIgnoreCase("will") && Character.level == 3) {
			for (int i = 3; i < 5; i++) {
				tracked[i][(length - 1) / 4] = "|";
			}

			for (int i = ((length - 1) / 4) + 1; i < ((length - 1) / 3) + 4; i++) {
				tracked[3][i] = "_";
			}

			tracked[4][((length - 1) / 4) + 6] = "|";
			tracked[3][((length - 1) / 4) + 1] = "╮";
			tracked[13][0] = " ";
			tracked[14][0] = " ";
			tracked[15][0] = " ";

		}

	}

	public boolean desk(String move) {
		String[][] arr = new String[5][5];

		for (int i = 0; i < 5; i++) {
			for (int x = 0; x < 5; x++) {
				arr[i][x] = tracked[(currentY - 1) + i][(currentX - 2) + x];
			}
		}

		if (move.equals("w") && (arr[0][2].equals("┳") || arr[0][2].equals("━"))) {
			return true;
		} else if (move.equals("s") && (arr[4][2].equals("┳") || arr[4][2].equals("━"))) {
			return true;
		} else if (move.equals("d")
				&& (arr[2][4].equals("┳") || arr[2][4].equals("━") || (arr[1][4].equals("┳") || arr[1][4].equals("━"))
						|| (arr[3][4].equals("┳") || arr[3][4].equals("━")))) {
			return true;
		} else if (move.equals("a") && (arr[2][0].equals("┳") || arr[2][0].equals("━") || arr[1][1].equals("┳")
				|| arr[1][1].equals("━") || arr[3][1].equals("┳") || arr[3][1].equals("━") || arr[3][3].equals("┳")
				|| arr[3][3].equals("━"))) {
			return true;
		}

		return false;
	}

	public boolean bed(String move) {
		String[][] arr = new String[5][5];

		for (int i = 0; i < 5; i++) {
			for (int x = 0; x < 5; x++) {
				arr[i][x] = tracked[(currentY - 1) + i][(currentX - 2) + x];
			}
		}

		if (move.equals("w") && (arr[0][2].equals("╮") || arr[0][2].equals("_") || arr[0][2].equals("|"))) {
			return true;
		} else if (move.equals("s") && (arr[4][2].equals("╮") || arr[4][2].equals("|") || arr[4][2].equals("_"))) {
			return true;
		} else if (move.equals("d") && (arr[2][4].equals("╮") || arr[2][4].equals("_") || arr[2][4].equals("|")
				|| (arr[1][4].equals("╮") || arr[1][4].equals("_") || arr[1][4].equals("|"))
				|| (arr[3][4].equals("╮") || arr[3][4].equals("_") || arr[3][4].equals("|")))) {
			return true;
		} else if (move.equals("a") && (arr[2][0].equals("|") || arr[2][0].equals("╮") || arr[2][0].equals("|")
				|| arr[1][1].equals("╮") || arr[1][1].equals("_") || arr[1][1].equals("|") || arr[3][1].equals("╮")
				|| arr[3][1].equals("_") || arr[3][1].equals("|") || arr[3][3].equals("╮") || arr[3][3].equals("_")
				|| arr[3][3].equals("|"))) {
			return true;
		}

		return false;

	}

	public String interact(String room) {
		count++;
		if (room.equals("school")) {
			if (qCounter == 0) {
				qCounter++;
				System.out.println("MR. CLARKE: Hello Duncan!\n"
						+ "MR.CLARKE: Did you enjoy the new AV radio in the back room?\n");
				return "MR. CLARKE: Will isn't at school today. Perhaps you could figure out where he is?\n"
						+ "NEW QUEST: Find Will Byers";
			} else {
				if (count % 5 == 0) {
					System.out.println("Remember: You need to go find Will since he was absent today.");
				} else {
					int randomNum = (int) (Math.random() * 3) + 1;
					String[] phrase = { "What's taking you so long?", "Have you found Will yet?",
							"Get a move on, Duncan!", "I'm still waiting...",
							"If Will isn't hiding behind you, then what are you doing here?" };
					System.out.println("Mr.Clarke: " + phrase[randomNum]);
				}
			}
		} else if (room.equals("bed")) {
			if (qCounter == 1) {
				qCounter++;
				return "Will isn't here. Maybe Mrs. Byers can tell me where he is?\nNEW OBJECTIVE: Find Mrs. Byers and Talk to her about Will";
			} else {
				int randomNum = (int) (Math.random() * 2) + 1;
				String[] phrase = { "You'll need to find Mrs. Byers.", "Will isn't here, where's his mom?",
						"Hmmmm...Will doesn't seem to be here" };
				System.out.println(phrase[randomNum]);
			}
		}
		return "";
	}

	public boolean enterOrExit() {
		if ((tracked[14][23].equals(" ") && tracked[14][22].equals("\\")) && Character.level == 1 && qCounter == 1) {
			currentX = 3;
			currentY = 14;

			currentXR = 4;
			currentYAB = 15;

			currentXL = 2;

			currentYL = 16;

			return true;
		}

		return false;
	}

	public boolean hitWall() {
		if (currentY - 4 < 0 || currentX - 3 < 0 || currentX + 5 > tracked[0].length || currentY + 5 >= tracked.length)
			return true;
		return false;
	}



}
*/