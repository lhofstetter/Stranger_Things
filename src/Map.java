public class Map {
    int level;
    public static String[][] mapData = new String[20][25];
    String currentMap;

    int height = mapData[0].length;
    int length = mapData.length;

    public void renderMap () {
            String map = labelLayer() + "\n";

            for (int i = 1; i <= height; i++) {
                for (int x = 1; x <= length; x++) {
                    mapData[i][x] = " ";
                }
            }

            for (int i = 1; i < height; i++) {
                mapData[i][0] = "|";
                mapData[i][length - 1] = "|";
            }

            for (int i = 0; i < length; i++) {
                mapData[0][i] = "_";
                mapData[height - 1][i] = "_";
            }

            detailLayer(labelLayer());

            for (int i = 0; i < height; i++) {
                for (int x = 0; x < length; x++) {
                    map += mapData[i][x];
                }
                map += "\n";
            }

            currentMap = map;
    }



    public String labelLayer () {
        if (Character.level == 1) {
            return "Mr. Clarke's Classroom";
        } else if (Character.level == 3) {
            return "Will's Bedroom";
        }
        return "";
    }

    /*
     lays over "details" to the level map, adds based on string passed into
    the function. Will be replaced and broken down into smaller functions and data pushed
    into other JSON/txt files
     */
    public void detailLayer (String room) {
        //rendering details for character environment
        if (room.equals("Mr. Clarke's Classroom")) {
            mapData[1][(length - 1) / 2] = "@";
            mapData[2][(length - 1) / 2] = "|";
            mapData[2][((length - 1) / 2) - 1] = "/";
            mapData[2][((length - 1) / 2) + 1] = "\\";
            mapData[3][((length - 1) / 2) - 5] = "┳";
            mapData[3][((length - 1) / 2) + 5] = "┳";
            mapData[13][23] = " ";
            mapData[14][23] = " ";
            mapData[15][23] = " ";

            for (int i = ((length - 1) / 2) - 3; i < ((length - 1) / 2) + 6; i++) {
                mapData[3][i - 1] = "━";
            }

        } else if (room.equalsIgnoreCase("Will's Bedroom")) {
            for (int i = 3; i < 5; i++) {
                mapData[i][(length - 1) / 4] = "|";
            }

            for (int i = ((length - 1) / 4) + 1; i < ((length - 1) / 3) + 4; i++) {
                mapData[3][i] = "_";
            }

            mapData[4][((length - 1) / 4) + 6] = "|";
            mapData[3][((length - 1) / 4) + 1] = "╮";
            mapData[13][0] = " ";
            mapData[14][0] = " ";
            mapData[15][0] = " ";
        }

        mapData[height - 1][0] = "\\";
        mapData[height - 1][length - 1] = "/";
        mapData[0][0] = " ";
        mapData[1][0] = "/";
        mapData[0][length - 1] = " ";
        mapData[1][0] = "/";
        mapData[1][length - 1] = "\\";

    }

    public static boolean mapVerification () {
        for (int i = 0; i < mapData.length; i++) {
            for (int x = 0; x < mapData[i].length; x++) {
                if (!Movement.tracked[i][x].equals(" ") && !mapData[i][x].equals(" ")) return true;
            }
        }

        return false;
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
                    System.out.println("Object location data is invalid. Please reinput and try again.");
                    return false;
                } else {
                    break;
                }
            }
        }



        return true;
    }


}
