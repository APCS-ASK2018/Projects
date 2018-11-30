public class Circle
{
	private double radius;
	private double area;

	public void setRadius(double rad)
	{
	    this.radius = rad;
	}

	public void calculateArea( )
	{
	    this.area = radius * radius * Math.PI;
	}

	public void print( )
	{
	    System.out.println("The area is :: " + this.area);
	}
}