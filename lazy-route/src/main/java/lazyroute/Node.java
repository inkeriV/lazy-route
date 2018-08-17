/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lazyroute;

/**
 *
 * @author inkeriv
 */
public class Node implements Comparable<Node> {
    
    public int id;
    public int paino;
    public int dist;
    
    //konstruktori oliolle    
    public Node(int nid, int npaino, int ndist) {
        id = nid;
        paino = npaino;
        dist = ndist;
    }
    
    public int compareTo(Node a) { 
        if (dist+paino<a.dist+a.paino) {
            return -1;
        }
        if (dist+paino>a.dist+a.paino) {
            return 1;
        }
        return 0;
    }
    
    // yksittäisen solmun tulostusta varten
    @Override
    public String toString() {
        return  id+", "+paino+", "+dist;
    }
    
}
