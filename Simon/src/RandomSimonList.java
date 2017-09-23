import java.util.ArrayList;
import java.util.Random;

public class RandomSimonList {
	//Instantiate the Random class and ArrayList
    private Random randomGen;
    private ArrayList<Integer> randomList;
    
    //Constructor. Set randomGen to new Random and the same for ArrayList
    public RandomSimonList() {
        randomGen = new Random();
        randomList = new ArrayList<Integer>();
    }
    
    //Get the next random number for the order
    public int getNextNumber() {
        int nextNum = randomGen.nextInt(4) + 1;
        randomList.add(nextNum);
        return nextNum;
    }
    
    //Return the current order
    public ArrayList<Integer> getRandomList() {
        return randomList;
    }
}
