import java.awt.FlowLayout;

import javax.swing.JFrame;

public class Frame extends JFrame {
	public Frame() {
		setSize(400,300);
		//this.setResizable(false);
		Board b = new Board(this.getSize());
		
		this.setLayout(null);
		add(b);	
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
