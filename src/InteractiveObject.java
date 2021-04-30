import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;

public class InteractiveObject {
   File objectDisplay;
   String nameOfObject;
   int y1, x1, y2, x2, area;


   /**
    * constructor for objects on the "map", allows easier access to creating an object
    * without having to manually create the area it occupies and which portions of the display
    * the character can't move into now that it's there. Actual objects are stored in the
    * interactive text directory.
    *
    * @param objectDisplay .txt file to be converted to an object on ASCII map
    * @param nameOfObject title of object for files/user interaction
    * @param bounds limits on map to interact with - takes in y1, x1, y2, x2, area array of integers
    */
   public InteractiveObject (File objectDisplay, String nameOfObject, int[] bounds) {
      this.objectDisplay = objectDisplay;
      this.nameOfObject = nameOfObject;
      this.y1 = bounds[0];
      this.x1 = bounds[1];
      this.y2 = bounds[2];
      this.x2 = bounds[3];
      this.area = bounds[4];
   }

   /**
    * returns an array of object's basic data, mainly for entering into map and such
    */
   public int[] getLocationData() {
      return new int[] { y1, x1, y2, x2, area };
   }

   //parses the String down to individual characters for printing to the display in Map
   public String[][] parseObject () {
      String[][] indivStrArray;
      LinkedList<String> newLineArray = new LinkedList<String>();
      int colCount = 0;
      int begIndex = 0;

      String objectDisplayStr = parseObjectFile(objectDisplay);

      for (int i = 0; i < objectDisplayStr.length(); i++) {
         if (objectDisplayStr.charAt(i) == '\n') {
            colCount += objectDisplayStr.substring(begIndex, i).length();
            newLineArray.add(0, objectDisplayStr.substring(begIndex, i));
            begIndex = i;
		 }
	  }

      indivStrArray = new String[newLineArray.size()][colCount];

      for (int i = 0; i < newLineArray.size(); i++) {
         for (int x = 0; x < newLineArray.get(i).length(); x++) {
            indivStrArray[i][x] = newLineArray.get(i).charAt(x) + "";
         }
      }

      return indivStrArray;
   }

   private String parseObjectFile (File f) {
      String convFile = "";

      try {
         FileReader fr = new FileReader(f);

         for (int i = fr.read(); i != -1;) {
            convFile += ((char)i) + "";
         }

      } catch (Exception e) {
         System.out.println("Error in reading object file. Please confirm that all object " +
            ".txt files were downloaded successfully.");
      }

      return convFile;
   }






}
