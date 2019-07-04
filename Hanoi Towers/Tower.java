
public class Tower
{
    private Disk[] disks;
    private int size;
    
    public Tower(int capacity) {
        disks = new Disk[capacity];
        size = 0;
    }
    
    public void stack(Disk d) {
        if(size > 0 && disks[size - 1].size < d.size)
            throw new UnsupportedOperationException("Cannot stack onto smaller disk!");
        disks[size++] = d;
    }
    
    public Disk pop() {
        return disks[--size];
    }
    
    public String toString() {
        if(size == 0) return "[]";
        
        String output = "[";
        for(int i = 0; i < size; i++)
            output += disks[i] + ", ";
        return output.substring(0, output.length() - 2) + "]";
    }
}
