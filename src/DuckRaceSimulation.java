import java.util.ArrayList;
import java.util.Random;

public class DuckRaceSimulation {

    private int startingNr;
    private ArrayList<MyQueue> startingDucks;

    public void run(int n){
        startingNr = n;
        startingDucks = prepareDucks(n);
        System.out.println("This the list of the competing ducks:");
        Utilities.printDucksToList(startingDucks);
        System.out.println("The race has started...");
        int winner = getWinnerDuck(startingDucks);
        System.out.println("And the winner is...\nnumber " + winner + " ! ! !");
    }

    public ArrayList<MyQueue> prepareDucks(int n) {
        int count = 1;
        ArrayList<MyQueue> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            var queue = new MyQueue();
            for (int j = 1; j <= n; j++) {
                queue.addElement(count);
                count++;
            }
            list.add(queue);
        }
        return list;
    }

    public ArrayList<MyQueue> getEmptyQs(int n){
        ArrayList<MyQueue> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            var queue = new MyQueue();
            list.add(queue);
        }
        return list;
    }

    public int getWinnerDuck(ArrayList<MyQueue> initialDucks) {

        int nextNr = initialDucks.size() - 1;
        ArrayList<MyQueue> remainingDucks = getEmptyQs(nextNr);
        int remainingSpaceCount = nextNr*nextNr;
//System.out.println("New time/step, ducks/size is: " + initialDucks.size());
        // while there is room for more ducks fill spaces for remaining ducks...
        while (remainingSpaceCount >= 1) {

            //gets and removes a random duck from the startingDucks
            int pickedDuck = -1;
            while (pickedDuck < 0) {
                int randomQueueIndex = new Random().nextInt(nextNr);
                if (!initialDucks.get(randomQueueIndex).isEmpty()) {
                    pickedDuck = initialDucks.get(randomQueueIndex).removeAndGetFrontElement();
                }
            }

            //put it in a random queue if there's room in that queue else repeat until it finds a spot using a Boolean Flag
            boolean isSpaceFound = false;
            while (!isSpaceFound) {
                int randomQueueIndex = new Random().nextInt(nextNr);
                if (!remainingDucks.get(randomQueueIndex).isFull(nextNr)) {
                    remainingDucks.get(randomQueueIndex).addElement(pickedDuck);
                    remainingSpaceCount--;
                    isSpaceFound = true;
                }
            }
        }
        if (remainingDucks.size() == 1) {
            Utilities.printDucksToList(remainingDucks);
            return remainingDucks.get(0).removeAndGetFrontElement();
        }
        else {
            Utilities.printDucksToList(remainingDucks);
            return getWinnerDuck(remainingDucks);
        }
    }

}
