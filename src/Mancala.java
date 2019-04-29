import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class Mancala implements Part{
	private int x;
	private int y;
	private int w;
	private int h;
	private int stones;
	
	public Mancala(int x, int y, int w, int h, int initialS) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		stones = initialS;
	}

	public void setStone(int s) {
		stones = s;
	}
	
	public void draw(Graphics2D g2) {
		Rectangle2D.Double rec = new Rectangle2D.Double(x, y, w, h);
		
		int stoneY = this.y;
		int stoneX = this.x;
		for(int i = 0; i<stones; i++) {
			Ellipse2D.Double s = new Ellipse2D.Double(stoneX,stoneY,RADIUS,RADIUS);
			if(stoneX+RADIUS*2 >= w) {
				stoneY += RADIUS;
				stoneX = this.x;
			}
			else {
				stoneX += RADIUS;
			}
			g2.fill(s);
		}
		g2.draw(rec);
	}

	@Override
	public void addStone() {
		stones++;
	}
}
