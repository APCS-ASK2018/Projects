public class Cube
{
	private int side;
	private int surfaceArea;

	public void setSide(int s)
	{
	    this.side = s;
	}

	public void calculateSurfaceArea( )
	{
	    this.surfaceArea = 6 * this.side * this.side;
	}

	public void print( )
	{
	    System.out.println("The surface area is :: " + this.surfaceArea + "\n");
	}
}