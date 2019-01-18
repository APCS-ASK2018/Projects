
public class CheckerRunner
{
    public static void main ( String[] args )
    {
        StringChecker demo = new StringChecker("chicken");
        System.out.println("looking for c "+demo.findLetter('c'));
        System.out.println("looking for ch "+demo.findSubString("ch"));
        System.out.println("looking for x "+demo.findSubString("x"));
        System.out.println(demo);
        System.out.println();

        demo.setString("alligator");
        System.out.println("looking for g "+demo.findLetter('g'));
        System.out.println("looking for all "+demo.findSubString("all"));
        System.out.println("looking for gater "+demo.findSubString("gater"));
        System.out.println(demo);
        System.out.println();

        demo.setString("COMPUTER SCIENCE IS THE BEST!");
        System.out.println("looking for U " + demo.findLetter('U'));
        System.out.println("looking for COMP SCI " + demo.findSubString("COMP SCI"));
        System.out.println("looking for SCIENCE " + demo.findSubString("SCIENCE"));
        System.out.println(demo);
    }
}