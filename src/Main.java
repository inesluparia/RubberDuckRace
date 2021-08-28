import javax.lang.model.type.ArrayType;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        ArrayList<MyQueue> startingDucks = DuckRaceSimulation.getStartingDucks(3);
        Utilities.printDucksToList(startingDucks);
        System.out.println(new DuckRaceSimulation().getWinnerDuck(startingDucks));

        System.out.println("\n test statistics:\n");
        //getMap(4).get(4).queue.stream()
        /*
        Utilities.getStartingDucks(4).stream()
                .flatMap(Collection::stream)
                .forEach(System.out::println);
        */

       // Utilities.printDucksToList(DuckRaceSimulation.getStartingDucks(4));

        Utilities.getStatistics(4);
    }

}

