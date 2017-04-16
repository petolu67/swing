/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jframe;

/**
 *
 * @author Usuario
 */
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JWindow;

public class Ventanas {
  public static void main(String[] args) {
      Marco mc= new Marco();
      
    JFrame f = new JFrame("Otro JFrame");
    f.setSize(200, 100);
    f.setLocation(50, 200);
    f.setBackground(Color.BLUE);
    f.setVisible(true);
      
      }
  /*--clase interna que crea los frames........
  class Marco extends JFrame {
    public Marco() {
    JFrame f = new JFrame("The Frame");
    f.setSize(300, 300);
    f.setLocation(100, 100);

    JWindow w = new JWindow();
    w.setSize(300, 300);
    w.setLocation(500, 100);

    f.setVisible(true);
    w.setVisible(true);
  }
}//-------------------------------------------*/
  
}  
