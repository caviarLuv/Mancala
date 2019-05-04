
/**
 * @author Julia Chin, Stan He, Tsz Ting Yu
 * @version 1.0 5/4/19
 */

/**
 * Controller of the Mancala game
 */
public class MancalaTester {
	public static void main(String[] args) {

		Data model = new Data(0); //intial user input num of stone	
		Frame frame = new Frame(model);
		GameStartFrame gameStart = new GameStartFrame(model); //initial user input num of stone
		StyleFrame style = new StyleFrame(frame);

		model.addChangeListener(gameStart);
	}
}


