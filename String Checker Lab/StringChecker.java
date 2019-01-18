
public class StringChecker
{
    private String word;

    public StringChecker()
    {
    }

    public StringChecker(String s)
    {
        setString(s);
    }

    public void setString(String s)
    {
        word=s;
    }

    public boolean findLetter(char c)
    {
        return word.indexOf(c) != -1;
    }

    public boolean findSubString(String s)
    {
        return word.indexOf(s) != -1;
    }

    public String toString()
    {
        return word;
    }
}