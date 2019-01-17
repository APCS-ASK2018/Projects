
public class Quadratic
{
    private int a, b, c;
    private double realPart;
    private double sqrtPart;
    private boolean isImaginary;

    public Quadratic() {}
    
    public Quadratic(int quadA, int quadB, int quadC)
    {
        setEquation(quadA, quadB, quadC);
    }

    public void setEquation(int quadA, int quadB, int quadC)
    {
        a = quadA;
        b = quadB;
        c = quadC;
        calcRoots();
    }

    private void calcRoots( )
    {
        int determinant = b * b - 4 * a * c;
        isImaginary = determinant < 0;
        
        realPart = - (double) b / (2 * a);
        
        sqrtPart = isImaginary ? Math.sqrt(- determinant) : Math.sqrt(determinant);
        sqrtPart /= 2 * a;
    }

    public void print( )
    {
        String root1, root2;
        if(isImaginary) {
            root1 = String.format("%.3f - %.3fi", realPart, sqrtPart);
            root2 = String.format("%.3f + %.3fi", realPart, sqrtPart);
        } else {
            root1 = String.format("%.3f", realPart - sqrtPart);
            root2 = String.format("%.3f", realPart + sqrtPart);
        }
        
        System.out.println("root1 :: " + root1 + "\nroot2 :: " + root2);
    }
}