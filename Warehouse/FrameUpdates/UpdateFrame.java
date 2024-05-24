package FrameUpdates;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

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

		//Layout objects
		JLabel frameName = new JLabel("Update item!");

		//i<part>: i is stands for item
		JLabel iName = new JLabel("Item's name:");
		iName.setPreferredSize(new Dimension(200,20));

		JTextField iFieldName = new JTextField();
		iFieldName.setPreferredSize(new Dimension(200,20));

		JLabel iQuntity = new JLabel("Item's new quantities:");
		iQuntity.setPreferredSize(new Dimension(200,20));

		JTextField iFieldQuantity = new JTextField();
		iFieldQuantity.setPreferredSize(new Dimension(200,20));

		JLabel iCName = new JLabel("Company's name:");
		iCName.setPreferredSize(new Dimension(200,20));

		JTextField iFieldCName = new JTextField();
		iFieldCName.setPreferredSize(new Dimension(200,20));

		OptionFrame.add(frameName);

		FieldFrame.add(iName);
		FieldFrame.add(iFieldName);

		FieldFrame.add(iQuntity);
		FieldFrame.add(iFieldQuantity);

		FieldFrame.add(iCName);
		FieldFrame.add(iFieldCName);

		FieldFrame.setLayout(new GridLayout(3,3));

		JTextField[] fields = new JTextField[]{
				iFieldName,iFieldQuantity,iFieldCName
		};

		Submition.add(Submit);

		Submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(SqlSubmission.isFieldsEmpty(fields) == false){
					SqlSubmission.SqlUpdate("UPDATE Items\n" +
							"SET quantities = ?\n" +
							"WHERE id IN (\n" +
							"    SELECT Items.id\n" +
							"    FROM Items\n" +
							"    JOIN Orders ON Items.id = Orders.items_id\n" +
							"    JOIN Company_Customer ON Orders.company_id = Company_Customer.id\n" +
							"    WHERE Items.name = ? AND Company_Customer.name = ?\n" +
							");",fields);
					JOptionPane.showMessageDialog(null,"This update was successful","",JOptionPane.INFORMATION_MESSAGE);

				}
			}
		});

		Canvas.add(OptionFrame);
		Canvas.add(FieldFrame);
		Canvas.add(Submition);

		Canvas.setBackground(ColorPanel);

	}
	
}
