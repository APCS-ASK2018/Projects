public class Viktor extends Champion
{
    private static double health = 516.04;
    private static double mana = 324;
    private static double armor = 22.72;
    private static double magicresist = 30;
    private static int movementspeed = 335;
    
    Viktor(String name, String nick, int vl)
    {
        super(name, nick, vl);
    }
    
    public double health() {return health;}
    public double mana() {return mana;}
    public double armor() {return armor;}
    public double magicresist() {return magicresist;}
    public int movementspeed() {return movementspeed;}
}
