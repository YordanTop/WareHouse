package FrameUpdates;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Warehouse_frame.MainFrame;
import Warehouse_frame._Submition;

public class UpdateFrame implements _Submition {

	private JPanel Canvas = null;
	
	JLabel iName = new JLabel("Item's name");
	JButton Submit = new JButton("Submit");
	
	
	public UpdateFrame() {
		
	}

	public UpdateFrame(JPanel canvas) {
		Canvas = canvas;
	}

	@Override
	public void OnSubmit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void CreateFrame() {
		Canvas.removeAll();
		Canvas.add(iName);
		Canvas.setBackground(new Color(0,0,0));
	}
	
}
