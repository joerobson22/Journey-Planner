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

    public Route calculateRoute(String source, String target)
    {
        Route route = new Route();
        float time = 0;

        //first find the starting node using the start parameter
        Node sourceNode = findNode(source);
        sourceNode.setTimeToSource(0);

        //then calculate all the time taken to get to every other node from the source
        setTimesToSource(sourceNode);
        
        //locate the target node
        Node targetNode = findNode(target);
        System.out.println("The shortest route to " + targetNode.getName() + " is " + targetNode.getTimeToSource() + " minutes");

        //recursively go down every path
        

        return route;
    }

    public void setTimesToSource(Node sourceNode)
    {
        Node currentNode = sourceNode;
        //goal of this part:
        //set the time to the start node for each node
        //then we will find the target node and find the path to it

        //visit every node from the current node
        while(!allNodesVisited())
        {
            //set this node to visited
            currentNode.visit();
            //visit all their connected nodes
            for(Edge e : currentNode.getEdges())
            {
                //update every node's distance to the source (if smaller)
                e.getEndNode().setTimeToSource(e.getTime() + currentNode.getTimeToSource());
            }
            currentNode = getNextClosestNode(nodes);
        }
    }

    public Node findNode(String name)
    {
        for(Node n : nodes)
        {
            if(n.getName().equals(name))
            {
                return n;
            }
        }
        return null;
    }

    
    public boolean allNodesVisited()
    {
        for(Node n : nodes)
        {
            if(!n.getVisited())
            {
                return false;
            }
        }
        return true;
    }

    public Node getNextClosestNode(ArrayList<Node> nodes)
    {
        float smallest = Float.MAX_VALUE;
        Node returnNode = null;
        for(Node n : nodes)
        {
            if(n.getTimeToSource() <= smallest && !n.getVisited())
            {
                smallest = n.getTimeToSource();
                returnNode = n;
            }
        }
        return returnNode;
    }
}
