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
	private Pit[] pitsA;
	private Pit[] pitsB;
	
	private Mancala[] mancalas;
	private JPanel grid;
	private int w;
	private int h;
	private Data model;
	
	public Board(Dimension d, Data model) {
		this.model = model;
		w = 380;
		h = 180;
		this.setBounds(10,60,w,h);
		

		int[] tmpA = model.getAData();
		int[] tmpB = model.getBData();
		
		
		pitsA = new Pit[6];
		pitsB = new Pit[6];
		mancalas = new Mancala[NUM_OF_MANCALAS];
		
		//initialize mancala
		JPanel mancalaA = new JPanel();
		JPanel mancalaB = new JPanel();
		
		
		JLabel mALabel = new JLabel("Mancala A");
		mancalas[1] = new Mancala(0, 25, 40, 130, tmpA[6]);
		
		JLabel mBLabel = new JLabel("Mancala B");
		mancalas[0] = new Mancala(0, 25, 40, 130, tmpB[6]);
		
		
		JLabel mB = new JLabel(new MyIcon(mancalas[0], 50, h));	
		JLabel mA = new JLabel(new MyIcon(mancalas[1], 50, h));

		
		mancalaA.add(mA);
		mancalaA.add(mALabel);
		mancalaB.add(mBLabel);
		mancalaB.add(mB);
		
		//initialize pits
		for(int i = 0; i<6; i++) {
			//a
			pitsA[i] = new Pit(0, 40, 45, 50, tmpA[i], "A"+(i+1));
		
			//b
			pitsB[i] = new Pit(0, 0, 45, 50, tmpB[i],"B"+(i+1));
		}
		
		
		//components
		grid = new JPanel();
		grid.setPreferredSize(new Dimension(270, 100));
		GridLayout layout = new GridLayout(2, 6, 0, 0);
		grid.setLayout(layout);
		//a
		for(int i = 0; i<pitsA.length; i++) {	
			JButton b = new JButton(new MyIcon(pitsA[i],45,50));
			b.setPreferredSize(new Dimension(45, 50));
			b.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					model.select(((Pit)(((MyIcon) b.getIcon()).getPart())).getActualIndex());
					//((Pit)(((MyIcon) b.getIcon()).getPart())).getLabelNum();		
				}
			
			});
			grid.add(b);
		}
		
		//b
		for(int i = 0; i<pitsB.length; i++) {	
			JButton b = new JButton(new MyIcon(pitsB[i],45,50));
			b.setPreferredSize(new Dimension(45, 50));
			b.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
					model.select(((Pit)(((MyIcon) b.getIcon()).getPart())).getActualIndex());
					
					//((MyIcon)b.getIcon()).getPart().addStone();		
				}
			
			});
			grid.add(b);
		}
		

		
		
		JLabel playerA = new JLabel("Player A");
		JLabel playerB = new JLabel("Player B");
		playerA.setHorizontalAlignment(SwingConstants.CENTER);
		playerB.setHorizontalAlignment(SwingConstants.CENTER);
		
		this.setLayout(new BorderLayout());
		this.add(mancalaB, BorderLayout.WEST);
		this.add(mancalaA, BorderLayout.EAST);
		this.add(grid, BorderLayout.CENTER);
		this.add(playerA, BorderLayout.NORTH);
		this.add(playerB, BorderLayout.SOUTH);
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
		int[] tmpA = model.getAData();
		int[] tmpB = model.getBData();
		
		for(int i = 0; i<6; i++) {
			//a
			pitsA[i].setStone(tmpA[i]);
			//b
			pitsB[i].setStone(tmpB[i]);
		}
		mancalas[1].setStone(tmpA[6]);
		mancalas[0].setStone(tmpB[6]);
		repaint();	
	}
}

