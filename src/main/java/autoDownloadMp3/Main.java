package autoDownloadMp3;

import java.awt.BorderLayout;
import java.awt.Label;

import javax.swing.JFrame;

public class Main {

	
	//test jwindow
	public static void main(String [] args) {
		
		
		JFrame frame = new JFrame("Test Window");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Label test = new Label("test label");
		
		frame.getContentPane().add(test,BorderLayout.CENTER);
		
		
		frame.pack();
		
		frame.setVisible(true);
		
	}
	
	
	
}
