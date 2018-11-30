
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class Main
{
    private static final int DEFAULT_MAX_TRIES = 10;
    private static final int MAX_TRIES_LIMIT = 20;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        boolean keepPlaying = true;
        
        while(keepPlaying) {
            System.out.println("Let's play a game of Hangman");
            System.out.println("How many attempts should you get? Insert 0 for default (10)");
            
            int maxTries;
            while(true) {
                while( !sc.hasNextInt() ) {
                    System.out.println("Not a number!");
                    sc.nextLine();
                }
                
                maxTries = sc.nextInt();
                sc.nextLine();
                
                if(maxTries < 0 || maxTries > MAX_TRIES_LIMIT) {
                    System.out.println("Number out of range! Choose between 0-"+ MAX_TRIES_LIMIT);
                    continue;
                }
                
                if(maxTries == 0) {
                    maxTries = DEFAULT_MAX_TRIES;
                }
                
                break;
            }
            
            System.out.println("Should I show spaces?");
            boolean showSpace;
            while(true) {
                String toShowSpace = sc.nextLine().toUpperCase();
                if(toShowSpace.length() == 0) {
                    continue;
                }
                char spaceOption = toShowSpace.charAt(0);
                if(spaceOption == 'Y' || spaceOption == '1') {
                    showSpace = true;
                } else if(spaceOption == 'N' || spaceOption == '0') {
                    showSpace = false;
                } else {
                    System.out.println("Please answer Yes/No");
                    continue;
                }
                
                System.out.println("Show options: " + showSpace);
                
                break;
            }
            
            String word = Hangman.getRandWord();
            Hangman game = new Hangman(word,maxTries,showSpace);
            System.out.println( game.getProgress() );
            
            while(true) {
                System.out.println("Enter a character to guess!");
                String guess = sc.nextLine().substring(0,1).toUpperCase();
                
                if( !game.checkChar(guess) ) {
                    System.out.println("You guessed wrong! " + guess + " is not used in this word!");
                    
                    if( game.isOutOfTries() ) {
                        System.out.println("You are out of tries!");
                        break;
                    }
                } else if( game.hasWon() ) {
                    System.out.println("You win! It took " + game.getTries() + " tries!");
                    break;
                } else {
                    System.out.println("You guessed correctly!");
                }
                
                System.out.println();
                System.out.println("You have " + (maxTries - game.getTries()) + " tries remaining");
                System.out.println( "Incorrect attempts: " + game.getWrongTries() );
                System.out.println( "Progress: " + game.getProgress() );
            }
            
            System.out.println( "The answer was: " + game.getAnswer() );
            System.out.println("Would you like to play again?");
            while( true ) {
                char response = sc.nextLine().toUpperCase().charAt(0);
                if(response == 'Y' || response == '1') {
                    keepPlaying = true;
                    clearConsole();
                } else if(response == 'N' || response == '0') {
                    keepPlaying = false;
                } else {
                    System.out.println("Please answer Yes/No");
                    continue;
                }
                
                break;
            }
        }
        
    }
    
    
    private static void clearConsole() {
        for(int i = 0 ; i < 15 ; i++) {
            System.out.println();
        }
    }
}
