import java.util.*;

public class Route
{
    private ArrayList<Edge> route;

    public Route()
    {
        route = new ArrayList<Edge>();
    }

    public ArrayList<Edge> getRoute()
    {
        return route;
    }

    public int getNumChanges()
    {
        return route.size();
    }

    public void outputRoute()
    {
        for(Edge e : route)
        {
            e.outputEdge();
        }
    }
}
