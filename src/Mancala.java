import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class Mancala implements Part{
	private int x;
	private int y;
	private int w;
	private int h;
	private int stones;
	
	public Mancala(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		stones = 0;
	}

	public void draw(Graphics2D g2) {
		Rectangle2D.Double rec = new Rectangle2D.Double(x, y, w, h);
		g2.drawString(stones + "", x+w/2, y+h/2);
		g2.draw(rec);
	}

	@Override
	public void addStone() {
		stones++;
	}
}
