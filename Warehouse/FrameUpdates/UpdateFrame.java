package FrameUpdates;

import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import SqlManipulation.SqlSubmission;
import Warehouse_frame._FrameCreating;

public class UpdateFrame implements _FrameCreating {

	private JPanel Canvas = null;
	
	private final Color ColorPanel = new Color(214, 243, 97);
	
	JButton Submit = new JButton("Submit");
	
	
	public UpdateFrame() {
		
	}

	public UpdateFrame(JPanel canvas) {
		Canvas = canvas;
	}


	@Override
	public void CreateFrame() {
		JTabbedPane tabs = new JTabbedPane();

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
		JLabel frameName = new JLabel("Update item!");

		//i<part>: i is stands for item
		JLabel iName = new JLabel("Item's name");
		iName.setPreferredSize(new Dimension(200,20));

		JTextField iFieldName = new JTextField();
		iFieldName.setPreferredSize(new Dimension(200,20));

		JLabel iPrice = new JLabel("Item's new quantities");
		iPrice.setPreferredSize(new Dimension(200,20));

		JTextField iFieldPrice = new JTextField();
		iFieldPrice.setPreferredSize(new Dimension(200,20));

		OptionFrame.add(frameName);

		FieldFrame.add(iName);
		FieldFrame.add(iFieldName);

		FieldFrame.add(iPrice);
		FieldFrame.add(iFieldPrice);

		Submition.add(Submit);
		Submit.addActionListener(new SqlSubmission("Select * From Orders"));

		Canvas.setBackground(ColorPanel);

	}
	
}
