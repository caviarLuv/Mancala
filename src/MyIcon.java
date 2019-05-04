import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.Icon;

/**
 * @author Julia Chin, Stan He, Tsz Ting Yu
 * @version 1.0 5/4/19
 */

/**
 * Icon of a Part
 */
public class MyIcon implements Icon{
	private Part p;
	private int w;
	private int h;
	
	/**
	 * Constructs Icon of part with width and height
	 * @param p - icon part
	 * @param w - width of icon
	 * @param h - height of icon
	 */
	public MyIcon(Part p, int w, int h) {
		this.p = p;
		this.w = w;
		this.h = h;
	}

	/**
	 * Paints the icon
	 */
	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		p.draw((Graphics2D)g);
		
	}
	/**
	 * Returns icon width
	 */
	@Override
	public int getIconWidth() {
		return w;
	}

	/**
	 * Returns icon height
	 */
	@Override
	public int getIconHeight() {
		return h;
	}

	/**
	 * Returns the part
	 */
	public Part getPart() {
		return p;
	}
}
