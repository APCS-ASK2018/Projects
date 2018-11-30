
/**
 * Write a description of class Animal here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Animal
{
    private String name;
    private boolean isPet;
    private int age;
    
    public Animal (String name, boolean isPet, int age) {
        this.name = name;
        this.isPet = isPet;
        this.age = age;
    }
    
    public String toString() {
        return "Animal\n\tname: " + this.name + "\n\tisPet: " + this.isPet + "\n\tage: " + this.age;
    }
}
