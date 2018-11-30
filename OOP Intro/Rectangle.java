
/**
 * Write a description of class Rectangle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Rectangle
{
    private int length;
    private int width;
    
    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }
    
    public int getArea() {
        return this.length * this.width;
    }
    
    public String toString() {
        return "Rectangle\n\tlength: " + this.length + "\n\twidth: " + this.width;
    }
}
