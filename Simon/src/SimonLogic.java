import java.util.ArrayList;

/*
 * :)
 */
public class SimonLogic {
	
	private RandomSimonList randomList = new RandomSimonList();
	
	public ArrayList<Integer> getList() {
		return randomList.getRandomList();
	}
	
	public void nextTurn() {
		randomList.getNextNumber();
	}
	
	public boolean checkCorrect(int checked, int position) {
		return randomList.getRandomList().get(position) == checked;
	}
}
