import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * @author Julia Chin, Stan He, Tsz Ting Yu
 * @version 1.0 5/4/19
 */

/**
 * A pit in the Mancala
 */
public class Pit implements Part{
	private int x;
	private int y;
	private int h;
	private int k;
	private int stones;
	private String label;
	private ArrayList<ChangeListener> cl;
	private Color stoneColor;
	private Color pitColor;
	
	/**
	 * Constructs a pit with the size, number of stones, label, stone color, and pit color
	 * @param x - x-position of the pit
	 * @param y - y -position of the pit
	 * @param h - height of the pit
	 * @param k - width of the pit
	 * @param initialStone - stones in the pit
	 * @param label - label of index of the pit
	 * @param color - color of the stones in the pit
	 * @param color2 - color of the pit
	 */
	public Pit(int x, int y, int h, int k, int initialStone, String label, Color color, Color color2) {
		this.x = x;
		this.y = y;
		this.h = h;
		this.k = k;
		this.stones = initialStone;
		cl = new ArrayList<ChangeListener>();
		this.label = label;
		this.stoneColor = color;
		this.pitColor = color2;
	}
	
	/**
	 * Draws the pit and the stones in the pit
	 */
	@Override
	public void draw(Graphics2D g2) {
		Rectangle2D.Double p = new Rectangle2D.Double(x, y, h, k);
		g2.setColor(pitColor);
		g2.fill(p);
		
		g2.setColor(Color.BLACK);
		g2.drawString(label, x+h/2, y+10);
		
		g2.setColor(stoneColor);
		int stoneY = this.y + k - RADIUS;
		int stoneX = this.x + 4;
		for(int i = 0; i<stones; i++) {
			Ellipse2D.Double s = new Ellipse2D.Double(stoneX,stoneY,RADIUS,RADIUS);
			if(stoneX+RADIUS*2 >= h) {
				stoneY -= RADIUS;
				stoneX = this.x + 4;
			}
			else {
				stoneX += RADIUS;
			}
			g2.fill(s);
		}
		g2.draw(p);
	}

	/**
	 * Adds a ChangeListener to the pit
	 */
	public void addChangeListener(ChangeListener l) {
		cl.add(l);
	}
	
	/**
	 * Returns index of the pit
	 */
	public int getActualIndex() {
		return Integer.parseInt(label.substring(1))-1;
	}
	
	/**
	 * Returns the number of stones in the pit
	 */
	public int getStone() {
		return stones;
	}
	
	/**
	 * Sets the number of stones in the pit
	 */
	public void setStone(int s) {
		stones = s;
	}
	
	/**
	 * Adds stones to the pit
	 */
	@Override
	public void addStone() {
		stones ++;
		for(int i = 0; i<cl.size(); i++) {
			cl.get(i).stateChanged(new ChangeEvent(this));
		}
	}

}
