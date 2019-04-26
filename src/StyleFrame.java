import java.awt.Component;
import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class StyleFrame extends JFrame{
	
	private Data d;
	
	public StyleFrame(Data d){
		this.d = d;
		final Container contentPane = this.getContentPane();
	
		JButton StyleA = new JButton("Style A");
		JButton StyleB = new JButton("Style B");
	
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
		
		this.setVisible(true);
		this.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		this.add(instruction);
		this.add(styles);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
//		if(StyleA.getModel().isPressed() || StyleB.getModel().isPressed()){
//			if(StyleA.getModel().isPressed()){
//				
//			}
//			if(StyleA.getModel().isPressed()){
//							
//			}
//			this.addWindowListener(new WindowAdapter(){
//				public void windowClosing(WindowEvent e){
//					
//					
//				}
//			});
//		}
	}
	
	

}
