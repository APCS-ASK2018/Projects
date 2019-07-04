package Program.Locations;

import static Helper.Console.*;
import Helper.*;
import Program.*;

/**
 * The maze room (right hallway)
 * Player wins by escaping the maze
 * Player's moves are limited by maze insanity damage
 * Collected item may show the solution to the maze
 * 
 * Climbing out and returning will result in new maze layout
 */
public class MazeRoom extends AbstractPlace
{
    protected static final String[] validMoves = {"climb","up","down","left","right"};
    
    protected Maze maze;
    public MazeRoom() {
        super();
    }
    
    @Override
    public void enter() {
        super.enter();
        maze = new Maze();
        if(getTotalMoves() != 0) {
            // Player had used the secret "climb out" option
            // Player gets to see maze solution
            maze.showHint();
        }
    }
    
    @Override
    public void printMenu() {
        if(getCurrentMoves() == 0)
            print("The hallway trap dropped you into a maze!");
        print("Head to the exit!");
        print();
        print(maze);
        print("(Up) Move upwards.");
        print("(Down) Move downwards.");
        print("(Left) Move left.");
        print("(Right) Move right.");
    }
    
    @Override
    public String[] getValidMoves() {return validMoves;}
    
    @Override
    public boolean canMove(String actionChoice) {
        return maze.canMove(actionChoice);
    }
    
    @Override
    public void move(String actionChoice) {
        super.move();
        if(validMoves[0].equals(actionChoice)) {
            // Climb out
            print("Secret Option!");
            print("You climbed back to the bottom hallway.");
            Player.goTo(Regions.bottomHall);
        } else {
            // Movement in maze
            maze.move(actionChoice);
            if(maze.hasEscaped()) {
                print();
                print("You escaped the maze!");
                print("The exit led outside! You are free.");
                Game.gameState = 1;
            } else {
                print("You moved " + actionChoice);
            }
        }
        int moveCount = getCurrentMoves();
        if(moveCount != 0 && moveCount % 10 == 0) {
            print("You feel your sanity slipping away.");
            Player.takeDmg( new Hazards(3, 5, "mazeInsanity") );
        }
    }
}
