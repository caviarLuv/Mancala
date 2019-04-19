
public class MancalaTester {
	public static void main(String[] args) {
		
		GameStartFrame gameStart = new GameStartFrame();
		Data model = new Data(4);  //initial user input num of stone
		Frame frame = new Frame(model);
		model.addChangeListener(frame.getBoard());
	}
}
