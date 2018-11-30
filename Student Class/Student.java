
/**
 * Write a description of class Student here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Student
{
    private String name;
    private int studentNum;
    private double gpa;
    
    public Student(String name, int studentNum, double gpa) {
        this.name = name;
        this.studentNum = studentNum;
        this.gpa = gpa;
    }
    
    public String getName() {
        return name;
    }
    
    public int getStudentNum() {
        return studentNum;
    }
    
    public double getGPA() {
        return gpa;
    }
    
    public void setGPA(double gpa) {
        this.gpa = gpa;
    }
    
    public boolean getHonorStudent() {
        return gpa >= 3.3;
    }
    
    public String toString() {
        String l1 = "Name: " + name + "\n";
        String l2 = "Student No: " + studentNum + "\n";
        String l3 = "GPA: " + gpa;
        
        return l1 + l2 + l3;
    }
}
