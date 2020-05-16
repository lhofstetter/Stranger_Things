/**
 * This is the "Main" class (that isn't a Main class, technically). This is designed
 * to host all the elements of a session, including loading saves, hosting level maps and reading
 * from files. This also allow the Main class to remain relatively uncluttered and focused on input/output.
 */

import java.io.File;
import java.io.IOException;

public class Game {
   private Character p;
   private Map m;
   private String userName;
   private String proPath = System.getProperty("user.dir").substring(0, System.getProperty("user.dir")
	  .indexOf("/src"));;

   public Game (String userName) {
      this.userName = userName;

      createSaveFile();
   }

   public void startGame() {

   }

   /**
	* Locates java file location, then moves to users folder and creates a new User
	* with prompt for user name.
	*/
   private void createSaveFile () {
	  String usrPath = proPath + "/users";

	  if (!userExists(userName)) {
		 try {
			File f = new File(usrPath + "/" + userName + ".csv");

			f.createNewFile();
		 } catch (IOException e) {
			System.out.println("Error: User Creation Failure. Game will continue without saving.");
		 }
	  }
   }

   private boolean userExists (String user) {
	  String usrPath = proPath + "/users";

	  File f = new File(usrPath + "/" + user + ".csv");

	  return f.exists();
   }
}
