
public class Distance
{
    private int x1,y1,x2,y2;
    private double distance;

    public Distance() {}
    
    public Distance(int xOne, int yOne, int xTwo, int yTwo)
    {
        setCoordinates(xOne, yOne, xTwo, yTwo);
    }

    public void setCoordinates(int xOne, int yOne, int xTwo, int yTwo)
    {
        x1 = xOne;
        y1 = yOne;
        x2 = xTwo;
        y2 = yTwo;
        calcDistance();
    }

    private void calcDistance()
    {
        long xDif = x1 - x2;
        long yDif = y1 - y2;
        distance = Math.sqrt(xDif * xDif + yDif * yDif);
    }

    public void print( )
    {
        System.out.println("D : " + posStr() + " == " + String.format("%.3f", distance));
    }
    
    private String posStr() {
        return String.format("( %s, %s ) , ( %s, %s )", x1, y1, x2, y2);
    }
}