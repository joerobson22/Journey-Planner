import java.util.*;

public class Edge 
{
    private String lineColour;
    private double time;
    private Node startNode;
    private Node endNode;

    public Edge(String lineColour, double time, Node startNode, Node endNode)
    {
        this.lineColour = lineColour;
        this.time = Round.round(time, 1);
        this.startNode = startNode;
        this.endNode = endNode;
    }

    public double getTime()
    {
        return time;
    }

    public void setTime(double t)
    {
        time = t;
    }

    public void setEndNode(Node n)
    {
        endNode = n;
    }

    public String getLineColour()
    {
        return lineColour;
    }

    public Node getStartNode()
    {
        return startNode;
    }

    public Node getEndNode()
    {
        return endNode;
    }

    public void outputEdge()
    {
        System.out.println(startNode.getName() + " to " + endNode.getName() + " on the " +  lineColour + " line- " + time + " mins");
    }
}
