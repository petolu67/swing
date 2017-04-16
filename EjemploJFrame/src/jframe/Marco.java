/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jframe;

import java.awt.Color;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JWindow;

/**
 *
 * @author Usuario
 */
class Marco extends JFrame {
    public Marco() {
    JFrame f = new JFrame("The Frame");
    f.setSize(300, 300);
    f.setLocation(100, 100);
    f.setBackground(Color.BLUE);

    JWindow w = new JWindow();
    w.setSize(300, 300);
    w.setLocation(500, 100);
    w.setBackground(Color.BLUE);
    w.setForeground(Color.red);
    
    JDialog d = new JDialog();
    d.setSize(300, 300);
    d.setLocation(700, 300);
    d.setBackground(Color.BLUE);
    d.setForeground(Color.red);

    f.setVisible(true);
    w.setVisible(true);
    d.setVisible(true);
  }
}//-------------------------------------------
