public class ChampInfo
{
    public static void main(String args[])
    {
        Fizz champ1 = new Fizz("Fizz", "the Tidal Trickster", 6);
        System.out.println(champ1.toString());
        // System.out.println("Health = " + champ1.health());
        // System.out.println("Mana = " + champ1.mana());
        // System.out.println("Armor = " + champ1.armor());
        // System.out.println("Magic Resist = " + champ1.magicresist());
        // System.out.println("Movement Speed = " + champ1.movementspeed() + "\n");
        
        Trundle champ2 = new Trundle("Trundle", "the Troll King", 16);
        System.out.println(champ2.toString());
        // System.out.println("Health = " + champ2.health());
        // System.out.println("Mana = " + champ2.mana());
        // System.out.println("Armor = " + champ2.armor());
        // System.out.println("Magic Resist = " + champ2.magicresist());
        // System.out.println("Movement Speed = " + champ2.movementspeed() + "\n");
        
        Viktor champ3 = new Viktor("Viktor", "the Machine Herald", 11);
        System.out.println(champ3.toString());
        // System.out.println("Health = " + champ3.health());
        // System.out.println("Mana = " + champ3.mana());
        // System.out.println("Armor = " + champ3.armor());
        // System.out.println("Magic Resist = " + champ3.magicresist());
        // System.out.println("Movement Speed = " + champ3.movementspeed() + "\n");
    }
}
