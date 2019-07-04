package Program.Locations;

/**
 * Locations class simply stores each room as an object
 * so the same copy can be accessed again
 */
public class Regions
{
    public static Outside outside; // Had to make this public for resetting player data
    protected static BottomHall bottomHall;
    protected static LeftRoom leftRoom;
    protected static MazeRoom maze;
    protected static UpHall upHall;
    protected static Bedroom bedroom;
    
    public static void resetRegions() {
        outside = new Outside();
        bottomHall = new BottomHall();
        leftRoom = new LeftRoom();
        maze = new MazeRoom();
        upHall = new UpHall();
        bedroom = new Bedroom();
    }
}
