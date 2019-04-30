import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;

public class Frame extends JFrame {
	private Board b;
	private Data model;
	public Frame(Data model) {
		this.model = model;
		this.setTitle("Mancala");
		setSize(500,300);
		this.setResizable(false);
		this.setLayout(new FlowLayout());
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void initialGame(MancalaColors strategy) {
		b = new Board( model, strategy);
		add(b);	
		model.addChangeListener(b);
		this.setLayout(new FlowLayout());
		this.pack();
	}
	public Board getBoard() {
		return b;
	}
}
