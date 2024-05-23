package Warehouse_frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;

import FrameUpdates.DeleteFrame;
import FrameUpdates.InsertFrame;
import FrameUpdates.UpdateFrame;
import SqlManipulation.SqlSearch;
import SqlManipulation.SqlSubmission;

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

	// Combo Filter
	String[] filterBy = {"None","Quantities","Alphabet","Date"};

	JComboBox filter = new JComboBox(filterBy);

	//Info insertion panel
	
	JPanel infoInsertionPanel = new JPanel();
	JLabel infoLabel = new JLabel("Info manipulator.");

	//Database table

	public static JTable productTable = new JTable();
	JScrollPane productPanel = new JScrollPane(productTable);

	//Table Panel
	JPanel tablePanel = new JPanel();
	
	public MainFrame(String frameName) {
		this.setSize(800, 600);
		this.setResizable(false);
		this.setLayout(new GridLayout(1,2));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
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
		crudPanel.add(filter);
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

		searchButton.addActionListener(new SqlSearch("SELECT CC.name \"Companies\",\n" +
				"       I.name \"Product\",\n" +
				"       I.quantities \"Quantity\", \n" +
				"       O.order_data \"Order data\",\n" +
				"\n" +
				"FROM Company_Customer CC \n" +
				"INNER JOIN Orders O ON CC.id = O.company_id \n" +
				"INNER JOIN Items I ON I.id = O.items_id ",filter,searchField));
		//Right Part Layout
		

		this.add(rightPanel);

		rightPanel.add(tablePanel);
		tablePanel.setPreferredSize(new Dimension(300,500));
		tablePanel.setBackground(Color.BLACK);

		rightPanel.setBackground(new Color(0,0,0));

		tablePanel.add(productPanel);

		productPanel.setPreferredSize(new Dimension(300,400));

		productPanel.setBackground(Color.WHITE);

		this.setTitle(frameName);
		this.setVisible(true);
	}
	
}