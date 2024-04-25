package Warehouse_frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import java.lang.reflect.*;

import javax.swing.JPanel;

import FrameUpdates.DeleteFrame;
import FrameUpdates.InsertFrame;
import FrameUpdates.UpdateFrame;

public class ChangeFrames implements ActionListener {

	private _Submition Main;
	
	private ArrayList<Class> Options = new ArrayList<Class>();
	
	// @param canvas is a the panel that we are going to put elements in
	// @param panelOption the type of panel
	
	public ChangeFrames(_Submition panelOption) {
		Main =  panelOption;
		
		Options.add(new DeleteFrame().getClass());
		Options.add(new InsertFrame().getClass());
		Options.add(new UpdateFrame().getClass());
	}
	
	/*Checking for a specific option from 
	 *the "Options" list which option is
	 *provided by the constructor! */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(Object obj : Options) {
			if(obj.equals(Main.getClass())) {
				
				Main.CreateFrame();
		
			}
		}
	}
}
