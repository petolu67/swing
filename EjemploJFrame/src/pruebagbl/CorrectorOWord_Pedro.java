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
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author profesor
 */
public class CorrectorOWord_Pedro extends JFrame {
    
    public static void main(String[] args) {
        
     CorrectorOWord_Pedro frame = new CorrectorOWord_Pedro();
     
     Container container = frame.getContentPane();
     
     GridBagLayout gridbag = new GridBagLayout();
     
     GridBagConstraints c = new GridBagConstraints();
     
     container.setLayout(gridbag);
     
     // No se encontró
     JLabel noSencontro= new JLabel("No se encontró:");
     
     noSencontro.setBorder(BorderFactory.createLineBorder(Color.red));
     c.gridx=0;c.gridy=0;
     c.anchor= GridBagConstraints.FIRST_LINE_START;
     c.anchor= GridBagConstraints.NORTHWEST;
     c.gridwidth=GridBagConstraints.REMAINDER;
     c.weightx=1;
     c.weighty=0;
               
     container.add(noSencontro,c);
     
     // JtextArea.............
     
     JTextArea textANo = new JTextArea(6,25);
     c.gridy=1;
     c.gridwidth=GridBagConstraints.RELATIVE;
     c.gridheight=3;
     container.add(textANo,c);
     c.gridheight=1;
     //JButon 3...
     
     JButton reanudar = new JButton("Reanudar");
     JButton omitir= new JButton("Omitir todas");
     JButton agregar= new JButton("Agregar al diccionatio");
     c.gridx=2;c.gridy=1;
     c.gridwidth=GridBagConstraints.REMAINDER;
     container.add(reanudar,c);
     c.gridy=2;
     c.insets=new Insets(5,0,5,0);
     container.add(omitir,c);
     c.insets=new Insets(0,0,0,0);
     c.gridy=3;
     container.add(agregar,c);
     
     
     frame.setSize(400,300);
     frame.setTitle("Ortografía y Gramática");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setVisible(true);
     
    }
    
}
