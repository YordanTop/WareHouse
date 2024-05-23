package FrameUpdates;

import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Warehouse_frame.MainFrame;
import Warehouse_frame._FrameCreating;


public class InsertFrame implements _FrameCreating {
	
	private JPanel Canvas = null;
	
	private final Color ColorPanel = new Color(200,180,200);

	JLabel iName = new JLabel("Item's name!");
	JButton Submit = new JButton("Submit");
	
	public InsertFrame() {
	
	}
	
	public InsertFrame(JPanel canvas) {
		Canvas = canvas;
	}


	@Override
	public void CreateFrame() {
		Canvas.removeAll();
		Canvas.revalidate();
		
		//Types of panels
		JPanel OptionFrame = new JPanel();
		OptionFrame.setBackground(ColorPanel);
		OptionFrame.setBorder(BorderFactory.createEmptyBorder(65,0,0,0));
		
		JPanel FieldFrame = new JPanel();
		FieldFrame.setBackground(ColorPanel);
		
		JPanel Submition = new JPanel();
		Submition.setBackground(ColorPanel);
		
		Canvas.add(OptionFrame);
		Canvas.add(FieldFrame);
		Canvas.add(Submition);
		
		//Layout objects
		JLabel frameName = new JLabel("Insert item!");
		
		//i<part>: i is stands for item
		JLabel iName = new JLabel("Item's name");
		iName.setPreferredSize(new Dimension(200,20));

		JTextField iFieldName = new JTextField();
		iFieldName.setPreferredSize(new Dimension(200,20));

		JLabel iPrice = new JLabel("Item's price");
		iPrice.setPreferredSize(new Dimension(200,20));

		JTextField iFieldPrice = new JTextField();
		iFieldPrice.setPreferredSize(new Dimension(200,20));

		OptionFrame.add(frameName);
		
		FieldFrame.add(iName);
		FieldFrame.add(iFieldName);


		FieldFrame.add(iPrice);
		FieldFrame.add(iFieldPrice);
		
		Submition.add(Submit);
				
		Canvas.setBackground(ColorPanel);
	}
}
