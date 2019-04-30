import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


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
	
	@Override
	public void draw(Graphics2D g2) {
		Rectangle2D.Double p = new Rectangle2D.Double(x, y, h, k);
		g2.setColor(pitColor);
		g2.fill(p);
		
		g2.setColor(Color.BLACK);
		g2.drawString(label, x+h/2, y+10);
		//g2.drawString(stones + "", x+h/2, y+k/2); 
		
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
