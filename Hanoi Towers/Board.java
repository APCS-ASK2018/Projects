import java.util.ArrayList;
import java.util.ArrayList;

public class Board
{
    private Tower[] towers = new Tower[3];
    private ArrayList<Event> history;
    private int initialPos, diskCount;
    private boolean trackMoves, printSteps;

    public Board(int startTower, int diskCount) {
        this(startTower, diskCount, true, false);
    }

    public Board(int startTower, int diskCount, boolean recordMoves, boolean printSteps) {
        initialPos = startTower % 3;
        this.diskCount = diskCount;
        trackMoves = recordMoves;
        this.printSteps = printSteps;

        for(int i = 0; i < towers.length; i++)
            towers[i] = new Tower(diskCount);

        for(int i = diskCount; i > 0; i--)
            towers[initialPos].stack(new Disk(i));
    }

    public void moveTo(int destPos) {
        destPos %= 3;
        if(trackMoves) // Takes 2 ^ diskCount - 1 to solve
            history = new ArrayList<>(2 << diskCount);

        if(destPos != initialPos) {
            // For nth disk from the tower
            // If n is odd -> move to destination
            // If n is even -> move to other tower
            for(int i = 0; i < diskCount; i++)
                if((diskCount - i) % 2 == 1) move(initialPos, destPos);
                else move(initialPos, 3 - initialPos - destPos);

            initialPos = destPos;
        }
    }

    private void move(int startPos, int destPos) {
        startPos %= 3;
        destPos %= 3;
        int otherPos = 3 - startPos - destPos;

        Disk d = towers[startPos].pop();
        towers[destPos].stack(d);
        if(trackMoves) history.add(new Event(d, startPos, destPos));
        if(printSteps) System.out.println(this + "\n");

        // If disk being moved is not size 1
        // Move smaller disk on top of itself
        // d.size - i == size of disk to be moved
        for(int i = 1; i < d.size; i++)
            if((d.size - i) % 2 == 1) move(otherPos, destPos);
            else move(otherPos, startPos);
    }

    public ArrayList<Event> getLog() {return history;}
    public void setTracking(boolean track) {trackMoves = track;}
    public void setPrinting(boolean print) {printSteps = print;}

    public String toString() {
        return "Tower0: " + towers[0] +
        "\nTower1: " + towers[1] +
        "\nTower2: " + towers[2];
    }
}
