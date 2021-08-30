public class Main {

    public static void main(String[] args) {

        new DuckRaceSimulation().run(10);

        System.out.println("\n\n\n");

        Utilities.getStatistics(5);

        /*
        DuckRaceSimulation simulation = new DuckRaceSimulation();
        simulation.run(3);
        simulation.run(4);
        */
    }

}

