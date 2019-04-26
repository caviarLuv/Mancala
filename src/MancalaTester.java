public class MancalaTester {
	public static void main(String[] args) {

		Data model = new Data(4); //intial user input num of stone
		GameStartFrame gameStart = new GameStartFrame(model); //initial user input num of stone
		StyleFrame style = new StyleFrame(model);
		Frame frame = new Frame(model);
		model.addChangeListener(frame.getBoard());
	}
}
