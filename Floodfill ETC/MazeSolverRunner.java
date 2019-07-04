import java.util.Scanner;

public class MazeSolverRunner
{
    private static Scanner kb = new Scanner(System.in);
    
    private static String[][] makeGrid() {
        System.out.print("Enter the matrix after the dimensions: ");
        
        String[] tokens;
        int row, col;
        while(true)
            try {
                // Get input and split by space
                tokens = kb.nextLine().trim().split(" ");
                
                // Parse numbers in base 10
                row = Integer.parseInt(tokens[0], 10);
                col = Integer.parseInt(tokens[1], 10);
                
                // Make new 2D string array and return it
                return new String[row][col];
            } catch(NumberFormatException e) {
                // Input not a number
                System.out.print("Enter a valid number! ");
            } catch(ArrayIndexOutOfBoundsException e) {
                // Input has less than 2 numbers
                System.out.print("Enter a valid dimension! ");
            }
    }
    
    private static void fillGrid(String[][] grid) {
        for(int i = 0; i < grid.length; i++)
            grid[i] = kb.nextLine().split("");
    }
    
    private static int getNum() {
        System.out.print("How many mazes to test? ");
        String input;
        while(true)
            try {
                // Parse numbers in base 10
                input = kb.nextLine().trim();
                return Integer.parseInt(input, 10);
            } catch(NumberFormatException e) {
                // Input not a number
                System.out.print("Enter a valid number! ");
            }
    }
    
    public static void main(String[] args) {
        // First line determines how many mazes to solve
        int mazeCount = getNum();
        for(int i = 0; i < mazeCount; i++) {
            // Process user input
            String[][] grid = makeGrid();
            fillGrid(grid);
            
            MazeSolver solver = new MazeSolver(grid);
            boolean hasExit = solver.findExit();
            
            // Output result
            if(hasExit) System.out.println("Exit Found");
            else System.out.println("No Exit");
        }
    }
}

class MazeSolver {
    private String[][] maze;
    
    // Constructor with input maze
    public MazeSolver(String[][] maze) {this.maze = maze;}
    
    // Wrapper method for recursive method
    public boolean findExit() {return findExit(0,0);}
    
    private boolean findExit(int row, int col) {
        if(isValidPos(row, col)) {
            // If exit found
            if("E".equals(maze[row][col]))
                return true;
            
            // If exit not found
            // mark visited locations to avoid overlap
            maze[row][col] = "x";
            
            // Floodfill in cardinal direction
            // and see if any branches return positive
            boolean up = findExit(row - 1, col);
            boolean down = findExit(row + 1, col);
            boolean left = findExit(row, col - 1);
            boolean right = findExit(row, col + 1);
            
            return up || down || left || right;
        }
        
        return false;
    }
    
    private boolean isValidPos(int row, int col) {
        // Check if pos is within the grid
        // and if it's not a wall / visted path
        return row >= 0 && row < maze.length &&
            col >= 0 && col < maze[0].length &&
            !"x".equals(maze[row][col]) && !"#".equals(maze[row][col]);
    }
}