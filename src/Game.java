import java.io.*;
import java.util.Scanner;

/**
 * This is the "main" class (that isn't a Main class, technically). This is designed
 * to host all the elements of a session, including loading saves, hosting level maps and reading
 * from files. This also allows the Main class to remain relatively uncluttered and focused on input/output.
 */
public class Game {
   private Character p;
   private Map m;
   private String userName;
   private final String proPath = System.getProperty("user.dir").substring(0, System.getProperty("user.dir")
	  .indexOf("/src"));
   private boolean newUser;

   public Game (String userName) {
      this.userName = userName;
      this.m = new Map();

      createSaveFile();
      backspace();
      try {
         startGame();
	  } catch (IOException e) {
         System.out.println(e);
	  }
   }

   public void startGame() throws IOException {
      File f = new File(proPath + "/game_txt/tutorial.txt");
      String file_data = "";

      if (!f.exists()) {
		 System.out.println("Error reading tutorial file. Please re-clone the repository from GitHub.");
		 return;
	  }

      if (newUser) {
		 Scanner fileReader = new Scanner(f);

		 while (fileReader.hasNextLine()) {
			file_data += fileReader.nextLine() + "\n";
		 }

		 fileReader.close();
		 format(file_data);
	  } else {

	  }

   }

   /**
	* Locates java file location, then moves to users folder and creates a new User
	* with prompt for user name.
	*/
   private void createSaveFile () {
	  String usrPath = proPath + "/users";

	  if (!userExists(userName)) {
	     newUser = true;
		 try {
			File f = new File(usrPath + "/" + userName + ".json");
			f.createNewFile();

			FileWriter w = new FileWriter(f);
			w.write("{\n \"username\": \""+ userName + "\",\n \"level\":0,\n \"attributes\":\"none\",\n \"coordinates\":[5, 5]\n}");
			w.close();
			System.out.println("New user created.");
		 } catch (IOException e) {
			System.out.println("Error: User Creation Failure. Game will continue without saving.");
		 }
	  }
   }

   private boolean userExists (String user) {
	  String usrPath = proPath + "/users/";

	  File f = new File(usrPath + user + ".json");

	  return f.exists();
   }

   private void printSlightlySlower(String str) {
		 try {
			for (int i = 0; i < str.length() - 1; i++) {
			   Thread.sleep(40);
			   if (str.charAt(i) == '\n') {
				  System.out.println();
				  backspace();
			   } else {
				  System.out.print(str.charAt(i));
			   }
			}
			System.out.println();
			backspace();
		 } catch (Exception InterruptedException) {
		 System.out.println(str);
	  }
   }

   private static void backspace() {
	  for (int i = 0; i < 100; i++)
		 System.out.print("\b");
   }

   private void format (String str) {
	  for (int i = 0; i < 50; i++)
		 System.out.println();

	  if (str.contains("${")) {
		 String mapString = "";
		 String key = str.substring(str.indexOf("{") + 1, str.indexOf("}"));
	     printSlightlySlower(str.substring(0, str.indexOf("${")));
	     System.out.println();

	     if (key.equals("PM")) {
			try {
			   File f = new File(proPath + "/game_txt/maps/map_0.txt");
			   Scanner reader = new Scanner(f);

			   while (reader.hasNextLine()) {
			      	int initialLength = mapString.length();
					mapString += reader.nextLine() + "\n";
					int finalLength = mapString.length();
					for (int i = 0; i < finalLength - initialLength; i++) {
					   mapString += "\b";
					}
			   }

			} catch (IOException e) {
			   System.out.println(e);
			}
		 }

	     System.out.println(mapString);
		 printSlightlySlower(str.substring(str.indexOf("}")));
	  }
   }
}
