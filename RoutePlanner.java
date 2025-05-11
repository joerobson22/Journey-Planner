import java.util.*;

public class RoutePlanner 
{
    private ArrayList<Edge> edges;
    private ArrayList<Node> nodes;

    /*
     * constructor for route planner
     */
    public RoutePlanner(String filename) 
    {
        RouteData data = RouteFileReader.readFile(filename);
        nodes = data.getNodes();
        edges = data.getEdges();
    }

    /*
     * outputs all nodes and edges
     */
    public void output()
    {
        for(Node n : nodes)
        {
            n.outputNode();
        }
    }

    /*
     * generates a route from the source to the target
     */
    public Route calculateRoute(String source, String target)
    {
        //first find the starting node using the start parameter
        Node sourceNode = findNode(source);
        sourceNode.setTimeToSource(0, null);

        //then calculate all the time taken to get to every other node from the source
        setTimesToSource(sourceNode);

        return createRoute(source, target);
    }

    /*
     * given a source node, uses Dijkstra's algorithm to set every node's shortest time to the source node
     */
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

            //continue if this current node is unreachable
            if(currentNode.getTimeToSource() != Float.MAX_VALUE)
            {
                //visit all their connected nodes
                for(Edge e : currentNode.getEdges())
                {
                    Node n = findNode(e.getEndNode().getName());
                    //update every node's distance to the source (if smaller)
                    n.setTimeToSource(e.getTime() + currentNode.getTimeToSource(), e);
                }
            }
            
            currentNode = getNextClosestNode();
        }
    }

    /*
     * given a source and target string, traverses the nodes in reverse order (by using every node's 'previous edge')
     * then reverses the route, simplifies the route and returns it
     */
    public Route createRoute(String source, String target)
    {
        Route route = new Route();

        //locate the target node
        Node targetNode = findNode(target);

        //start at target node, traverse every node's previous edge
        boolean foundStart = false;
        Node nextNode = targetNode;
        while(!foundStart)
        {
            route.addEdge(nextNode.getPreviousEdge());
            nextNode = findNode(nextNode.getPreviousEdge().getStartNode().getName());

            foundStart = nextNode.getName().equals(source);
        }
        route.finished();

        return route;
    }

    /*
     * given a node's name, returns the actual node from the list of nodes
     */
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

    /*
     * determines if all nodes have been visited yet or not
     */
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

    /*
     * returns the next unvisited node with the shortest time to the source
     */
    public Node getNextClosestNode()
    {
        double smallest = Double.MAX_VALUE;
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
