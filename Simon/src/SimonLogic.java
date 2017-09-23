/*
 * :)
 */
public class SimonLogic {
	private RandomSimonList randomList = new RandomSimonList();
	
	public boolean checkCorrect(int checked, int position) {
		return randomList.getRandomList().get(position) == checked;
	}
}
