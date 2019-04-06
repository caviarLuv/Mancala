import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class Mancala implements Part{
	private int x;
	private int y;
	private int w;
	private int h;
	private ArrayList<Stone> stones;
	
	public Mancala(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		stones = new ArrayList<Stone> ();
	}

	public void draw(Graphics2D g2) {
		Rectangle2D.Double rec = new Rectangle2D.Double(x, y, w, h);
		g2.setColor(Color.BLUE);
		g2.fill(rec);
	}

	@Override
	public void addStone() {
		stones.add(new Stone());	
	}
}
