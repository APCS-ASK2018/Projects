public class CircleRunner
{
    public static void main( String[] args )
    {
        Circle c = new Circle();
        
        c.setRadius(7.5);
        c.calculateArea();
        c.print();
        
        c.setRadius(10D);
        c.calculateArea();
        c.print();
        
        c.setRadius(72.534);
        c.calculateArea();
        c.print();
        
        c.setRadius(55D);
        c.calculateArea();
        c.print();
        
        c.setRadius(101D);
        c.calculateArea();
        c.print();
        
        c.setRadius(99.952);
        c.calculateArea();
        c.print();
    }
}