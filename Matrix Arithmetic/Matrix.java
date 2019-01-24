
public class Matrix {
    /**
     * @param grid1 2D array that is rectangular
     * @param grid2 2D array that is rectangular
     * @return New 2D array object that is dot product of the two input matrixes OR null if undefined
     */
    public static int[][] multiply(int[][] grid1, int[][] grid2) {
        if(grid1[0].length != grid2.length)
            return null;
        
        int[][] output = new int[grid1.length][grid2[0].length];
        
        for(int r1 = 0; r1 < grid1.length; r1++)
            for(int c2 = 0; c2 < grid2[0].length; c2++)
                for(int i = 0; i < grid1[0].length; i++)
                    output[r1][c2] += grid1[r1][i] * grid2[i][c2];
        
        return output;
    }
    
    /**
     * @param grid 2D array that is rectangular
     * @param val Scalar quantity
     * @return New 2D array object that is scalar product
     */
    public static int[][] multiply(int[][] grid, int val) {
        int[][] output = new int[grid.length][];
        for(int i = 0; i < output.length; i++) {
            output[i] = java.util.Arrays.copyOf(grid[i], grid[i].length);
            for(int j = 0; j < output[i].length; j++)
                output[i][j] *= val;
        }
        return output;
    }
}
