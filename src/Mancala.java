import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 * @author Julia Chin, Stan He, Tsz Ting Yu
 * @version 1.0 5/4/19
 */

/**
 * A representation of a Mancala
 */
public class Mancala implements Part{
	private int x;
	private int y;
	private int w;
	private int h;
	private int stones;
	private Color stoneColor;
	private Color mancalaColor;
	
	/**
	 * Constructs a Mancala with the size of the Mancala, number of stones, stone color, and Mancala color
	 * @param x - x-position of the Mancala
	 * @param y - y -position of the Mancala
	 * @param w - width of the Mancala
	 * @param h - height of the Mancala
	 * @param initialS - stones in the Mancala
	 * @param stoneColor - color of the stones
	 * @param mancalaColor - color of the Mancala
	 */
	public Mancala(int x, int y, int w, int h, int initialS, Color stoneColor, Color mancalaColor) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		stones = initialS;
		this.stoneColor = stoneColor;
		this.mancalaColor = mancalaColor;
	}
	
	/**
	 * Sets the number of stones
	 */
	public void setStone(int s) {
		stones = s;
	}
	
	/**
	 * Draws the Mancala
	 * @param g2 - the graphics
	 */
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

	/**
	 * Adds stones to the Mancala
	 */
	@Override
	public void addStone() {
		stones++;
	}
}
