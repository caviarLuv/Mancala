import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import javafx.scene.paint.Color;

public class Pit implements Part{
	private int x;
	private int y;
	private int h;
	private int k;
	private int stones;
	private String label;
	private ArrayList<ChangeListener> cl;
	
	public static final int RADIUS = 10;
	public Pit(int x, int y, int h, int k, int initialStone, String label) {
		this.x = x;
		this.y = y;
		this.h = h;
		this.k = k;
		this.stones = initialStone;
		cl = new ArrayList<ChangeListener>();
		this.label = label;
	}
	
	@Override
	public void draw(Graphics2D g2) {
		Rectangle2D.Double p = new Rectangle2D.Double(x, y, h, k);
		g2.fill(p);
		g2.setColor(java.awt.Color.yellow);
		g2.drawString(label, x+h/2, y+k);
		g2.drawString(stones + "", x+h/2, y+k/2); 
		
		int stoneY = this.y;
		int stoneX = this.x;
		for(int i = 0; i<stones; i++) {
			Ellipse2D.Double s = new Ellipse2D.Double(stoneX,stoneY,RADIUS,RADIUS);
			if(stoneX+RADIUS*2 >= h) {
				stoneY += RADIUS;
				stoneX = this.x;
			}
			else {
				stoneX += RADIUS;
			}
			g2.fill(s);
		}
		g2.draw(p);
	}

	public void addChangeListener(ChangeListener l) {
		cl.add(l);
	}
	
	public int getActualIndex() {
		return Integer.parseInt(label.substring(1))-1;
	}
	public int getStone() {
		return stones;
	}
	
	public void setStone(int s) {
		stones = s;
	}
	
	@Override
	public void addStone() {
		stones ++;
		for(int i = 0; i<cl.size(); i++) {
			cl.get(i).stateChanged(new ChangeEvent(this));
		}
	}

}
