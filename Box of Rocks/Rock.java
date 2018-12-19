import java.text.DecimalFormat;
import java.util.*;

public class Rock implements Comparable<Rock>
{
    private double weight;
    
    /**
     * Overloaded constructor
     * Default random weight between (0.5, 5) up to 3 decimal values
     * Or set to provided weight value
     */
    public Rock() {
        weight = ((int) (Math.random() * 4501) + 500)/1000.0; // Rand 0 ~ 4500 -> 500 ~ 5000 -> 0.500 ~ 5.000
    }
    public Rock(double w) {
        weight = w;
    }
    
    /** @return weight */
    public double getWeight() {return weight;}
    
    /**
     * PreCondition: Weight is set and is a non-zero double (otherwise erosion has no effect)
     * PostCondition: New weight is 10% less than before
     */
    public void erode() {weight *= 0.9; /* Erode by 10% -> New weight = Original weight x 90% */}
    
    /** @param w New weight of rock to be set as */
    public void setWeight(double w) {weight = w;}
    
    /** @return String representation of rock with weight in 3 decimal places */
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.000");
        return "Rock: " + df.format(weight) + " kg";
    }
    
    /**
     * PreCondition: @param is a rock object and is not null
     * PostCondition: int value for comparing the two rock objects' weight
     * @param other The other rock object being compared against
     * @return Positive int if this is heavier, negative int if this is lighter
     */
    @Override
    public int compareTo(Rock other) {return (int) (getWeight() - other.getWeight());}

    /**
     * PreCondition: @param Non-null array of non-null rock objects and no ties for heaviest rock in array
     * PostCondition: New array with largest rock being replaced by 2 smaller rocks that are each half its original weight
     * @param arr Array of non-null rock objects
     * @return new array of rocks
     */
    public static Rock[] split(Rock[] arr) {
        Rock[] newArr = Arrays.copyOf(arr, arr.length + 1); // Make arr into a new array that is 1 size bigger
        int heavyIndex = 0;
        for(int i = 0; i < newArr.length - 1; i++)
            if(newArr[i].compareTo(newArr[heavyIndex]) > 0) heavyIndex = i; // Find index of heaviest rock
        for(int i = newArr.length - 1; i > heavyIndex; i--)
            newArr[i] = newArr[i-1]; // Shift elements so that heavyIndex and heavyIndex + 1 can be replaced
        
        double splitWeight = arr[heavyIndex].getWeight() / 2.0; // Weight of child rocks
        newArr[heavyIndex] = new Rock(splitWeight);
        newArr[heavyIndex + 1] = new Rock(splitWeight);
        
        return newArr;
    }
    
    /**
     * Overloaded split method for making use of Collections API
     * 
     * PreCondition: @param Non-null arraylist of non-null rock objects and no ties for heaviest rock in arraylist
     * PostCondition: New arraylist with largest rock being replaced by 2 smaller rocks that are each half its original weight
     * @param arr Arraylist of non-null rock objects
     * @return new arraylist of rocks
     */
    public static ArrayList<Rock> split(ArrayList<Rock> arr) {
        ArrayList<Rock> newArr = new ArrayList<>(arr.size() + 1); // Optimize initialization to necessary size
        newArr.addAll(arr); // Shallow clone objects into new array
        
        Rock heavyR = Collections.max(newArr); // Find heaviest rock as determined by compareTo
        int heavyIndex = newArr.indexOf(heavyR);
        
        double splitWeight = heavyR.getWeight() / 2.0; // Weight of child rocks
        newArr.set( heavyIndex, new Rock(splitWeight) ); // Set before add so only 1 shift occurs
        newArr.add( heavyIndex, new Rock(splitWeight) );
        
        return newArr;
    }
}