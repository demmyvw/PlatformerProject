import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Timer;
import java.awt.Dimension;
import java.awt.Toolkit;
public class Obstacle
{
   int x, y, width, height;
   Rectangle hitbox;
   public Obstacle(int x, int y, int width, int height)
   {
      this.x = x;
      this.y = y;
      this.width = width;
      this.height = height;
      hitbox = new Rectangle(x, y, width, height);
   }
   public void draw(Graphics2D gtd)
   {
      gtd.setColor(Color.BLUE);
      gtd.fillRect(x, y, width, height);
   }
}