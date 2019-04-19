
public class MancalaTester {
	public static void main(String[] args) {

		Data model = new Data(4); 
		GameStartFrame gameStart = new GameStartFrame(model); //initial user input num of stone
		Frame frame = new Frame(model);
		model.addChangeListener(frame.getBoard());
	}
}
