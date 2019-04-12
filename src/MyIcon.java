import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.Icon;

public class MyIcon implements Icon{
	private Part p;
	private int w;
	private int h;
	
	public MyIcon(Part p, int w, int h) {
		this.p = p;
		this.w = w;
		this.h = h;
	}

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		p.draw((Graphics2D)g);
		
	}

	@Override
	public int getIconWidth() {
		return w;
	}

	@Override
	public int getIconHeight() {
		return h;
	}

	public Part getPart() {
		return p;
	}
}
