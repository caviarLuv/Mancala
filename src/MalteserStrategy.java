import java.awt.Color;

/**
 * @author Julia Chin, Stan He, Tsz Ting Yu
 * @version 1.0 5/4/19
 */

/**
 * Malteser Strategy Pattern
 */
public class MalteserStrategy implements MancalaColors{
		private Color pitColor;
		private Color stoneColor;
		private Color backgroundColor;
		
		/**
		 * Constructs Strategy Pattern with Malteser theme
		 */
		public MalteserStrategy() {
			pitColor = new Color(239,72,31);
			stoneColor = new Color(253,243,219);
			backgroundColor = new Color(255,241,192);
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