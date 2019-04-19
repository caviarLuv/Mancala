import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Board extends JPanel implements ChangeListener{
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
			pits[i].addChangeListener(this);
		}
		for(int i = 6; i<12; i++) {
			pits[i] = new Pit(0, 0, 45, 50, 4);
			pits[i].addChangeListener(this);
		}
		
		
		//components
		grid = new JPanel();
		//grid.setBounds(x, y, width, height);
		GridLayout layout = new GridLayout(2, 6);
		grid.setLayout(layout);
		for(int i = 0; i<pits.length; i++) {	
			JButton b = new JButton(new MyIcon(pits[i],45,50));
			b.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					((MyIcon)b.getIcon()).getPart().addStone();		
				}
				
			});
			b.setSize(45,50);
			grid.add(b);
		}
		
		
		
		JPanel mancalaA = new JPanel();
		JPanel mancalaB = new JPanel();
		JLabel m1 = new JLabel(new MyIcon(mancalas[0], 50, h));	
		JLabel m1Label = new JLabel("Mancala A");
		m1Label.setVerticalAlignment(JLabel.TOP);
		mancalaA.add(m1);
		mancalaA.add(m1Label);
		JLabel m2 = new JLabel(new MyIcon(mancalas[1], 50, h));
		JLabel m2Label = new JLabel("Mancala B");
		m2Label.setVerticalAlignment(JLabel.TOP);
		mancalaB.add(m2Label);
		mancalaB.add(m2);
		JLabel playerA = new JLabel("Player A");
		JLabel playerB = new JLabel("Player B");
		playerA.setHorizontalAlignment(SwingConstants.CENTER);
		playerB.setHorizontalAlignment(SwingConstants.CENTER);

		
		
		this.setLayout(new BorderLayout());
		this.add(mancalaA, BorderLayout.EAST);
		this.add(mancalaB, BorderLayout.WEST);
		this.add(grid, BorderLayout.CENTER);
		this.add(playerB, BorderLayout.NORTH);
		this.add(playerA, BorderLayout.SOUTH);
		
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


	@Override
	public void stateChanged(ChangeEvent e) {
		this.repaint();
		
	}
}

