import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Timer;
import java.awt.Dimension;
import java.awt.Toolkit;
public class Player
{
   PlatformerPanel panel;
   Rectangle hitbox;
   int xPos, yPos, width, height;
   double xSpeed, ySpeed;
   boolean left, right, up, down, game = false;
   public Player(int xPos, int yPos, PlatformerPanel panel)
   {
      this.panel = panel;
      this.xPos = xPos;
      this.yPos = yPos;
      width = 25;
      height = 25;
      hitbox = new Rectangle(xPos,yPos,width,height);
   }
   public void set()
   {
      if(left && right || !left && !right){
         xSpeed *= 0.8;
      }
      else if(left && !right){
         xSpeed--;
      }
      else if (right && !left){
         xSpeed++;
      }
      if(xSpeed > 0 && xSpeed < 0.75){
         xSpeed=0;
      }
      if(xSpeed < 0 && xSpeed > -0.75){
         xSpeed=0;
      }
      if(xSpeed > 6){
         xSpeed=6;
      }
      if(xSpeed < -6){
         xSpeed=-6;
      }
      if(up){
         hitbox.y++;
         for(Obstacle obstacle: panel.obstacles){
            if(obstacle.hitbox.intersects(hitbox)){
               ySpeed = -9;
            }
         }
         hitbox.y--;
      }
      ySpeed += .3;
      hitbox.x += xSpeed;
      for(Obstacle obstacle: panel.obstacles){
         if(hitbox.intersects(obstacle.hitbox)){
            hitbox.x -= xSpeed;
            while(!obstacle.hitbox.intersects(hitbox)){
               hitbox.x += Math.signum(xSpeed);
            }
            hitbox.x -= Math.signum(xSpeed);
            xSpeed = 0;
            xPos = hitbox.x;
         }
      }
      hitbox.y += ySpeed;
      for(Obstacle obstacle: panel.obstacles){
         if(hitbox.intersects(obstacle.hitbox)){
            hitbox.y -= ySpeed;
            while(!obstacle.hitbox.intersects(hitbox)){
               hitbox.y += Math.signum(ySpeed);
            }
            hitbox.y -= Math.signum(ySpeed);
            ySpeed = 0;
            yPos = hitbox.y;
         }
      }
      if(hitbox.x>725 && hitbox.y<50){
      game = true;
      }
      if(game){
         JOptionPane.showMessageDialog(null, "Mission Complete!", "You Win!", JOptionPane.INFORMATION_MESSAGE);
         System.exit(1);
      }
      xPos += xSpeed;
      yPos += ySpeed;
      hitbox.x = xPos;
      hitbox.y = yPos;
   }
   public void draw(Graphics2D gtd)
   {
      gtd.setColor(Color.RED);
      gtd.fillRect(xPos, yPos, width, height);
   }
}