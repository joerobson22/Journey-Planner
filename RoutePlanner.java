
import java.util.*;

public class RoutePlanner 
{

    private ArrayList<Edge> edges;
    private ArrayList<Node> nodes;

    public RoutePlanner(String filename) 
    {
        RouteData data = RouteFileReader.readFile(filename);
        nodes = data.getNodes();
        edges = data.getEdges();
    }

    public void output()
    {
        for(Node n : nodes)
        {
            n.outputNode();
        }
    }

    public Route calculateRoute(String start, String end)
    {
        Route route = new Route();
        

        return route;
    }
}
