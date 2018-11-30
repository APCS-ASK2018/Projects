import java.util.Scanner;

public class RPSRunner
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        RPS game = new RPS();
        boolean keepPlaying = true;
        
        while(keepPlaying) {
            System.out.println("Rock-Paper-Scissors - pick your weapon! [R,P,S] ");
        
            while ( !game.parseInput( sc.nextLine().charAt(0) ) ) {
                System.out.println("Invalid input! Select from [R,P,S] only!");
            }
            
            game.play();
            game.printResult();
            
            System.out.println("Do you wish to keep playing? [Y,N] ");
            char keepPlay = sc.nextLine().charAt(0);
            if (keepPlay == 'N' || keepPlay == 'n')
                keepPlaying = false;
            
            System.out.println();
        }
    }
}



