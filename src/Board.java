import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Board extends JPanel implements ChangeListener{
	public static final int NUM_OF_PITS = 12;
	public static final int NUM_OF_MANCALAS = 2;
	private Pit[] pitsA;
	private Pit[] pitsB;
	private JLabel playerA;
	private JLabel playerB;
	private Mancala[] mancalas;
	private JPanel grid;
	private int w;
	private int h;
	private Data model;
	private MancalaColors strategy;
	public Board(Data model, MancalaColors strategy) {
		this.model = model;
		this.strategy = strategy;
		this.setBackground(strategy.getBackgroundColor());
		w = 400;
		h = 180;
		this.setBounds(10,60,w,h);
		

		int[] tmpA = model.getAData();
		int[] tmpB = model.getBData();
		
		
		pitsA = new Pit[6];
		pitsB = new Pit[6];
		mancalas = new Mancala[NUM_OF_MANCALAS];
		
		//initialize mancala
		JPanel mancalaA = new JPanel();
		mancalaA.setOpaque(false);
		JPanel mancalaB = new JPanel();
		mancalaB.setOpaque(false);
		
		JLabel mALabel = new JLabel("Mancala A");
		mancalas[1] = new Mancala(10, 40, 40, 130, tmpA[6], strategy.getStoneColor(), strategy.getPitColor());
		
		JLabel mBLabel = new JLabel("Mancala B");
		mancalas[0] = new Mancala(0, 40, 40, 130, tmpB[6], strategy.getStoneColor(), strategy.getPitColor());
		
		
		JLabel mB = new JLabel(new MyIcon(mancalas[0], 50, h));	
		JLabel mA = new JLabel(new MyIcon(mancalas[1], 50, h));

		mALabel.setHorizontalAlignment(SwingConstants.CENTER);
		mBLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mancalaA.add(mA);
		mancalaA.add(mALabel);
		mancalaB.add(mBLabel);
		mancalaB.add(mB);
		
		//initialize pits
		for(int i = 0; i<6; i++) {
			//a
			pitsA[i] = new Pit(0, 0, 45, 50, tmpA[i], "A"+(i+1), strategy.getStoneColor(), strategy.getPitColor());
			//b
			pitsB[i] = new Pit(0, 40, 45, 50, tmpB[i],"B"+(i+1), strategy.getStoneColor(), strategy.getPitColor());
		}
		
		
		//components
		
		grid = new JPanel();
		grid.setPreferredSize(new Dimension(275, 200));
		GridLayout layout = new GridLayout(2, 6, 0, 0);
		grid.setOpaque(false);
		grid.setLayout(layout);
		//b
		for(int i = pitsB.length -1 ; i>=0; i--) {	
			JLabel l = new JLabel(new MyIcon(pitsB[i],45,50));
			l.setPreferredSize(new Dimension(70, 70));
			l.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					model.select(((Pit)(((MyIcon) l.getIcon()).getPart())).getActualIndex(), false);
				}
			
			});
			grid.add(l);
		}
		
		//a
		for(int i = 0; i<pitsA.length; i++) {	
			JLabel l = new JLabel(new MyIcon(pitsA[i],45,50));
			l.setPreferredSize(new Dimension(45, 50));
			l.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					model.select(((Pit)(((MyIcon) l.getIcon()).getPart())).getActualIndex(), true);
				}		
			});
			grid.add(l);
		}
		
	
		JPanel undoPlusB = new JPanel();
		undoPlusB.setOpaque(false);
		undoPlusB.setLocation(100, 0);
		undoPlusB.setLayout(new BorderLayout());
		playerA = new JLabel("Player A");
		playerA.setForeground(Color.RED);
		playerA.setHorizontalAlignment(SwingConstants.CENTER);
		playerB = new JLabel("Player B");
		playerB.setHorizontalAlignment(SwingConstants.CENTER);
		JButton undo = new JButton("Undo");
		undo.setFont(new Font("sansserif", Font.BOLD, 14));
		undo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				model.undo();		
			}
			
		});
		JPanel center = new JPanel();
		center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
		center.add(playerB);
		center.add(grid);
		center.add(playerA);
		center.setBackground(strategy.getBackgroundColor());
		undoPlusB.add(undo, BorderLayout.WEST);
//		undoPlusB.add(playerB);
		JPanel bottom = new JPanel();
		bottom.setBackground(strategy.getBackgroundColor());
		this.setLayout(new BorderLayout());
		this.add(mancalaA, BorderLayout.EAST);
		this.add(mancalaB, BorderLayout.WEST);
		this.add(center, BorderLayout.CENTER);
		this.add(bottom, BorderLayout.SOUTH);
		this.add(undoPlusB, BorderLayout.NORTH);
		this.setOpaque(true);
		
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
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
		if(model.getIsPLayerA()) {
			playerA.setForeground(Color.RED);
			playerB.setForeground(Color.BLACK);
			
		}
		else {
			playerB.setForeground(Color.RED);
			playerA.setForeground(Color.BLACK);
		}
		mancalas[1].setStone(tmpA[6]);
		mancalas[0].setStone(tmpB[6]);
		repaint();	
	}

}