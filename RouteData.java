import java.util.*;

public class RouteData 
{
    private ArrayList<Node> nodes;
    private ArrayList<Edge> edges;

    public RouteData(ArrayList<Node> nodes, ArrayList<Edge> edges)
    {
        this.nodes = nodes;
        this.edges = edges;
    }

    public ArrayList<Node> getNodes()
    {
        return nodes;
    }

    public ArrayList<Edge> getEdges()
    {
        return edges;
    }
}
