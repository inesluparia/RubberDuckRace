import java.util.ArrayList;
import java.util.Random;

public class DuckRaceSimulation {

    public static ArrayList<MyQueue> getStartingDucks(int n) {
        int count = 1;
        ArrayList<MyQueue> list = new ArrayList<MyQueue>();
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
        ArrayList<MyQueue> list = new ArrayList<MyQueue>();
        for (int i = 1; i <= n; i++) {
            var queue = new MyQueue();
            list.add(queue);
        }
        return list;
    }

    public int getWinnerDuck(ArrayList<MyQueue> startingDucks) {

        int n = startingDucks.size() - 1;
        ArrayList<MyQueue> remainingDucks = getEmptyQs(n);
        int remainingSpaceCount = n*n;

        // while there is room for more ducks fill spaces for remaining ducks
        while (remainingSpaceCount >= 1) {

            //gets and removes a random duck from the startingDucks
            int pickedDuck = -1;
            while (pickedDuck < 0) {
                int randomQueueIndex = new Random().nextInt(n);
                if (!startingDucks.get(randomQueueIndex).isEmpty())
                    pickedDuck = startingDucks.get(randomQueueIndex).removeAndGetFrontElement();
                //printDucksToList(startingDucks);
            }

            //put it in a random queue if there's room in that queue
            // else repeat until it finds a spot using a flag
            boolean isSpaceFound = false;
            while (!isSpaceFound) {
                int randomQueueIndex = new Random().nextInt(n);
                if (!remainingDucks.get(randomQueueIndex).isFull(n)) {
                    remainingDucks.get(randomQueueIndex).addElement(pickedDuck);
                    remainingSpaceCount--;
                    isSpaceFound = true;
                }
            }
        }
        if (remainingDucks.size() == 1)
            return remainingDucks.get(0).removeAndGetFrontElement();
        else {
            Utilities.printDucksToList(remainingDucks);
            return getWinnerDuck(remainingDucks);
        }
    }

}
