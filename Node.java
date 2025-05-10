import java.util.*;

public class Node 
{
    private String name;
    private ArrayList<Edge> edges;
    private float timeToSource;
    private boolean visited;

    public Node(String name)
    {
        this.name = name;
        edges = new ArrayList<Edge>();
        timeToSource = Float.MAX_VALUE;
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
        //System.out.println("Visited " + name);
        visited = true;
    }

    public float getTimeToSource()
    {
        return timeToSource;
    }

    public void setTimeToSource(float time)
    {
        if(time < timeToSource)
        {
            timeToSource = time;
        }
    }
}
