import java.util.Scanner; 

public class DistanceRunner
{
    public static Scanner KB = new Scanner(System.in);

    public static void main( String[] args )
    {
        Distance calc = new Distance();

        for(int i = 0; i < 2; i++) {
            int[] set = getPos();
            calc.setCoordinates(set[0], set[1], set[2], set[3]);
            calc.print();
            System.out.println();
        }
    }

    private static int[] getPos() {
        final String[] PROMPT = {"X1", "Y1", "X2", "Y2"};
        int[] pos = new int[4];
        int axisInput = 0;
        while(axisInput < 4) {
            try {
                System.out.print("Enter " + PROMPT[axisInput] + " :: ");
                pos[axisInput] = Integer.parseInt(KB.nextLine());
                axisInput++;
            } catch(NumberFormatException e) {
                System.out.println("Input a proper integer!");
            }
        }

        return pos;
    }
}