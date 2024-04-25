package FrameUpdates;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Warehouse_frame.MainFrame;
import Warehouse_frame._Submition;

public class DeleteFrame implements _Submition {

	private JPanel Canvas = null;
	
	JLabel iName = new JLabel("Item's name");
	JButton Submit = new JButton("Submit");
	
	
	public DeleteFrame() {	
	}
	
	public DeleteFrame(JPanel canvas) {
		Canvas = canvas;
	}


	@Override
	public void OnSubmit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void CreateFrame() {
		Canvas.removeAll();
		
		JPanel Submition = new JPanel();
		
		Canvas.add(Submition);
		Submition.add(Submit);
	}
	
	

}
