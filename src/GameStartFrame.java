import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
public class GameStartFrame extends JFrame{
	private Data d;
	private int initialStones;
	public GameStartFrame(Data d) {
		this.d = d;
		final Container contentPane = this.getContentPane();
		initialStones = 0;
		
		JButton three = new JButton("3 stones");
		three.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				initialStones = 3;
				
			}
			
		});
		JButton four = new JButton("4 stones");
		four.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				initialStones = 4;
				
			}
			
		});

		JPanel stones = new JPanel();
		stones.setLayout(new BoxLayout(stones, BoxLayout.X_AXIS));
		stones.add(three);
		stones.add(four);
		
		JPanel instruction = new JPanel();
		JTextArea prompt = new JTextArea("Choose the # of stones per pit");
		prompt.setOpaque(false);
		prompt.setEditable(false);
		instruction.add(prompt);
		instruction.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		this.setVisible(true);
		this.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		this.add(instruction);
		this.add(stones);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public int getInitialStone() {
		return initialStones;
	}
}
