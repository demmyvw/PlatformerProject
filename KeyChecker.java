import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Timer;
import java.awt.Dimension;
import java.awt.Toolkit;
public class KeyChecker extends KeyAdapter
{
   PlatformerPanel panel;
   public KeyChecker(PlatformerPanel panel)
   {
      this.panel = panel;
   }
   public void keyPressed(KeyEvent e)
   {
      panel.keyPressed(e);
   }
   public void keyReleased(KeyEvent e)
   {
      panel.keyReleased(e);
   }
}