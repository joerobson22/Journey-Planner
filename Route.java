import java.util.*;

public class Route
{
    private Stack<Edge> route;
    private Queue<Edge> finalRoute;

    public Route()
    {
        route = new Stack<Edge>();
        finalRoute = new LinkedList<Edge>();
    }

    public Stack<Edge> getRoute()
    {
        return route;
    }

    public void pushEdge(Edge e)
    {
        route.push(e);
    }

    public Edge popEdge()
    {
        return route.pop();
    }

    public int getNumChanges()
    {
        return route.size();
    }

    public float getRouteLength()
    {
        float total = 0;
        for(Edge e : route)
        {
            total += e.getTime();
        }
        return total;
    }

    public void outputRoute()
    {
        //reverse the order of the stack
        for(Edge e : route)
        {
            finalRoute.add(e);
        }

        for(Edge e : finalRoute)
        {
            e.outputEdge();
        }
    }
}
