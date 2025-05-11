import java.util.*;

public class Node 
{
    private String name;
    private ArrayList<Edge> edges;
    private double timeToSource;
    private boolean visited;
    private Edge previousEdge;

    public Node(String name)
    {
        this.name = name;
        edges = new ArrayList<Edge>();
        timeToSource = Double.MAX_VALUE;
        visited = false;
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

    public ArrayList<Edge> getEdges()
    {
        return edges;
    }

    
    public boolean getVisited()
    {
        return visited;
    }

    public void visit()
    {
        visited = true;
    }

    public double getTimeToSource()
    {
        return timeToSource;
    }

    public Edge getPreviousEdge()
    {
        return previousEdge;
    }

    public void setTimeToSource(double time, Edge e)
    {
        if(time < timeToSource)
        {
            timeToSource = time;
            previousEdge = e;
        }
    }
}
