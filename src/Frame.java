import java.awt.FlowLayout;

import javax.swing.JFrame;

public class Frame extends JFrame {
	private Board b;
	public Frame(Data model) {
<<<<<<< HEAD
		
		this.setTitle("Mancala");
=======
		setSize(400,300);
>>>>>>> upstream/master
		this.setResizable(false);
		b = new Board(this.getSize(), model);
		
		this.setLayout(new FlowLayout());
		add(b);	
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public Board getBoard() {
		return b;
	}
}
