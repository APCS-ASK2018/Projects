
/**
 * Write a description of class Hangman_Updated here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.ArrayList;
public class Hangman_Updated
{
    public static final int MAX_TRIES_LIMIT = 15;
    
    private static int win, lose;
    private int tries;
    private Options settings;
    private String answer, progress;
    private ArrayList<String> wrongTries, rightTries;
    
    public Hangman_Updated(Options gameSettings) {
        settings = gameSettings;
        answer = settings.getWord();
        progress = "";
        tries = 0;
        rightTries = new ArrayList();
        wrongTries = new ArrayList();
        
        boolean revealNonWords = settings.getRevealNonWords();
        for(int i = 0, j = answer.length() ; i < j ; i++) {
            String letter = String.valueOf(answer.charAt(i));
            progress += (!revealNonWords || letter.matches("[A-Z]")) ? 
                "#" : letter ;
        }
    }
    
    
    
    public boolean isNewLetter(String c) {
        c = c.substring(0,1);
        return !wrongTries.contains(c) && !( settings.getFillAllOccurances() && rightTries.contains(c) ) ;
    }
    
    public boolean checkNewLetter(String c) {
        boolean output = false;
        c = c.substring(0,1).toUpperCase();
        char letter = c.charAt(0);
        
        for(int i = 0, j = answer.length() , k = 0 ; i < j ; i++) {
            if(progress.charAt(i) == '#' &&  answer.charAt(i) == letter) {
                progress = progress.substring(0,i) + c + progress.substring(i+1);
                output = true;
                
                if(!settings.getFillAllOccurances()) {
                    break;
                }
            }
        }
        
        if(output) {
            rightTries.add(c);
        } else {
            wrongTries.add(c);
            tries++;
        }
        
        return output;
    }
    
    public int getRemainingTries() {
        return settings.getMaxTries() - tries;
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
    
    public String getProgress() {
        return progress;
    }
    
    public ArrayList<String> getWrongTries() {
        return wrongTries;
    }
    
    public ArrayList<String> getRightTries() {
        return rightTries;
    }
    
    
    
    public static Options generateNewSettings() {
        return new Options();
    }
    
    public static String generateRandomWord() {
        String[] wordList = {
            "Java",
            "Computer Science",
            "Hello World",
            "Hangman",
            "I-support-hyphens-and numbers 2"
        };
        
        int rand = (int) (Math.random() * wordList.length);
        return wordList[rand];
    }
}

class Options {
    private boolean revealNonWords, fillAllOccurances, useRandomWord;
    private int maxTries;
    private String word;
    
    public Options() {
        // Default settings
        revealNonWords = true;
        fillAllOccurances = true;
        useRandomWord = true;
        maxTries = 10;
    }
    
    public void setRevealNonWords(boolean doReveal) {
        revealNonWords = doReveal;
    }
    
    public void setFillAllOccurances(boolean fillAll) {
        fillAllOccurances = fillAll;
    }
    
    public void setUseRandomWord(boolean useRand) {
        useRandomWord = useRand;
    }
    
    public void setMaxTries(int max) {
        maxTries = max;
    }
    
    public void setWord(String solution) {
        word = solution.toUpperCase();
    }
    
    public boolean getRevealNonWords() {
        return revealNonWords;
    }
    
    public boolean getFillAllOccurances() {
        return fillAllOccurances;
    }
    
    public boolean getUseRandomWord() {
        return useRandomWord;
    }
    
    public int getMaxTries() {
        return maxTries;
    }
    
    public String getWord() {
        return word;
    }
    
    public String toString() {
        String l1 = "<<<Current settings>>>\n";
        String l2 = "Generate random word: " + useRandomWord + "\n";
        String l3 = "Reveal non-word characters: " + revealNonWords + "\n";
        String l4 = "Fill all occurances: " + fillAllOccurances + "\n";
        String l5 = "Max tries: " + maxTries;
        return l1 + l2 + l3 + l4 + l5;
    }
}
