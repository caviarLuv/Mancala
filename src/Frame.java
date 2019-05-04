import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;

/**
 * @author Julia Chin, Stan He, Tsz Ting Yu
 * @version 1.0 5/4/19
 */

/**
 * Frame for Mancala game
 */
public class Frame extends JFrame {
	private Board b;
	private Data model;
	
	/**
	 * Constructs a frame for the Mancala game
	 * @param model - model of Mancala game
	 */
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
	
	/**
	 * Initializes the Mancala game
	 */
	public void initialGame(MancalaColors strategy) {
		b = new Board( model, strategy);
		add(b);	
		model.addChangeListener(b);
		this.setLayout(new FlowLayout());
		this.pack();
	}
	
	/**
	 * Returns Mancala board
	 */
	public Board getBoard() {
		return b;
	}
}
