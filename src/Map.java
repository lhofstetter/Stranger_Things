public class Map {
    private String[][][] mapData = new String[20][25][2];

    int height = mapData[0].length;
    int length = mapData.length;
    int depth = mapData[0][0].length;


    /**
     * Assembles the "map" (or level) for the user by adding each character to the mapData[][][]
     * array. Uses 3rd dimension to distinguish the actual map "layer" from the "character layer".
     **/
    public void renderMap (String unrenderedMap) {

    }
/*


    public String labelLayer () {
        if (Character.level == 1) {
            return "Mr. Clarke's Classroom";
        } else if (Character.level == 3) {
            return "Will's Bedroom";
        }
        return "";
    }

    /**
     * @deprecated
     * lays over "details" to the level map, adds based on string passed into
     * the function. Will be replaced and broken down into a smaller function
     * that relies on the InteractiveObject class for object placement and data.
     */
    /*
    public void detailLayer (String room) {
        //rendering details for character environment
        if (room.equals("Mr. Clarke's Classroom")) {
            mapData[1][(length - 1) / 2][2] = "@";
            mapData[2][(length - 1) / 2][2] = "|";
            mapData[2][((length - 1) / 2) - 1][2] = "/";
            mapData[2][((length - 1) / 2) + 1][2] = "\\";
            mapData[3][((length - 1) / 2) - 5][2] = "┳";
            mapData[3][((length - 1) / 2) + 5][2] = "┳";
            mapData[13][23][2] = " ";
            mapData[14][23][2] = " ";
            mapData[15][23][2] = " ";

            for (int i = ((length - 1) / 2) - 3; i < ((length - 1) / 2) + 6; i++) {
                mapData[3][i - 1][2] = "━";
            }

        } else if (room.equalsIgnoreCase("Will's Bedroom")) {
            for (int i = 3; i < 5; i++) {
                mapData[i][(length - 1) / 4][2] = "|";
            }

            for (int i = ((length - 1) / 4) + 1; i < ((length - 1) / 3) + 4; i++) {
                mapData[3][i][2] = "_";
            }

            mapData[4][((length - 1) / 4) + 6][2] = "|";
            mapData[3][((length - 1) / 4) + 1][2] = "╮";
            mapData[13][0][2] = " ";
            mapData[14][0][2] = " ";
            mapData[15][0][2] = " ";
        }

        mapData[height - 1][0][2] = "\\";
        mapData[height - 1][length - 1][2] = "/";
        mapData[0][0][2] = " ";
        mapData[1][0][2] = "/";
        mapData[0][length - 1][2] = " ";
        mapData[1][0][2] = "/";
        mapData[1][length - 1][2] = "\\";
    }



    public static boolean addObjectToMap (InteractiveObject obj) {
        int[] locationData = obj.getLocationData();

        for (int i = 0; i < locationData.length; i++) {
            int row = locationData[i];
            int col = locationData[i + 1];

            try {
                System.out.println(mapData[row][col]);
            } catch (Exception e) {
                if (i != locationData.length - 1) {
                    System.out.println("Object location data is invalid. Please re-input and try again.");
                    return false;
                } else {
                    break;
                }
            }
        }



        return true;
    }

*/
}

