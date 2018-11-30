

public class RPS
{
    // Rock = 0, Paper = 1, Scissors = 2
    // playChoice - compChoice
    // player wins @ 1, -2
    // comp wins @ -1, 2
    private int playChoice;
    private int compChoice;
    private String outcome;

    public void play()
    {
        compChoice = (int) (Math.random() * 3);
        
        switch(playChoice - compChoice) {
            case 0:
                outcome = "Draw!";
                break;
            case 1: // Fallthrough
            case -2:
                outcome = "You win!";
                break;
            case -1: // Fallthrough
            case 2:
                outcome = "You lose!";
                break;
            default:
                outcome = "Error!";
        }
    }
    
    /**
     * Verify player's choice (case insensitive)
     * and set instance field to corresponding numeric value
     * 
     * @return true if successful
     * @return false if invalid input
     */
    public boolean parseInput(char playerChoice) {
        if (playerChoice == 'R' || playerChoice == 'r')
            playChoice = 0;
        else if (playerChoice == 'P' || playerChoice == 'p')
            playChoice = 1;
        else if(playerChoice == 'S' || playerChoice == 's')
            playChoice = 2;
        else
            return false;
        
        return true;
    }
    
    public void printResult() {
        String l1 = "Player had " + getPlayChoice() + "\n";
        String l2 = "Computer had " + getCompChoice() + "\n";
        String l3 = outcome;
        
        System.out.println(l1 + l2 + l3);
    }
    
    private String getPlayChoice() {
        if (playChoice == 0)
            return "Rock";
        else if (playChoice == 1)
            return "Paper";
        else if (playChoice == 2)
            return "Scissors";
        else
            return "Error";
    }
    
    private String getCompChoice() {
        if (compChoice == 0)
            return "Rock";
        else if (compChoice == 1)
            return "Paper";
        else if (compChoice == 2)
            return "Scissors";
        else
            return "Error";
    }
}