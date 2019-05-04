import java.awt.Color;

/**
 * @author Julia Chin, Stan He, Tsz Ting Yu
 * @version 1.0 5/4/19
 */

/**
 * Default Strategy Pattern
 */
public class DefaultStrategy implements MancalaColors{
		private Color pitColor;
		private Color stoneColor;
		private Color backgroundColor;
		
		/**
		 * Constructs Strategy Pattern with Default theme
		 */
		public DefaultStrategy() {
			pitColor = Color.WHITE;
			stoneColor = Color.BLACK;
			backgroundColor = Color.WHITE;
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
