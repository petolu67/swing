package jframe;

import javax.swing.*;
import javax.swing.border.*;
import javax.accessibility.*;

import java.awt.*;
import java.awt.event.*;

public class LayeredPaneDemo extends JFrame implements ActionListener     {

    JComboBox layerList;
    JButton makeButton;

    JLayeredPane layeredPane;

    int numFrames = 0;

    String[] layerStrings = { "Default Layer",
			      "Palette Layer",
			      "Modal Layer",
			      "Popup Layer",
			      "Drag Layer" };

    Integer[] layerValues = { JLayeredPane.DEFAULT_LAYER,
			      JLayeredPane.PALETTE_LAYER,
			      JLayeredPane.MODAL_LAYER,
			      JLayeredPane.POPUP_LAYER,
			      JLayeredPane.DRAG_LAYER };

    static ImageIcon[] icon = new ImageIcon[5];

    public LayeredPaneDemo()    {

	super("LayeredPaneDemo");

        if(icon[0] == null) {
           icon[0] = new ImageIcon("src/images/Desert.jpggif", layerStrings[0]);
           icon[1] = new ImageIcon("src/images/Jellyfish.jpg", layerStrings[1]);
           icon[2] = new ImageIcon("src/images/Koala.jpg", layerStrings[2]);
           icon[3] = new ImageIcon("src/images/Penguins.jpg",  layerStrings[3]);
           icon[4] = new ImageIcon("src/images/Tulips.jpg",  layerStrings[4]);
        }

        layerList = new JComboBox(layerStrings);
        layerList.setSelectedIndex(0);

        makeButton = new JButton("Create a Frame");
        makeButton.addActionListener(this);

        layeredPane = getLayeredPane();
	
	JPanel controls = new JPanel();
        controls.add(layerList);
        controls.add(makeButton);     
	controls.setBorder(BorderFactory.createTitledBorder("Add Frames to Specified Layer"));

	JPanel emptyArea = new JPanel();
	emptyArea.setPreferredSize(new Dimension(600, 400));

	Container contentPane = getContentPane();
	// use a layout manager that respects preferred sizes
	contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
	contentPane.add(Box.createRigidArea(new Dimension(0, 10)));
	contentPane.add(controls);
	contentPane.add(Box.createRigidArea(new Dimension(0, 10)));
	contentPane.add(emptyArea);

	for (int i = 0 ; i < icon.length; i++)
	    addNewInternalFrame(i);
		
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == makeButton) {
	    int index = layerList.getSelectedIndex();

            addNewInternalFrame(index);
        }
    }

    private void addNewInternalFrame(int index) {
        JInternalFrame newFrame = new JInternalFrame();
        newFrame.setTitle(layerStrings[index]);

	JPanel contentPane = new JPanel();
	contentPane.setLayout(new BorderLayout());
        contentPane.add(new JLabel(icon[index]), "Center");
        contentPane.setBackground(Color.white);
	contentPane.setMinimumSize(new Dimension(25, 25));

        numFrames++;

        newFrame.setBounds(30*(numFrames%10), 30*(numFrames%10)+55, 200, 160);
	newFrame.setContentPane(contentPane);
                
	Integer layer = layerValues[index];
        layeredPane.add(newFrame, layer); 
        newFrame.setVisible(true);
        try { newFrame.setSelected(true); } catch (java.beans.PropertyVetoException e2) {}
    }

    public static void main(String[] args) {
        JFrame frame = new LayeredPaneDemo();

        WindowListener l = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };
        frame.addWindowListener(l);

        frame.pack();
        frame.setVisible(true);
    }
}