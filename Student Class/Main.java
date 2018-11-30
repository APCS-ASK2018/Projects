
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
// import Array class

public class Main
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Insert name: ");
        String name = sc.nextLine();
        
        System.out.println("Insert student number: ");
        while(!sc.hasNextInt()) {
            System.out.println("Insert an integer!");
            sc.nextLine();
        }
        int stuNum = sc.nextInt();
        
        System.out.println("Insert GPA: ");
        while(!sc.hasNextDouble()) {
            System.out.println("Insert a numerical value!");
            sc.nextLine();
        }
        double gpa = sc.nextDouble();
        
        Student student = new Student(name,stuNum,gpa);
        
        System.out.println(student);
    }
}
