package FrameUpdates;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import SqlManipulation.SqlSubmission;
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

		FieldFrame.setLayout(new GridLayout(5,2));
		
		JPanel Submition = new JPanel();
		Submition.setBackground(ColorPanel);
		
		Canvas.add(OptionFrame);
		Canvas.add(FieldFrame);
		Canvas.add(Submition);
		
		//Layout objects
		JLabel frameName = new JLabel("Insert item!");
		
		//i<part>: i is stands for item
		JLabel iName = new JLabel("Item's name:");
		iName.setPreferredSize(new Dimension(200,20));

		JTextField iFieldName = new JTextField();
		iFieldName.setPreferredSize(new Dimension(200,20));


		JLabel iQuantity = new JLabel("Item's quantity:");
		iQuantity.setPreferredSize(new Dimension(200,20));

		JTextField iFieldQuantity = new JTextField();
		iFieldQuantity.setPreferredSize(new Dimension(200,20));


		JLabel iCompanyName = new JLabel("Company's name:");
		iCompanyName.setPreferredSize(new Dimension(200,20));

		JTextField iFieldCompanyName  = new JTextField();
		iFieldCompanyName.setPreferredSize(new Dimension(200,20));


		JLabel iCOwner = new JLabel("Company's owner:");
		iCOwner.setPreferredSize(new Dimension(200,20));

		JTextField iFieldCOwner = new JTextField();
		iFieldCOwner.setPreferredSize(new Dimension(200,20));


		JLabel iCAddress = new JLabel("Company's address:");
		iCAddress.setPreferredSize(new Dimension(200,20));

		JTextField iFieldCAddress = new JTextField();
		iFieldCAddress.setPreferredSize(new Dimension(200,20));

		OptionFrame.add(frameName);
		
		FieldFrame.add(iName);
		FieldFrame.add(iFieldName);


		FieldFrame.add(iQuantity);
		FieldFrame.add(iFieldQuantity);

		FieldFrame.add(iCompanyName);
		FieldFrame.add(iFieldCompanyName);

		FieldFrame.add(iCOwner);
		FieldFrame.add(iFieldCOwner);

		FieldFrame.add(iCAddress);
		FieldFrame.add(iFieldCAddress);

		JTextField[] fields = new JTextField[]{
				iFieldCompanyName,iFieldCOwner,iFieldCAddress,iFieldName,iFieldQuantity,
		};
//When the submit button is clicked
		Submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if(SqlSubmission.isFieldsEmpty(fields) == false){
					SqlSubmission.SqlInsertion(
							"INSERT INTO Company_Customer (name, owner, address)\n" +
									"VALUES (?, ?, ?);\n"+
									"INSERT INTO Items (name, quantities)\n" +
									"VALUES (?, ?);"+
									"INSERT INTO Orders (items_id, company_id, order_data)\n" +
									"VALUES (\n" +
									"    (SELECT id FROM Items WHERE name =?),\n" +
									"    (SELECT id FROM Company_Customer WHERE name =?),\n" +
									"    CURRENT_TIMESTAMP\n" +
									");"
							,fields
					);
					JOptionPane.showMessageDialog(null,"This insertion was successful","",JOptionPane.INFORMATION_MESSAGE);

				};
			}
		});
		Submition.add(Submit);
				
		Canvas.setBackground(ColorPanel);
	}
}
