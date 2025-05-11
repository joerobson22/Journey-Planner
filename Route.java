import java.util.*;

public class Route
{
    private ArrayList<Edge> fullRoute;
    private ArrayList<Edge> simpleRoute;
    private double totalTime;

    /*
     * constructor for the route
     */
    public Route()
    {
        fullRoute = new ArrayList<Edge>();
        simpleRoute = new ArrayList<Edge>();
        totalTime = 0;
    }

    /*
     * returns the long route
     */
    public ArrayList<Edge> getFullRoute()
    {
        return fullRoute;
    }

    /*
     * returns the simplified route
     */
    public ArrayList<Edge> getSimpleRoute()
    {
        return simpleRoute;
    }

    /*
     * stimulates the route to reverse the full route and then generate a simplified version
     */
    public void finished()
    {
        fullRoute = reverseRoute(fullRoute);
        simpleRoute = createSimpleRoute(fullRoute);
    }

    /*
     * revsersed the given route and returns it, as reversed
     */
    public ArrayList<Edge> reverseRoute(ArrayList<Edge> route)
    {
        ArrayList<Edge> reversed = new ArrayList<Edge>();

        for(int i = route.size() - 1; i > -1; i--)
        {
            reversed.add(route.get(i));
        }

        return reversed;
    }

    /*
     * creates a simplifie version of a given route by creating a new edge every time the next edge's colour is different to the current colour
     * then modifying the endnode and total time per edge
     */
    public ArrayList<Edge> createSimpleRoute(ArrayList<Edge> r)
    {
        ArrayList<Edge> simple = new ArrayList<Edge>();
        int changes = -1;
        String currentColor = null;

        for(Edge e : r)
        {
            //if the line is of the same color, add the next edge's travel time onto it, and change the simple edge's end node to this edge's end node
            if(e.getLineColour().equals(currentColor))
            {
                Edge f = simple.get(changes);
                simple.get(changes).setTime(f.getTime() + e.getTime());
                simple.get(changes).setEndNode(e.getEndNode());
            }
            //otherwise, create a new edge with the current edge's color, time, start node and end node
            else
            {
                changes++;
                currentColor = e.getLineColour();
                Edge f = new Edge(currentColor, e.getTime(), e.getStartNode(), e.getEndNode());
                simple.add(f);
            }
        }
        return simple;
    }

    /*
     * adds and edge to the full route
     */
    public void addEdge(Edge e)
    {
        fullRoute.add(e);
        totalTime += e.getTime();
    }

    /*
     * returns how many changes (how many different lines the simple route uses)
     */
    public int getNumChanges()
    {
        return simpleRoute.size();
    }

    /*
     * returns how many stations the full route passes through
     */
    public int getNumStops()
    {
        return fullRoute.size();
    }

    /*
     * returns the route's total time
     */
    public double getRouteTime()
    {
        return totalTime;
    }

    /*
     * outputs the full route and the simplified route
     */
    public void output()
    {
        System.out.println();
        System.out.println("FULL ROUTE:");
        System.out.println();
        for(Edge e : fullRoute)
        {
            e.outputEdge();
        }

        System.out.println();
        System.out.println("SIMPLE ROUTE:");
        System.out.println();
        for(Edge e : simpleRoute)
        {
            e.outputEdge();
        }
    }
}
