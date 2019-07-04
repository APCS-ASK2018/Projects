import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.Canvas;

public class Gasket extends Canvas implements Runnable
{
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    public Gasket()
    {
        setBackground(Color.WHITE);
    }

    public void paint( Graphics window )
    {
        window.setColor(Color.BLUE);
        window.setFont(new Font("ARIAL",Font.BOLD,24));
        window.drawString("Sierpinski's Gasket", 25, 50);

        gasket(window, (WIDTH-10)/2, 20, WIDTH-40, HEIGHT-20, 40, HEIGHT-20, randNum());
    }

    public void gasket(Graphics window, int x1, int y1, int x2, int y2, int x3, int y3, int depth)
    {
        if(depth <= 0) return;

        window.drawLine(x1, y1, x2, y2);
        window.drawLine(x2, y2, x3, y3);
        window.drawLine(x1, y1, x3, y3);

        int
        a1 = midPoint(x1, x2),
        b1 = midPoint(y1, y2),

        a2 = midPoint(x1, x3),
        b2 = midPoint(y1, y3),

        a3 = midPoint(x2, x3),
        b3 = midPoint(y2, y3);

        gasket(window, x1, y1, a1, b1, a2, b2, depth - 1);
        gasket(window, a1, b1, x2, y2, a3, b3, depth - 1);
        gasket(window, a2, b2, a3, b3, x3, y3, depth - 1);
    }

    public int midPoint(int x1, int x2) {return (x1 + x2) / 2;}

    public int randNum() {return (int) (Math.random() * 5) + 1;}

    public void run()
    {
        try{
            Thread.currentThread().sleep(3);
        }
        catch(Exception e)
        {
        }
    }
}