
public class Apartment implements Comparable<Apartment>
{
    private String owner; // Resident type: single, couple, family
    private int occupancy; // Number of residents

    /**
     * Constructor, according to below if unspecified
     * Single: 1/6 chance, size 1
     * Couple: 2/6 chance, size 2
     * Family: 3/6 chance, size 3-6
     */
    public Apartment()
    {
        int randInt = (int) (Math.random() * 6);
        if(randInt < 1) setOwner("single");
        else if(randInt < 3) setOwner("couple");
        else setOwner("family");
    }
    public Apartment(String s, int num) {
        owner = s;
        occupancy = num;
    }
    
    /** Getters */
    public int getOccupancy() {return occupancy;}
    public String getOwner() {return owner;}
    
    /** 
     * Set owner type with appropriate new occupancy value
     * @param s New owner type
     * 
     * PreCondition: none (null check, letter case, invalid type all handled)
     * PostCondition: owner and occupancy fields are set appropriately
     */
    public void setOwner(String s) {
        s = s.toLowerCase();
        
        if("single".equals(s))
            setOccupancy(1);
        else if("couple".equals(s))
            setOccupancy(2);
        else if("family".equals(s))
            setOccupancy((int) (Math.random() * 4) + 3);
        else if("roommates".equals(s))
            setOccupancy(2);
        else
            throw new IllegalArgumentException(s + " is not a valid owner type!");
        
        owner = s;
    }
    
    /**
     * Set new occupancy value
     * @param num New occupancy value
     * 
     * PreCondition: none (min/max range enforced)
     * PostCondition: occupancy fields are set to new value
     */
    public void setOccupancy(int num) {
        if(num < 1 || num > 6)
            throw new IllegalArgumentException(num + " is not a valid occupancy size!");
        occupancy = num;
    }
    
    /**
     * Compare with another apartment object
     * @param other Another apartment object
     * @throws NullPointerException if other is null (java specification)
     * 
     * PreCondition: other is not null
     * PostCondition: this.occupancy - other.occupancy or null exception
     */
    @Override
    public int compareTo(Apartment other) {
        return occupancy - other.getOccupancy();
    }
    
    @Override
    public String toString() {
        return owner + ": " + occupancy;
    }
}
