import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.Timer;
import java.awt.Dimension;
import java.awt.Toolkit;
public class PlatformerGame
{
   public static void main(String[] args)
   {
      PlatformerFrame frame = new PlatformerFrame();
      frame.setTitle("Platformer");
      frame.setSize(800,600);
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      frame.setLocation((int)(screenSize.getWidth()/2-frame.getSize().getWidth()/2), (int)(screenSize.getHeight()/2-frame.getSize().getHeight()/2));
      frame.setResizable(false);
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
}