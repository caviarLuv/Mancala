import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Pit implements Part{
	private int x;
	private int y;
	private int h;
	private int k;
	private int stones;
	public Pit(int x, int y, int h, int k, int initialStone) {
		this.x = x;
		this.y = y;
		this.h = h;
		this.k = k;
		this.stones = initialStone;
	}
	
	@Override
	public void draw(Graphics2D g2) {
		Rectangle2D.Double p = new Rectangle2D.Double(x, y, h, k);
		g2.drawString(stones + "", x+h/2, y+k/2);
		g2.draw(p);
	}

	public int getStone() {
		return stones;
	}
	@Override
	public void addStone() {
		stones ++;		
	}

}
