import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utilities {

    public static void printDucksToList(ArrayList<MyQueue> ducks){
        List<Integer> list = new ArrayList<>();
        ducks.forEach(myQueue -> list.addAll(myQueue.getQueue()));
        System.out.println(list);
    }

    public static void getStatistics(int n){
        //Arranging the start point of the simulations
        System.out.println("\ngetStatistics() method has been called, scroll down to find statistics over 1000 runs.");
        Map<Integer, Integer> map = new HashMap<>();
        DuckRaceSimulation simulation = new DuckRaceSimulation();

        //Iterating 1000 times and inserting data in a map
        for (int i = 0; i < 1000; i++){
        ArrayList<MyQueue> startingDucks = simulation.prepareDucks(n);
        //System.out.println("Ny race will start");
           int winnerNr = simulation.getWinnerDuck(startingDucks);
           if (map.containsKey(winnerNr)) {
               map.put(winnerNr, map.get(winnerNr) + 1);
           } else {
               map.put(winnerNr,1);
           }
        }
        //Printing results
        System.out.println("\nStatistics over for 1000 runs with Nr "+ n +" as starting number:");
        map.forEach((nr, total) -> {
            System.out.println(nr + ": " + total);
        });

    }



}
