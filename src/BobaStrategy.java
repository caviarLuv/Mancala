import java.awt.Color;

/**
 * @author Julia Chin, Stan He, Tsz Ting Yu
 * @version 1.0 5/4/19
 */

/**
 * Boba Strategy Pattern
 */
public class BobaStrategy implements MancalaColors {
		private Color pitColor;
		private Color stoneColor;
		private Color backgroundColor;
		
		/**
		 * Constructs Strategy Pattern with Boba theme
		 */
		public BobaStrategy() {
			pitColor = new Color(247, 230, 172);
			stoneColor = Color.BLACK;
			backgroundColor = new Color(249, 215, 194);
		}
		/**
		 * Returns pit color
		 */
		@Override
		public Color getPitColor() {
			return pitColor;
		}

		/**
		 * Returns stone color
		 */
		@Override
		public Color getStoneColor() {
			return stoneColor;
		}
		
		/**
		 * Returns background color
		 */
		public Color getBackgroundColor() {
			return backgroundColor;
		}
}
