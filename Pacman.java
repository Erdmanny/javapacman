/* Drew Schuster */
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.Point2D;
import javax.swing.JApplet;
import java.awt.*;
import java.util.*;
import java.lang.*;

/* This class contains the entire game... most of the game logic is in the Board class but this
   creates the gui and captures mouse and keyboard input, as well as controls the game states */
public class Pacman extends JApplet implements MouseListener, KeyListener
{
  Board b=new Board();  // Create a new board
  javax.swing.Timer frameTimer;   // This timer is used to do request new frames be drawn
 

  /* This constructor creates the entire game essentially */   
  public Pacman()
  {
    b.requestFocus();
    JFrame f=new JFrame(); // Create and set up window frame
    f.setSize(420,460);
    f.add(b,BorderLayout.CENTER); // Add the board to the frame
    b.addMouseListener(this);  //Set listeners for mouse actions and button clicks
    b.addKeyListener(this);
    f.setVisible(true);    // Make frame visible, disable resizing
    f.setResizable(false);
    b.New=1;    // Set the New flag to 1 because this is a new game
    /* Create a timer that calls stepFrame every 30 milliseconds */
    frameTimer = new javax.swing.Timer(30,new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          b.stepFrame(false, frameTimer);
        }
      });
    b.stepFrame(true, frameTimer); // Manually call the first frameStep to initialize the game.
    frameTimer.start();  // Start the timer
    b.requestFocus();
  }


  /* Handles user key presses*/
  public void keyPressed(KeyEvent e) 
  {
    b.keyPressedHandler(e);
  }

  /* This function detects user clicks on the menu items on the bottom of the screen */
  public void mousePressed(MouseEvent e){
    b.mousePressedHandler(e);
  }
  
 
  public void mouseEntered(MouseEvent e){}
  public void mouseExited(MouseEvent e){}
  public void mouseReleased(MouseEvent e){}
  public void mouseClicked(MouseEvent e){}
  public void keyReleased(KeyEvent e){}
  public void keyTyped(KeyEvent e){}
  
  /* Main function simply creates a new pacman instance*/
  public static void main(String [] args)
  {
      Pacman c = new Pacman();
  } 
}
