import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.Timer;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Color;
public class PlatformerFrame extends JFrame
{
   public static Color grey = new Color(128,128,128);
   public PlatformerFrame()
   {
      PlatformerPanel panel = new PlatformerPanel();
      panel.setLocation(0,0);
      panel.setSize(this.getSize());
      panel.setBackground(grey);
      panel.setVisible(true);
      this.add(panel);
      addKeyListener(new KeyChecker(panel));
   }
}