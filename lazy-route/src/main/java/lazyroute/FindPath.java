/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lazyroute;


import java.util.PriorityQueue;
import static lazyroute.Pino.createPino;

/**
 *
 * @author inkeriv
 */

/*

Computing happens here. Dijkstra and A*.

*/
public class FindPath {
    
    /* Initializes arrays and the heap for both algorithms */
    public static void shortestPath(Node[] list, Node[][] vl, int a, int l, String alg, int[] nodes) { //ArrayList<Node>[] vl
        
        PriorityQueue<Node> heap = new PriorityQueue<Node>();

        boolean[] checked = new boolean[list.length];
        int[] path = new int[list.length];
        
        if (alg == "d" || alg == "D") {
            list[a-1].dist=0;
            
            for (int i=0; i<list.length; i++) {   
            checked[i]=false;
            heap.add(list[i]);
            }
            
            dijkstra( vl, a, l, nodes, checked, path, heap); 
            
        } else {
            list[a-1].paino=0;
            
            for (int i=0; i<list.length; i++) {   
            checked[i]=false;
            heap.add(list[i]);
            }
            
            astar( vl, a, l, nodes, checked, path, heap);   
        }
    }
    
    private static void dijkstra( Node[][] vl, int a, int l, int[] nodes, boolean[] checked, int[] path, PriorityQueue<Node> heap) {
       
        while (checked[l-1]==false) { //while the end node (kept record by its id) has not been dealt with
            
            Node nyk = heap.poll(); 
            checked[nyk.id]=true; 
               
            for (Node vierus: vl[nyk.id]) { //for neighbour nodes..
                if (vierus!=null) {         //that are not null
                    
                    if (nyk.dist+vierus.paino < vierus.dist) {
                        
                        /*
                        if node's value is changed, we have to change its value everywhere it appears
                        (everytime it's another node's neighbour)
                        */
                        for (int i=0; i<nodes.length; i++) {   

                            for (Node k: vl[i]) {   //for neighbour nodes..
                                if (k!=null) {      //that are not null..  
                                    
                                    if (k.id==vierus.id) {
                                        k.dist = nyk.paino + nodes[vierus.id];
                                    }
                                }    
                            }
                        }    
                        /* 
                        since nodes already put in the heap cannot be changed, we have to create a new node
                        with the same id, but with changed values
                        */
                        heap.add(new Node(vierus.id, vierus.paino, vierus.dist));
                        path[vierus.id]=nyk.id; 
                    }
                }
            }        
        }
        System.out.println(returnPath(path, a, l));
    }    
    
    private static void astar( Node[][] vl, int a, int l, int[] nodes, boolean[] checked, int[] path, PriorityQueue<Node> heap) {

        while (checked[l-1]==false) { //while the end node (kept record by its id) has not been dealt with

            Node nyk = heap.poll();

            checked[nyk.id]=true; 

            for (Node vierus: vl[nyk.id]) { //for neighbour nodes..
                if (vierus!=null) {         //that are not null
                    
                    if (vierus.paino > nyk.paino + nodes[vierus.id]) {
                        
                        /*
                        if node's value is changed, we have to change its value everywhere it appears
                        (everytime it's another node's neighbour)
                        */
                        for (int i=0; i<nodes.length; i++) {
                            
                            for (Node k: vl[i]) {   //for neighbour nodes..
                                if (k!=null) {      //that are not null
                                    
                                    if (k.id==vierus.id) {
                                        k.paino = nyk.paino + nodes[vierus.id];
                                    }
                                }    
                            }
                        }
                        /* 
                        since nodes already put in the heap cannot be changed, we have to create a new node
                        with the same id, but with changed values
                        */    
                        heap.add(new Node(vierus.id, vierus.paino, vierus.dist));
                        path[vierus.id] = nyk.id;
                    }
                }    
            }
        }
        System.out.println(returnPath(path, a, l));
    }
    private static String returnPath(int[] reitti, int a, int l) {
        String result="";
        
        //int u is the index of the node which was in the path before the end node
        int u = reitti[l-1];
        Pino pino = createPino();
        
        //moving backwards in the path until we reach start node
        while (u != a-1) { 
            System.out.println(u);
            pino.addPinoon(u);
            u = reitti[u]; 
        }
        result+=a+" => "; 
        while (!pino.isEmpty()) { 
            u=pino.popPino();
            result+=u+1+" => ";
        }
        result+=l;
        return result;
    }
}
