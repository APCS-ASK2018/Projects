import java.util.*;
/**
 * Write a description of class Tester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tester
{
    private Tester() {/*Just run the main method, no instantiation plz*/}
    
    public static void main(String[] args) {
        Shape[] shapes = {
            new Circle("circle",5),
            new Square("sqr", 3),
            new Cylinder("cy", 2, 9),
            new Cylinder("pole", 3, 4),
            new Sphere("sph", 8),
            new Cube("cube", 10),
            new Cube("box", 10),
            new Glome("gl", 50)
        };
        
        Shape[] shapesClone = shapes.clone();
        Arrays.sort(shapesClone);
        
        System.out.println("Original array");
        printArray(shapes);
        System.out.println("\n\nArray sorted with compareTo");
        printArray(shapesClone);
    }
    
    private static void printArray(Object[] arr) {
        System.out.print("[");
        for(int i = 0; i < arr.length; i++) {
            String join = ",";
            if(i == arr.length - 1) join = "  ]";
            System.out.println("  " + arr[i] + join);
        }
    }
}
