import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
public class GameStartFrame extends JFrame{
	private Data d;
	
	public GameStartFrame() {
		final Container contentPane = this.getContentPane();
		this.setTitle("Option");
		
		
		JButton three = new JButton("3 stones");
		three.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		JButton four = new JButton("4 stones");
		four.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		this.setVisible(true);
		this.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
		this.add(three);
		this.add(four);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
