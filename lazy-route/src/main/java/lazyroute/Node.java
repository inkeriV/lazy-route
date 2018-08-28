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

/*

Solmu-olio. Arvoina id, joka on listoissa kyseisen olion indeksi,
paino, joka Dijkstrassa on solmun oma paino, A-starissa solmujen etäisyys
alkusolmusta (alustetaan äärettömään) sekä dist: Dijkstrassa etäisyys 
alkusolmusta (alustetaan äärettömään) ja A-starissa heuristinen etäisyysarvo loppusolmuun.

Node object. Has values id: indeks of this object in graph's list presentations,
paino: node's weight, dist: distance from end node.

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
