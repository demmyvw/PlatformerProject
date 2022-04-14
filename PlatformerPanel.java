import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Timer;
import java.awt.Dimension;
import java.awt.Toolkit;
public class PlatformerPanel extends JPanel implements ActionListener
{
   Player player;
   Timer timer;
   ArrayList<Obstacle> obstacles = new ArrayList<>();
   public PlatformerPanel()
   {
      makeObstacles();
      player = new Player(50,50,this);
      timer = new Timer();
      timer.schedule(new TimerTask(){
         public void run()
         {
            player.set();
            repaint();
         }
      }, 0, 17);
   }
   public void makeObstacles()
   {
      for(int i=0; i<800; i+=25){
         obstacles.add(new Obstacle(i, 0, 25, 25));
         obstacles.add(new Obstacle(i, 550, 25, 25));
      }
      for(int i=25; i<550; i+=25){
         obstacles.add(new Obstacle(0, i, 25, 25));
         obstacles.add(new Obstacle(775, i, 25, 25));
      }
      for(int i=25; i<125; i+=25){
         obstacles.add(new Obstacle(i, 100, 25, 25));
      }
      for(int i=200; i<300; i+=25){
         obstacles.add(new Obstacle(i, 250, 25, 25));
      }
      for(int i=600; i<700; i+=25){
         obstacles.add(new Obstacle(i, 200, 25, 25));
      }
      for(int i=450; i<550; i+=25){
         obstacles.add(new Obstacle(i, 425, 25, 25));
      }
      for(int i=100; i<200; i+=25){
         obstacles.add(new Obstacle(i, 400, 25, 25));
      }
      for(int i=400; i<500; i+=25){
         obstacles.add(new Obstacle(i, 300, 25, 25));
      }
      
   }
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      Graphics2D gtd = (Graphics2D) g;
      player.draw(gtd);
      for(Obstacle obstacle: obstacles){
         obstacle.draw(gtd);
      }
      gtd.setColor(Color.GREEN);
      gtd.fillRect(750,25,25,25);
   }
   void keyPressed(KeyEvent e)
   {
      if(e.getKeyChar() == 'w'){
         player.up = true;
      }
      if(e.getKeyChar() == 'a'){
         player.left = true;
      }
      if(e.getKeyChar() == 's'){
         player.down = true;
      }
      if(e.getKeyChar() == 'd'){
         player.right = true;
      }
   }
   void keyReleased(KeyEvent e)
   {
      if(e.getKeyChar() == 'w'){
         player.up = false;
      }
      if(e.getKeyChar() == 'a'){
         player.left = false;
      }
      if(e.getKeyChar() == 's'){
         player.down = false;
      }
      if(e.getKeyChar() == 'd'){
         player.right = false;
      }
   }
   public void actionPerformed(ActionEvent ae)
   {
      
   }
   
}