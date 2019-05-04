import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * @author Julia Chin, Stan He, Tsz Ting Yu
 * @version 1.0 5/4/19
 */

/**
 * Frame to prompt user to select a game theme
 */
public class StyleFrame extends JFrame{
	
	private Frame f;
	
	/**
	 * Constructs frame with a option to select the game theme
	 * @param f - frame of Mancala game
	 */
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

}
