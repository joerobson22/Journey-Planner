import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        String start, end;
        Scanner scanner = new Scanner(System.in);

        RoutePlanner routePlanner = new RoutePlanner("Data.csv");

        System.out.println("Welcome to Journey Planner!");

        System.out.printf("\nEnter start station: ");
        start = scanner.nextLine();

        System.out.printf("\nEnter end station: ");
        end = scanner.nextLine();

        Route route = routePlanner.calculateRoute(start, end);
        System.out.println("\n\nJourney from " + start + " to " + end + "...");
        route.outputRoute();
    }
}