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
	private int w;
	private int h;
	
	public Board(Dimension d) {
		
		w = 380;
		h = 180;
		this.setBounds(10,60,w,h);
		
		
		
		pits = new Pit[NUM_OF_PITS];
		mancalas = new Mancala[NUM_OF_MANCALAS];
		
		//initialize mancala
		mancalas[0] = new Mancala(0, 25, 40, 130);
		mancalas[1] = new Mancala(0, 25, 40, 130);
		
		//initialize pits
		for(int i = 0; i<6; i++) {
			pits[i] = new Pit(0, 40, 45, 50, 4);
		}
		for(int i = 6; i<12; i++) {
			pits[i] = new Pit(0, 0, 45, 50, 4);
		}
		
		
		//components
		grid = new JPanel();
		//grid.setBounds(x, y, width, height);
		GridLayout layout = new GridLayout(2, 6);
		grid.setLayout(layout);
		for(int i = 0; i<pits.length; i++) {	
			JButton b = new JButton(new MyIcon(pits[i],45,50));
			b.setSize(45,50);
			grid.add(b);
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
//		Rectangle2D.Double board = new Rectangle2D.Double(10, 60, w, h);  //x = 10; y = 60
		//g2.draw(board);
	}
}

