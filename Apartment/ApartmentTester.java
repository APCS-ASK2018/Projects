
public class ApartmentTester
{
    public static void main(String[] args) {
        final int ROW = 9, COLUMN = 3;
        Apartment[][] building = new Apartment[ROW][COLUMN];

        for(Apartment[] row : building)
            for(int i = 0; i < row.length; i++) row[i] = new Apartment();
        
        System.out.println("Original Apt");
        printGrid(building);
        System.out.println();
        
        System.out.println("Total occupants: " + totalOccupancy(building));
        System.out.println();
        
        System.out.println("Making roommates...");
        makeRoommates(building);
        printGrid(building);
        System.out.println();
        
        System.out.println("Recounting total occupants...");
        System.out.println("Total occupants: " + totalOccupancy(building));
    }
    
    /**
     * Return sum of all occupancy in apt
     * @param apt = 2D array of apartment
     * 
     * PreCondition: apt is non-null, occupancy are always non-negative,
     *               sum does not cause int overflow
     * PostCondition: return int value that sums the total occupants
     */
    private static int totalOccupancy(Apartment[][] apt) {
        /* 1 statement solution outside AP subset (java.util.stream.*)
         * return Stream.of(apt).flatMap(Stream::of)
         *  .mapToInt(Apartment::getOccupancy)
         *  .sum();
         */
        int total = 0;
        for(Apartment[] row : apt)
            for(Apartment a : row)
                if(a != null) total += a.getOccupancy();
        return total;
    }
    
    /**
     * Pair singles into roommates, making one of the objects null
     * @param apt 2D array of Apartment
     * 
     * PreCondition: apt is non-null 2D array with non-null rows
     * PostCondition: Singles are paired, leftover and non-singles untouched
     */
    private static void makeRoommates(Apartment[][] apt) {
        int[] lastPos = {-1, -1};
        for(int i = 0; i < apt.length; i++)
            for(int j = 0; j < apt[i].length; j++)
                // Loop through apt
                if(apt[i][j] != null && apt[i][j].getOwner().equals("single"))
                    if(lastPos[0] < 0) {
                        // If no unpaired apartment, save pos of this apartment
                        lastPos[0] = i;
                        lastPos[1] = j;
                    } else {
                        // Have previously unpaired apartment
                        // Set old to null
                        // Set this to roommates
                        // Clear old record
                        apt[lastPos[0]][lastPos[1]] = null;
                        apt[i][j].setOwner("roommates");
                        lastPos[0] = -1;
                    };
    }
    
    /**
     * Print a 2D object to console
     * Not part of assessment, so going out of AP subset is ok, right?
     */
    private static <T> void printGrid(T[][] grid) {
        for(T[] row : grid) {
            String line = java.util.Arrays.toString(row);
            String highlighted = line.replace("single", "*single*")
                                     .replace("roommates", "*roommates*")
                                     .replace("null", "*null*");
            System.out.println(highlighted);
        }
    }
}
