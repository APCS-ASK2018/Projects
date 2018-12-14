
/**
 * Abstract class Shape - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Shape implements Comparable<Shape>
{
    private String name;
    
    public Shape(String n) {
        name = n;
    }
    
    public String getName() {return name;}
    
    @Override
    public int compareTo(Shape other) {
        /*
        double[] thisVal = {
            (this instanceof Volume) ? ((Volume) this).getVolume() : 0,
            (this instanceof Area) ? ((Area) this).getArea() : 0
        };
        */
        double[] thisVal = new double[2];
        if(this instanceof Volume)
            thisVal[0] = ((Volume) this).getVolume();
        if(this instanceof Area)
            thisVal[1] = ((Area) this).getArea();
        
        /*
        double[] thatVal = {
            (other instanceof Volume) ? ((Volume) other).getVolume() : 0,
            (other instanceof Area) ? ((Area) other).getArea() : 0
        };
        */
        double[] thatVal = new double[2];
        if(other instanceof Volume)
            thatVal[0] = ((Volume) other).getVolume();
        if(other instanceof Area)
            thatVal[1] = ((Area) other).getArea();
        
        for(int i = 0; i < thisVal.length; i++) {
            if(Double.isNaN(thisVal[i])) thisVal[i] = 0;
            if(Double.isNaN(thatVal[i])) thatVal[i] = 0;
            
            // Want descending order
            // When thisVal > thatVal, diff > 0 -> return -diff
            int diff = Double.compare(thisVal[i], thatVal[i]);
            if(diff != 0) return - diff;
        }
        return name.compareTo(other.getName());
    }
}
