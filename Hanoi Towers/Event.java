
/**
 * Write a description of class History here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Event
{
    final int size, fromTower, toTower;
    
    public Event(Disk disk, int startPos, int endPos) {
        size = disk.size;
        fromTower = startPos;
        toTower = endPos;
    }
    
    public String toString() {
        return "Moved Disk (" + size + ") from Tower#" + fromTower
        + " to Tower#" + toTower;
    }
}
