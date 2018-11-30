
/**
 * Write a description of class Hangman here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Hangman
{
    private String answer;
    private String progress;
    private int maxTries;
    private int tries;
    private String[] wrongTries;
    
    public Hangman(String answer , int maxTries , boolean showSpace) {
        this.answer = answer.toUpperCase();
        this.progress = "";
        this.maxTries = maxTries;
        this.tries = 0;
        this.wrongTries = new String[maxTries];
        
        for(int i = answer.length() - 1 ; i >= 0 ; i--) {
            this.progress += (showSpace && answer.charAt(i) == ' ') ? " " : "#";
        }
    }
    
    // Only use 1 char length string
    public boolean checkChar(String c) {
        boolean output = false;
        for(int i = answer.length() -1 ; i >= 0 ; i--) {
            if(answer.charAt(i) == c.charAt(0)) {
                progress = progress.substring(0,i) + c + progress.substring(i+1);
                output = true;
            }
        }
        
        if(!output) {
            wrongTries[ getTries() ] = c;
            useUpTries();
        }
        
        return output;
    }
    
    public boolean isOutOfTries() {
        return tries >= maxTries;
    }
    
    public boolean hasWon() {
        return answer.equals(progress);
    }
    
    public String getAnswer() {
        return answer;
    }
    
    public int getTries() {
        return tries;
    }
    
    public void useUpTries() {
        tries++;
    }
    
    public String getProgress() {
        return progress;
    }
    
    public String getWrongTries() {
        String output = "";
        for(int i = 0, j = wrongTries.length ; i < j; i++) {
            output += (wrongTries[i] == null) ? "" : 
                (i < wrongTries.length - 1 && wrongTries[i+1] != null) ? "<" + wrongTries[i] + ">, " :
                "<" + wrongTries[i] + ">";
        }
        
        return output;
    }
    
    public static String getRandWord() {
        String[] words = {
            "Java",
            "Computer Science",
            "Hello World",
            "Hangman"
        };
        int rand = (int) (Math.random() * words.length);
        return words[rand];
    }
}
