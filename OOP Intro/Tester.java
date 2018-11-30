
/**
 * Write a description of class Tester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tester
{
    public static void main(String[] args) {
        Rectangle box = new Rectangle(3,4);
        Vehicle car = new Vehicle("some car",3);
        Animal dog = new Animal("some name",true,1);
        
        System.out.println(box);
        System.out.println(car);
        System.out.println(dog);
    }
}
