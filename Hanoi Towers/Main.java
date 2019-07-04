import java.util.Scanner;
import java.util.ArrayList;

public class Main
{
    private static Scanner KB = new java.util.Scanner(System.in);
    
    public static void main(String[] args) {
        int diskCount = getNum("How many disks? ");
        int initPos = getNum("Which tower to start (0-2)? ") % 3;
        if(diskCount > 0 && initPos >= 0) {
            int finalPos = getNum("Which tower to end (0-2)? ") % 3;
            boolean trackMoves = getNum("Track moves (0,1)? ") == 1;
            boolean printSteps = getNum("Print moves (0,1)? ") == 1;
            
            Board hanoi = new Board(initPos, diskCount, trackMoves, printSteps);
            System.out.println(hanoi + "\n");
            hanoi.moveTo(finalPos);
            
            if(trackMoves) {
                ArrayList<Event> log = hanoi.getLog();
                for(Event e : log)
                    System.out.println(e);
            }
        }
    }
    
    private static int getNum(String prompt) {
        System.out.print(prompt);
        String input = KB.nextLine();
        while(true)
            try {
                if("stop".equalsIgnoreCase(input)) return -1;
                int value = Integer.parseInt(input);
                assert(value >= 0);
                return value;
            } catch(Throwable e) {
                input = KB.nextLine();
            }
    }
}
