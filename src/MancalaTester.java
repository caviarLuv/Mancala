
public class MancalaTester {
	public static void main(String[] args) {
<<<<<<< HEAD

		Data model = new Data(4); 
		GameStartFrame gameStart = new GameStartFrame(model); //initial user input num of stone
=======
		
		Data model = new Data(4);  //initial user input num of stone
>>>>>>> upstream/master
		Frame frame = new Frame(model);
		model.addChangeListener(frame.getBoard());
	}
}
