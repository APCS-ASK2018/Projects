public class Ferrari extends Car
{
    //Create your Ferraris here.
    //If you have more than two(including constructor, if one is created), you're probably doing something wrong.
    public Ferrari(String n, int maxS, int mile) {
        super(n,maxS,mile);
    }
    
    @Override
    public String toString() {return "Ferrari " + super.toString();}
}
//your other cars should follow this one's format.  