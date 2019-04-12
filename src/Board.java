import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;

import javax.swing.*;

public class Board extends JPanel{
	public static final int NUM_OF_PITS = 12;
	public static final int NUM_OF_MANCALAS = 2;
	private Pit[] pits;
	private Mancala[] mancalas;
	private JPanel grid;
	public Board(Dimension d) {
		//this.setSize(d);
		int w = (int) d.getWidth();
		int h = (int) d.getHeight();
		this.setBounds(0,0,w,h);
		System.out.println(w + "   " + h);
		
		
		
		pits = new Pit[NUM_OF_PITS];
		mancalas = new Mancala[NUM_OF_MANCALAS];
		
		mancalas[0] = new Mancala(0, 0, 50, h);
		mancalas[1] = new Mancala(w-50, 0, 50, h);
		
		
		grid = new JPanel();
		//grid.setBounds(50, 0, w-100, h);
	   // grid.setSize(w-100, h);
		GridLayout layout = new GridLayout(2, 6);
		grid.setLayout(layout);
		for(int i = 0; i<pits.length; i++) {
			grid.add(new JButton());
		}
		
		
		JLabel m1 = new JLabel(new MyIcon(mancalas[0], 50, h));
		JLabel m2 = new JLabel(new MyIcon(mancalas[1], 50, h));

		
		
		this.setLayout(new BorderLayout());
		this.add(m1, BorderLayout.WEST);
		this.add(m2, BorderLayout.EAST);
		this.add(grid, BorderLayout.CENTER);
		
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//this.paint(g);
	}
	
	public void paint(Graphics g)  {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		//Rectangle2D.Double board = new Rectangle2D.Double(10, 10, 380, 260);
		//g2.draw(board);
	}
}

