import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class InteractiveObject {
   String objectDisplay;
   String typeOfObject;
   int y1, x1, y2, x2, area;

   /*
   constructor for Interactive Object, designed to offload some of the code in Map and simplify
   adding an object to the display.
    */
   public InteractiveObject (String objectDisplay, String typeOfObject, int[] bounds) {
      this.objectDisplay = objectDisplay;
      this.typeOfObject = typeOfObject;
      this.y1 = bounds[0];
      this.x1 = bounds[1];
      this.y2 = bounds[2];
      this.x2 = bounds[3];
      this.area = bounds[4];
   }

   //returns an array of object's basic data, mainly for entering into map and such
   public int[] getLocationData() {
      return new int[] { y1, x1, y2, x2, area };
   }

   //parses the String down to individual characters for printing to the display in Map
   public String[][] parseObject () {
      String[][] indivStrArray;
      LinkedList<String> newLineArray = new LinkedList<String>();
      int colCount = 0;
      int begIndex = 0;

      for (int i = 0; i < objectDisplay.length(); i++) {
         if (objectDisplay.charAt(i) == '\n') {
            colCount += objectDisplay.substring(begIndex, i).length();
            newLineArray.add(0, objectDisplay.substring(begIndex, i));
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






}
