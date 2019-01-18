
public class Name
{
    private String[] name;

    public Name()
    {
    }

    public Name(String s)
    {
        setName(s);
    }

    public void setName(String s)
    {
        name = s.split("\\s");
    }

    public String getFirst()
    {
        return name[0];
    }

    public String getLast()
    {
        return name[1];
    }

    public String toString()
    {
        return String.join(" ", name);
    }
}