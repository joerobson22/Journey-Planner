import java.util.*;

public class Node 
{
    private String name;
    private ArrayList<Edge> edges;

    public Node(String name)
    {
        this.name = name;
        edges = new ArrayList<Edge>();
    }

    public String getName()
    {
        return name;
    }

    public void addEdge(Edge e)
    {
        edges.add(e);
    }

    public void outputNode()
    {
        System.out.println("Node: " + name);
        for(Edge e : edges)
        {
            e.outputEdge();
        }
        System.out.println();
    }
}
