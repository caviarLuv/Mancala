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
	private Color stoneColor;
	private Color mancalaColor;
	public Mancala(int x, int y, int w, int h, int initialS, Color stoneColor, Color mancalaColor) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		stones = initialS;
		this.stoneColor = stoneColor;
		this.mancalaColor = mancalaColor;
	}

	public void setStone(int s) {
		stones = s;
	}
	
	public void draw(Graphics2D g2) {
		Rectangle2D.Double rec = new Rectangle2D.Double(x, y, w, h);
		g2.setColor(mancalaColor);
		
		g2.fill(rec);
		
		g2.setColor(stoneColor);
		int stoneY = this.y - RADIUS + h;
		int stoneX = this.x + 5;
		for(int i = 0; i<stones; i++) {
			Ellipse2D.Double s = new Ellipse2D.Double(stoneX,stoneY,RADIUS,RADIUS);
			if(stoneX+RADIUS*2 >= w) {
				stoneY -= RADIUS;
				stoneX = this.x + 5;
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
