public class Fizz extends Champion
{
    private static double health = 558.48;
    private static double mana = 267.2;
    private static double armor = 22.412;
    private static double magicresist = 32.1;
    private static int movementspeed = 335;
    
    Fizz(String name, String nick, int vl)
    {
        super(name, nick, vl);
    }
    
    public double health() {return health;}
    public double mana() {return mana;}
    public double armor() {return armor;}
    public double magicresist() {return magicresist;}
    public int movementspeed() {return movementspeed;}
}
