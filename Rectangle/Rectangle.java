public class Rectangle
{
	private int length;
	private int width;
	private int perimeter;

	public void setLengthWidth(int len, int wid )
	{
		length=len;
		width=wid;
	}

	public void calculatePerimeter( )
	{
	    this.perimeter = 2 * (this.length + this.width);
	}

	public void print( )
	{
	    System.out.println("The perimeter is :: " + this.perimeter + "\n");
	}
}
