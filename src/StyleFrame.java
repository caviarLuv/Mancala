import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class StyleFrame extends JFrame{
	
	private Frame f;
	
	public StyleFrame(Frame f){
		this.f = f;
		final Container contentPane = this.getContentPane();
		JFrame tmpF = this;
		JButton StyleA = new JButton("Default");
		StyleA.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f.initialGame(new DefaultStrategy());
				tmpF.setVisible(false);
			}		
		});
		JButton StyleB = new JButton("Maltesers");
		StyleB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f.initialGame(new MalteserStrategy());
				tmpF.setVisible(false);
			}		
		});
		
		JButton StyleC = new JButton("Boba");
		StyleC.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f.initialGame(new BobaStrategy());
				tmpF.setVisible(false);
			}		
		});
		JPanel instruction = new JPanel();
		JTextArea prompt = new JTextArea("Select a game theme");
		prompt.setEditable(false);
		prompt.setOpaque(false);
		instruction.add(prompt);
		instruction.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JPanel styles = new JPanel();
		styles.setLayout(new BoxLayout(styles, BoxLayout.X_AXIS));
		styles.add(StyleA);
		styles.add(StyleB);
		styles.add(StyleC);
		
		this.setVisible(true);
		this.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		this.add(instruction);
		this.add(styles);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	static class DefaultStrategy implements MancalaColors{
		private Color pitColor;
		private Color stoneColor;
		private Color backgroundColor;
		public DefaultStrategy() {
			pitColor = Color.WHITE;
			stoneColor = Color.BLACK;
			backgroundColor = Color.WHITE;
		}
		@Override
		public Color getPitColor() {
			return pitColor;
		}

		@Override
		public Color getStoneColor() {
			return stoneColor;
		}
		
		public Color getBackgroundColor() {
			return backgroundColor;
		}
		
	}
	
	static class BobaStrategy implements MancalaColors {
		private Color pitColor;
		private Color stoneColor;
		private Color backgroundColor;
		public BobaStrategy() {
			pitColor = new Color(247, 230, 172);
			stoneColor = Color.BLACK;
			backgroundColor = new Color(249, 215, 194);
		}
		@Override
		public Color getPitColor() {
			return pitColor;
		}

		@Override
		public Color getStoneColor() {
			return stoneColor;
		}
		public Color getBackgroundColor() {
			return backgroundColor;
		}
	}
	
	static class MalteserStrategy implements MancalaColors{
		private Color pitColor;
		private Color stoneColor;
		private Color backgroundColor;
		public MalteserStrategy() {
			pitColor = new Color(239,72,31);
			stoneColor = new Color(253,243,219);
			backgroundColor = new Color(255,241,192);
		}
		
		@Override
		public Color getPitColor() {
			return pitColor;
		}

		@Override
		public Color getStoneColor() {
			return stoneColor;
		}
		
		public Color getBackgroundColor() {
			return backgroundColor;
		}

	}

}
