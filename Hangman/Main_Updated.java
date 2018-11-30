
/**
 * Write a description of class Main_Updated here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Scanner;
public class Main_Updated
{
    public static void main(String[] args) {
        
        while(true) {
            System.out.println("Let's play a game of hangman! (Y/N) ");
            if( !readBoolean() ) {
                break;
            }
            
            clearConsole();
            Options settings = Hangman_Updated.generateNewSettings();
            System.out.println("Set game settings");
            System.out.println(settings);
            System.out.println("Continue with default settings? (Y/N) ");
            
            if( !readBoolean() ) {
                // Manually configure settings
                System.out.println("Do you want a randomly generated word? (Y/N) ");
                if( !readBoolean() ) {
                    // User sets word
                    System.out.println("Please type a word containing only alphanumerical characters: ");
                    settings.setUseRandomWord(false);
                    settings.setWord( askForWord() );
                } else {
                    // Use randomly generated word
                    settings.setUseRandomWord(true);
                    settings.setWord( Hangman_Updated.generateRandomWord() );
                }
                
                System.out.println("Should all non-alphabtical characters be automatically filled? (Y/N) ");
                settings.setRevealNonWords( readBoolean() );

                System.out.println("Should all repeated characters be filled together? (Y/N) ");
                settings.setFillAllOccurances( readBoolean() );
                
                System.out.println("How many tries (wrong guesses) permitted? [0 ~ " + Hangman_Updated.MAX_TRIES_LIMIT + "] or -1 for default ");
                int maxTries = askMaxTries();    // If -1, don't change setting
                if(maxTries >= 0) {
                    settings.setMaxTries(maxTries);
                }
                
                System.out.println(settings);
                System.out.println("Are you satisfied with the settings? (Y/N) ");
                if( !readBoolean() ) {
                    // Restart game setup
                    continue;
                }
            } else {
                // Default settings
                settings.setWord( Hangman_Updated.generateRandomWord() );
            }
            
            // Finished configuring settings
            clearConsole();
            Hangman_Updated game = new Hangman_Updated(settings);
            
            // Start playing
            while(true) {
                System.out.println("Progress: " + game.getProgress());
                System.out.println("Type a character");
                
                String letter = readLetter(game, settings);
                clearConsole();
                
                if( !game.checkNewLetter(letter) ) {
                    // Incorrect guess
                    System.out.println("You guessed wrong!");
                    if( game.getRemainingTries() < 0 ) {
                        System.out.println("Out of tries! You lose!");
                        break;
                    }
                } else if( game.hasWon() ) {
                    System.out.println("You win! You had " + game.getTries() + " incorrect guesses!");
                    break;
                } else {
                    // Correct guess
                    System.out.println("You guessed correctly!");
                }
                
                System.out.println("You have " + game.getRemainingTries() + " tries remaining");
                System.out.println();
                System.out.println("Correct attempts: " + game.getRightTries());
                System.out.println("Incorrect attempts: " + game.getWrongTries());
            }
            
            // Game finished
            System.out.println("The answer was " + game.getAnswer());
            printLine();
        }
    }
    
    
    
    public static void clearConsole() {
        for(int i = 0 ; i < 20 ; i++) {
            System.out.println();
        }
    }
    
    public static void printLine() {
        for(int i = 0 ; i < 20 ; i++) {
            System.out.print("=");
        }
        System.out.println();
    }
    
    public static boolean readBoolean() {
        Scanner sc = new Scanner(System.in);
        
        while(true) {
            String input = sc.nextLine();
            char response = input.length() > 0 ? input.toUpperCase().charAt(0) : '*';
            if(response == 'Y' || response == 'T') {
                return true;
            } else if(response == 'N' || response == 'F') {
                return false;
            }
            
            System.out.println("Please type a valid input! (Y/N) ");
        }
    }
    
    public static String askForWord() {
        Scanner sc = new Scanner(System.in);
        
        while(true) {
            String word = sc.nextLine().toUpperCase();
            
            if( word.matches("[A-Z 0-9\\-]+") ) {
                return word;
            }
            
            System.out.println("Please type a valid word! Only A-Z, space, 0-9, '-' allowed! ");
        }
    }
    
    public static int askMaxTries() {
        Scanner sc = new Scanner(System.in);
        final int MAX_TRIES_LIMIT = Hangman_Updated.MAX_TRIES_LIMIT;
        
        while(true) {
            int num = sc.hasNextInt() ? sc.nextInt() : -2;
            sc.nextLine();
            
            if( (num == -1) || (num >= 0 && num <= MAX_TRIES_LIMIT) ) {
                return num;
            }
            
            System.out.println("Please type a number in the valid range! [0 ~ " + MAX_TRIES_LIMIT + "] or -1 for default");
        }
    }
    
    public static String readLetter(Hangman_Updated game, Options settings) {
        Scanner sc = new Scanner(System.in);
        
        while(true) {
            String letter = sc.nextLine();
            letter = letter.length() > 0 ? letter.substring(0,1).toUpperCase() : "*";
            
            if( !letter.matches("[A-Z 0-9\\-]") ) {
                System.out.println("Please type a valid character! Only A-Z, space, 0-9, '-' allowed! ");
                continue;
            }
            if( settings.getRevealNonWords() && !letter.matches("[A-Z]") ) {
                System.out.println("Non-alphabetical characters are already revealed! Type an alphabet! ");
                continue;
            }
            if( !game.isNewLetter(letter) ) {
                System.out.println("Please type a character you have not entered before! ");
                continue;
            }
            
            return letter;
        }
    }
}
