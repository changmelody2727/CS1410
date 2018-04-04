package animation;

import java.awt.Color;
import java.awt.Graphics;

public class Animation
{
    /**
     * This is the method that you need to rewrite to create a custom animation. This method is called repeatedly as the
     * animation proceeds. It needs to draw to g how the animation should look after t milliseconds have passed.
     * 
     * @param g Graphics object on which to draw
     * @param t Number of milliseconds that have passed since animation started
     */
    public static void paintFrame (Graphics g, int t, int height, int width)
    {

        drawStripe1(g, 305, 200 + (int) (50 * Math.sin(t * Math.PI / 1000)), 1, Color.RED);
        drawStripe1(g, 5 + t / 10, 200 + (int) (50 * Math.sin(t * Math.PI / 1000)), 1, Color.RED);
        drawCircle(g, 5 + t / 10, 400, t / 2000., Color.BLUE);

        // One house moves steadily from left to right. It starts out invisible and
        // gets larger as time goes on. After two seconds it turns right.
        if (t % 200 < 100)
        {
            drawStripe1(g, 0, 0, t / 2000., Color.darkGray);
            drawStripe2(g, 0, 200, t / 2000., Color.GRAY);
            drawStripe1(g, 0, 400, t / 2000., Color.darkGray);
            drawStripe2(g, 0, 600, t / 2000., Color.GRAY);
        }
        else
        {
            drawStripe1(g, 0, 0, t / 2000., Color.GRAY);
            drawStripe2(g, 0, 200, t / 2000., Color.darkGray);
            drawStripe1(g, 0, 400, t / 2000., Color.GRAY);
            drawStripe2(g, 0, 600, t / 2000., Color.darkGray);
        }

        // The other house follows a sine wave and stays the same size. After three
        // seconds it starts moving up and down.
        if (t > 0)
        {
            drawCircle(g, t / 5, 200 + (int) (50 * Math.sin(t * Math.PI / 10)), t / 2000., Color.BLUE);
            drawCircle(g, t / 7, 100 + (int) (50 * Math.sin(t * Math.PI / 100)), t / 2000., Color.MAGENTA);
            drawCircle(g, t / 10, 300 + (int) (50 * Math.sin(t * Math.PI / 1000)), 1, Color.YELLOW);
            drawCircle(g, t / 11, 400 + (int) (50 * Math.sin(t * Math.PI / 500)), 2000. / t, Color.cyan);
            drawCircle(g, t / 4, 400 + (int) (50 * Math.sin(t * Math.PI / 250)), 200. / t, Color.ORANGE);
        }

        if (t < 3000)
        {
            drawCircle(g, 5 + t / 10, 200, t / 2000., Color.pink);
        }
        else
        {
            drawCircle(g, 300, 200 + (t - 2000) / 10, t / 2000., Color.pink);
        }

    }

    /**
     * Draws a house on g whose upper-left corner is at coordinate (x,y) using the provided scaling factor and color.
     */
    public static void drawStripe1 (Graphics g, int x, int y, double scale, Color color)
    {
        g.setColor(color);
        g.fillRect(x, y, 1000, 200);
    }

    public static void drawStripe2 (Graphics g, int x, int y, double scale, Color color)
    {
        g.setColor(color);
        g.fillRect(x, y, 1000, 200);
    }

    public static void drawCircle (Graphics g, int x, int y, double scale, Color color)
    {
        g.setColor(color);
        g.fillOval(x, y, (int) (50 * scale), (int) (50 * scale));
    }

}
