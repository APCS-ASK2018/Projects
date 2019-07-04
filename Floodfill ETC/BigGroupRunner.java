import java.util.Scanner;

public class BigGroupRunner
{
    private static Scanner kb = new Scanner(System.in);
    
    private static String[][] makeGrid() {
        System.out.print("Enter the matrix after the dimensions: ");

        String[] tokens;
        int row, col;
        while(true) {
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
    }
    
    private static void fillGrid(String[][] grid) {
        for(int i = 0; i < grid.length; i++)
            grid[i] = kb.nextLine().split("");
    }
    
    public static void main(String[] args) {
        // Process user input
        String[][] grid = makeGrid();
        fillGrid(grid);
        
        // Get largest group of $
        BigGroup bg = new BigGroup(grid);
        System.out.println("Largest group of $ is " + bg.getLargestGroup());
    }
}

class BigGroup {
    private String[][] grid;
    
    public BigGroup(String[][] grid) {
        this.grid = grid;
    }
    
    public int getLargestGroup() {
        int max = 0;
        for(int i = 0; i < grid.length; i++)
            for(int j = 0; j < grid[0].length; j++) {
                // Count size of cluster starting at every point
                int cluster = countGroup(i,j);
                
                // Track largest size
                if(max < cluster)
                    max = cluster;
            }
        
        return max;
    }
    
    private int countGroup(int row, int col) {
        if(row > 0 && row < grid.length && col > 0 && col < grid[0].length &&
            "$".equals(grid[row][col])) {
            // Set cell to empty string to avoid repeated counting
            grid[row][col] = "";
            
            // Floodfill in cardinal directions
            int up = countGroup(row - 1, col);
            int down = countGroup(row + 1, col);
            int left = countGroup(row, col - 1);
            int right = countGroup(row, col + 1);
            
            // Count = sum of 4 directions + 1 (self)
            return up + down + left + right + 1;
        }
        
        // Not a $ sign
        return 0;
    }
}