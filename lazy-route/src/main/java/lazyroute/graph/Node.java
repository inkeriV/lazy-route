


package lazyroute.graph;

/**
 *
 * @author inkeriv
 *
 *
 *
 * Node object. Has values id: indeks of this object in graph's list presentations,
 * weight: node's weight, dist: distance from end node.
 */

public class Node implements Comparable<Node> {
    
    public int id;
    public int weight;
    public int dist;
    
    public Node(int nid, int npaino, int ndist) {
        id = nid;
        weight = npaino;
        dist = ndist;
    }
    
    @Override
    public int compareTo(Node a) { 
        if (dist+weight<a.dist+a.weight) {
            return -1;
        }
        if (dist+weight>a.dist+a.weight) {
            return 1;
        }
        return 0;
    }
    
    @Override
    public String toString() {
        return  id+", "+weight+", "+dist;
    }
    
}
