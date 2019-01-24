
public class Tester {
    public static void main(String[] args) {
    
        int[][] grid1 ={
            {1,2,3},
            {2,4,3},
            {1,5,3}};
        int[][] grid2 = {
            {3,2,3},
            {5,7,9},
            {2,3,4}};
        int[][] grid3 = {
            {5,3},
            {2,1},
            {4,2}};
        int[][] grid4 = {
            {4,5,6},
            {3,2,4}};
        
        printGrid(grid1);
        printGrid(grid2);
        printGrid(grid3);
        printGrid(grid4);
        
        // Matrix Multiplication
        
        System.out.println("Grid1 x Grid2");
        printGrid( Matrix.multiply(grid1, grid2) );
        
        System.out.println("Grid1 x Grid3");
        printGrid( Matrix.multiply(grid1, grid3) );
        
        System.out.println("Grid2 x Grid3");
        printGrid( Matrix.multiply(grid2, grid3) );
        
        System.out.println("Grid1 x Grid4");
        printGrid( Matrix.multiply(grid1, grid4) );
        
        System.out.println("Grid3 x Grid4");
        printGrid( Matrix.multiply(grid3, grid4) );
        
        // Scalar Multiplication
        
        int n1 = rand();
        System.out.println("Grid1 x " + n1);
        printGrid( Matrix.multiply(grid1, n1) );
        
        int n2 = rand();
        System.out.println("Grid2 x " + n2);
        printGrid( Matrix.multiply(grid2, n2) );
        
        int n3 = rand();
        System.out.println("Grid3 x " + n3);
        printGrid( Matrix.multiply(grid3, n3) );
        
        int n4 = rand();
        System.out.println("Grid4 x " + n4);
        printGrid( Matrix.multiply(grid4, n4) );
        
    }
    
    private static void printGrid(int[][] grid) {
        if(grid != null)
            for(int[] arr : grid)
                System.out.println(java.util.Arrays.toString(arr));
        else
            System.out.println("Undefined!");
        System.out.println();
    }
    
    private static int rand() {return (int) (Math.random() * 9) + 2;}
}
