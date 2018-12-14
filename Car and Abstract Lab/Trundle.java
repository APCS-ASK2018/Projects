public class Trundle extends Champion
{
    private static double health = 616.28;
    private static double mana = 281.6;
    private static double armor = 27.536;
    private static double magicresist = 32.1;
    private static int movementspeed = 350;
    
    Trundle(String name, String nick, int vl)
    {
        super(name, nick, vl);
    }
    
    public double health() {return health;}
    public double mana() {return mana;}
    public double armor() {return armor;}
    public double magicresist() {return magicresist;}
    public int movementspeed() {return movementspeed;}
}
