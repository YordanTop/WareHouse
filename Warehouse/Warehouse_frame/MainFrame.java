package Warehouse_frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import FrameUpdates.DeleteFrame;
import FrameUpdates.InsertFrame;
import FrameUpdates.UpdateFrame;

public class MainFrame extends JFrame {
	
	//Different main panels
	JPanel rightPanel = new JPanel();
	JPanel leftPanel = new JPanel();
	
	//Search bar

	JTextField searchField = new JTextField();
	JButton searchButton = new JButton("Search");
	
	JPanel searchPanel = new JPanel();
	
	//CRUD buttons
	JPanel crudPanel = new JPanel();
	
	JButton insertButton = new JButton("Insert");
	JButton updateButton = new JButton("Update");
	JButton deleteButton = new JButton("Delete");
	
	//Info insertion panel
	
	JPanel infoInsertionPanel = new JPanel();
	JLabel infoLabel = new JLabel("Info manipulator.");
	
	public MainFrame(String frameName) {
		this.setSize(800, 600);
		this.setResizable(false);
		this.setLayout(new GridLayout(1,2));
		
		//Left Part Layout
		this.add(leftPanel);
		
		//Search Part
		searchField.setPreferredSize(new Dimension(200,20));
		searchButton.setPreferredSize(new Dimension(100, 20));
		
		searchPanel.add(searchField);
		searchPanel.add(searchButton);
		
		//Crud Part
		crudPanel.add(insertButton);
		crudPanel.add(updateButton);
		crudPanel.add(deleteButton);
		crudPanel.setBorder(BorderFactory.createEmptyBorder(0,0,50,0));
		
		//Info Panel
		infoInsertionPanel.setBackground(new Color(255,255,255));
		infoInsertionPanel.setPreferredSize(new Dimension(350, 400));
		infoInsertionPanel.setLayout(new GridLayout(3,1));
		infoInsertionPanel.add(infoLabel);
		
		infoLabel.setBorder(BorderFactory.createEmptyBorder(-50,135,0,0));
		
		
		leftPanel.add(searchPanel);
		leftPanel.add(crudPanel);
		leftPanel.add(infoInsertionPanel);
		
		//Button Actions
		
		insertButton.addActionListener(new ChangeFrames
					(new InsertFrame(infoInsertionPanel)));
		
		updateButton.addActionListener(new ChangeFrames
					(new UpdateFrame(infoInsertionPanel)));
		
		deleteButton.addActionListener(new ChangeFrames
					(new DeleteFrame(infoInsertionPanel)));
		
		
		//Right Part Layout
		this.add(rightPanel);
		rightPanel.setBackground(new Color(0,0,0));
		
		this.setTitle(frameName);
		this.setVisible(true);
	}
	
}