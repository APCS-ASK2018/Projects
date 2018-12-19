import java.util.ArrayList;

public class Main
{
    private static final int TEST_COUNT = 10;
    /** Tester for array of rocks */
    public static void rockArrayTest() {
        Rock[] box = new Rock[TEST_COUNT];
        
        for (int i = 0; i < TEST_COUNT; i++)
            box[i] = new Rock();
        
        System.out.println("A BOX OF ROCKS");
        for(Rock r : box)
            System.out.println(r);
        
        System.out.println("\nA BOX OF ERODED ROCKS");
        for (Rock r: box)
            r.erode();
        
        for(Rock r : box)
            System.out.println(r);
        
        Rock[] box2 = Rock.split(box);
        System.out.println("\nA BOX WITH A SPLIT ROCK");
        for(Rock r : box2)
            System.out.println(r);
    }
    
    /** Tester for arraylist of rocks */
    public static void rockArrayListTest() {
        ArrayList<Rock> box = new ArrayList<>(TEST_COUNT); // Optimizing initialization to necessary size
        
        for (int i = 0; i < TEST_COUNT; i++)
            box.add( new Rock() );
        
        System.out.println("A BOX OF ROCKS");
        for(Rock r : box)
            System.out.println(r);
        
        System.out.println("\nA BOX OF ERODED ROCKS");
        for (Rock r: box)
            r.erode();
        
        for(Rock r : box)
            System.out.println(r);
        
        ArrayList<Rock> box2 = Rock.split(box);
        System.out.println("\nA BOX WITH A SPLIT ROCK");
        for(Rock r : box2)
            System.out.println(r);
    }
}