import java.awt.Graphics2D;

/**
 * @author Julia Chin, Stan He, Tsz Ting Yu
 * @version 1.0 5/4/19
 */

/**
 * Interface representing a part
 */
public interface Part {
	public final int RADIUS = 10;
	public void draw(Graphics2D g2);
	public void addStone();
}
