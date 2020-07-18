/**
 * This program creates a drawing of a dolphin in the ocean. When you click your mouse, a bubble appears.
 *
 * @author Mohamed Samb
 * @version 2/10/19
 */
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.Timer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;
import java.util.Scanner;


public class DolphinDrawing  extends JPanel implements Runnable, MouseListener
{

private Dimension d;
int BOARD_WIDTH=500;
int BOARD_HEIGHT=500;
int x = 0;
int bubble = 0;
 private Thread animator;

 
    public DolphinDrawing()
    {
          addMouseListener(this);
        setFocusable(true);
        d = new Dimension(BOARD_WIDTH, BOARD_HEIGHT);
        
       
            if (animator == null ) 
            {
            animator = new Thread(this);
            animator.start();
            }
                    
  
          setDoubleBuffered(true);
     }
    
  



  public void paint(Graphics g){
      super.paint(g);
      g.setColor(Color.blue);
      g.fillRect(0, 0, 500, 500);//makes the ocean water
      g.setColor(Color.yellow);
      g.fillRect(0, 430, 500, 50);//makes the ocean floor
      g.setColor(Color.green);
      g.fillRect(50, 380, 50, 50);
      g.fillRect(150, 380, 50, 50);
      g.fillRect(250, 380, 50, 50);
      g.fillRect(350, 380, 50, 50);
      g.fillRect(450, 380, 50, 50);//The last five rectangles make seaweed
      Color turqoise = new Color(64,224,208);
      g.setColor(turqoise);
      g.fillOval(100, 170, 300, 100);//makes the dolphins body
      g.fillOval(25, 225, 100, 20);//makes the dolphins snout
      int[] xval = {350, 425, 425};
      int[] yval = {220, 170, 270};
      g.fillPolygon(xval, yval, 3);//makes the dolphin's tail
      int[] xval2 = {230, 265, 300};
      int[] yval2 = {180, 140, 180};
      g.fillPolygon(xval2, yval2, 3);//makes the dolphins fin
      g.fillOval(180, 235, 40, 80);//makes the dolphins flipper
      g.setColor(Color.white);
      g.fillOval(115, 200, 10, 10);//makes the dolphins eye ball
      g.setColor(Color.black);
      g.fillOval(115, 200, 7, 7);//gives the dolphin's eye color
      if(bubble == 1)
      {
          int xvalu = (int) (Math.random() * 400);
	int yvalu = (int) (Math.random() * 400);
	int widhei = (int) (Math.random() * 50);//last three values gives the bubble its size and location
	Color lightBlue = new Color(204, 255, 255);
	g.setColor(lightBlue);//makes and sets the color to a very light blue
	g.fillOval(xvalu, yvalu, widhei, widhei);//makes the bubble
	bubble = 0;//makes it so another bubble isnt made until another click is made
        }
       Toolkit.getDefaultToolkit().sync();
        g.dispose();
}


public void run() {

long beforeTime, timeDiff, sleep;

beforeTime = System.currentTimeMillis();
 int animationDelay = 500;
 long time = 
            System.currentTimeMillis();
    while (true) {//infinite loop
     // spriteManager.update();
      repaint();
      try {
        time += animationDelay;
        Thread.sleep(Math.max(0,time - 
          System.currentTimeMillis()));
      }catch (InterruptedException e) {
        System.out.println(e);
      }//end catch
    }//end while loop

    


}



public void mousePressed(MouseEvent e) {
     int x = e.getX();
     int y = e.getY();
     bubble = 1;//makes the bubble function start
}

public void mouseReleased(MouseEvent e) 
{
	
}

public void mouseEntered(MouseEvent e) 
{
	
}

public void mouseExited(MouseEvent e) 
{
	
}

public void mouseClicked(MouseEvent e) 
{
	
}

}//end of run



//end of class
