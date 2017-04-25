/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebagbl;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author profesor
 */
public class PruebaGBL1 extends JFrame{

  static JPanel panel;
   static JButton button;
   
  public static void main(String[] args) {
     PruebaGBL1 frame = new PruebaGBL1();
     
     Container container = frame.getContentPane();
     
     GridBagLayout gridbag = new GridBagLayout();
     
     GridBagConstraints c = new GridBagConstraints();
     
     container.setLayout(gridbag);
     
     panel = new JPanel();
     c.weightx = 1;
     c.weighty = 1;
     c.gridx = 0;
     c.gridy = 0;
    // c.fill=GridBagConstraints.HORIZONTAL;
    // c.fill=GridBagConstraints.VERTICAL;
     c.fill=GridBagConstraints.BOTH;
     panel.setBackground(Color.red);
     container.add(panel, c);
     
      panel = new JPanel();
     c.weightx = 0.5;
     c.weighty = 0.25;
     
     c.gridx = 1;
     c.gridy = 1;
     panel.setBackground(Color.BLUE);
     container.add(panel, c);
   
     
     c.weightx = 0.0;
     c.weighty = 0.0;
     c.fill=GridBagConstraints.NONE;
     button = new JButton("boton (2,0)");
     c.gridx = 0;
     c.gridy = 2;
     //c.gridwidth=2;
     c.gridwidth=GridBagConstraints.RELATIVE;
     container.add(button, c);
     
     button = new JButton("boton (0,2)");
     c.gridx = 2;
     c.gridy = 0;
     container.add(button, c);
     
     button = new JButton("boton (2,2)");
    
     GridBagConstraints c1 = new GridBagConstraints();
     c1.gridx = 2;
     c1.gridy = 2;
     container.add(button, c1);
     
     frame.setSize(400,300);
     frame.setTitle("Curso de Java.GridBagLayout");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setVisible(true); 
  }
    
}
