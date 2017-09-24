import java.util.ArrayList;
import java.util.Random;

public class RandomSimonList {
	
	private Random randomGen;
	private ArrayList<Integer> randomList;
	
	public RandomSimonList() {
		randomGen = new Random();
		randomList = new ArrayList<Integer>();
	}
	
	public int getNextNumber() {
		int nextNum = randomGen.nextInt(4);
		randomList.add(nextNum);
		return nextNum;
	}
	
	public ArrayList<Integer> getRandomList() {
		return randomList;
	}

}
