import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utilities {

    public static void printDucksToList(ArrayList<MyQueue> ducks){
        List<Integer> list = new ArrayList<>();
        ducks.forEach(myQueue -> list.addAll(myQueue.queue));
        System.out.println(list);
    }

    public static void getStatistics(int n){
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<MyQueue> startingDuckies = DuckRaceSimulation.getStartingDucks(n);
        DuckRaceSimulation simulation = new DuckRaceSimulation();
        for (int i = 0; i < 1000; i++){
           int winnerNr = simulation.getWinnerDuck(startingDuckies);
           if (map.containsKey(winnerNr)) {
               map.put(winnerNr, map.get(winnerNr) + 1);
           } else {
               map.put(winnerNr,1);
           }
        }
        map.forEach((nr, total) -> {
            System.out.println(nr + ": " + total);
        });

    }



}
