package autoDownloadMp3;

import java.awt.FlowLayout;
import java.awt.Label;
import javax.swing.JFrame;

public class Main {

	
	//test jwindow
	public static void main(String [] args) {
		
		
		
		JFrame lay = new JFrame("window");
		
		
		
		
		Label test = new Label("test label");
		Label test2 = new Label("test label2");
		Label test3 = new Label("test label3");
		Label test4 = new Label("test label4");
		
		
		
		lay.add(test);
		lay.add(test2);
		lay.add(test3);
		lay.add(test4);
		
		
		lay.setSize(500,300);
		lay.setLayout(new FlowLayout());
		
		lay.setVisible(true);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	public int test (int i) {
		
		
		return i;
	}
	
	
	
}
