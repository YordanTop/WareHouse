package FrameUpdates;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import SqlManipulation.SqlSubmission;
import Warehouse_frame.MainFrame;
import Warehouse_frame._FrameCreating;

public class DeleteFrame implements _FrameCreating {

	private JPanel Canvas = null;
	
	private final Color ColorPanel = new Color(0,200,200);
	
	private JButton Submit = new JButton("Submit"); 
	
	public DeleteFrame() {	
	}
	
	public DeleteFrame(JPanel canvas) {
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
		JLabel frameName = new JLabel("Delete item!");

		//i<part>: i is stands for item
		JLabel iName = new JLabel("Item's name");
		iName.setPreferredSize(new Dimension(200,20));

		JTextField iFieldName = new JTextField();
		iFieldName.setPreferredSize(new Dimension(200,20));

		JLabel iCName = new JLabel("Company's name:");
		iCName.setPreferredSize(new Dimension(200,20));

		JTextField iFieldCName = new JTextField();
		iFieldCName.setPreferredSize(new Dimension(200,20));


		OptionFrame.add(frameName);

		FieldFrame.add(iName);
		FieldFrame.add(iFieldName);

		FieldFrame.add(iCName);
		FieldFrame.add(iFieldCName);


		JTextField[] fields = new JTextField[]{
				iFieldName,iFieldCName
		};

		Submition.add(Submit);

		Submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(SqlSubmission.isFieldsEmpty(fields) == false){
					SqlSubmission.SqlDelete("DELETE FROM Items\n" +
							"WHERE name = ? AND id IN (\n" +
							"    SELECT i.id\n" +
							"    FROM Items i\n" +
							"    JOIN Orders o ON i.id = o.items_id\n" +
							"    JOIN Company_Customer cc ON o.company_id = cc.id\n" +
							"    WHERE i.name = ? AND cc.name = ?\n" +
							");",fields);
					JOptionPane.showMessageDialog(null,"This delete was successful","",JOptionPane.INFORMATION_MESSAGE);

				}
			}
		});

		Canvas.setBackground(ColorPanel);
	}
	
	

}
