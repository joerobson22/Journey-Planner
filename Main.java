import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        String start, end;
        Scanner scanner = new Scanner(System.in);

        RoutePlanner routePlanner = new RoutePlanner("Data.csv");

        //routePlanner.output();

        System.out.println("Welcome to Journey Planner!");

        System.out.printf("\nEnter start station: ");
        start = scanner.nextLine();

        System.out.printf("\nEnter end station: ");
        end = scanner.nextLine();

        System.out.println("\n\nJourney from " + start + " to " + end + "...");
        Route route = routePlanner.calculateRoute(start, end);

        System.out.println("Total route time: " + route.getRouteTime());
        System.out.println("Total changes: " + route.getNumChanges());
        System.out.println("Total number of stops: " + route.getNumStops());
        route.output();
    }
}