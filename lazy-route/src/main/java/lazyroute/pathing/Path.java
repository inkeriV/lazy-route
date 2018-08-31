/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lazyroute.pathing;


import java.util.PriorityQueue;
import lazyroute.datastructures.Stack;
import lazyroute.graph.Node;
import lazyroute.datastructures.Heap;
import static lazyroute.datastructures.Stack.createStack;

/**
 *
 * @author inkeriv
 */

/*

Path class has a Path-object which includes:
    int array - has the node id's of the nodes in the shortest path from start node to end node
    int - the weight of the path (start node weight not included)
    int - the number of nodes in the shortest path including start and end nodes
    
    shortestPath method returns a Path object to the very first method called. ShortestPath method calls either
    Dijkstra or AStar.

    Dijkstra and AStar actually find the shortest path, and document it in an int array ("path"). After calling either one of those two,
    shortestPath creates a null Path object and inserts the correct values in its attributes based on the path-array.
*/
public class Path {
    
    public int[] nodepath;
    public int totalweight;
    public int nodecount;
    
    public Path() {
        nodepath=null;
        totalweight=0;
        nodecount=0;
    }

    
    /* Returns Path-object EI VOI OLLA STATIC KOSKA STACK TULEE TÄYTEEN?
    */
    public static Path shortestPath(Node[] list, Node[][] vl, int a, int l, String alg, int[] nodes) { 

        Heap minheap = new Heap();
        

        boolean[] checked = new boolean[list.length];

        int[] path = new int[list.length];
        
        if (alg == "d" || alg == "D") {
            
            list[a-1].dist=0;
            minheap.createHeap(list);
            
            dijkstra( vl, a, l, nodes, checked, path, minheap); 
            
        } else {
            
            list[a-1].weight=0;
            minheap.createHeap(list);

            astar( vl, a, l, nodes, checked, path, minheap);   
        }
        
        //new Path object, the one we are returning
        Path resultpath = new Path();
        Stack stack = createStack();
        
        int u = path[l-1];
        resultpath.setNumberOfNodesInPath(); //adding end node to the count 
        resultpath.setWeightOfPath(nodes[u]); //the weight of the end node

        
        while (u != a-1) {
            stack.addToStack(u);
            u = path[u];
            resultpath.setNumberOfNodesInPath();
            resultpath.setWeightOfPath(nodes[u]);
        }
        resultpath.setNumberOfNodesInPath();
        
        resultpath.nodepath=new int[resultpath.getNumberOfNodesInPath()];
        resultpath.nodepath[0]=a;
        int apu=1;
        while (!stack.isEmpty()) {
            u = stack.popStack();
            resultpath.nodepath[apu]=u+1;
            
            apu++;
        }
        resultpath.nodepath[resultpath.nodepath.length-1]=l;
        //stack.emptyStack();
        
        return resultpath;
    }
    
    private static void dijkstra( Node[][] vl, int a, int l, int[] nodes, boolean[] checked, int[] path, Heap minheap) {
       
        while (checked[l-1]==false) { //while the end node (kept record by its id) has not been dealt with
            
            Node nyk = minheap.popMin(); 
            
            checked[nyk.id]=true; 
               
            for (Node vierus: vl[nyk.id]) { //for neighbour nodes..
                if (vierus!=null) {         //that are not null
                    
                    if (nyk.dist+vierus.weight < vierus.dist) {
                        
                        /*
                        if node's value is changed, we have to change its value everywhere it appears
                        (everytime it's another node's neighbour)
                        */
                        for (int i=0; i<nodes.length; i++) {   

                            for (Node k: vl[i]) {   //for neighbour nodes..
                                if (k!=null) {      //that are not null..  
                                    
                                    if (k.id==vierus.id) {
                                        k.dist = nyk.dist + vierus.weight; //tässä ennen nyk.weight + nodes[vierus.id] >> suurilla verkoilla reitti oli väärä
                                    }
                                }    
                            }
                        }    
                        /* 
                        since nodes already put in the heap cannot be changed, we have to create a new node
                        with the same id, but with changed values
                        */
                        minheap.add(new Node(vierus.id, vierus.weight, vierus.dist));
                        path[vierus.id]=nyk.id;
                     
                    }
                }
            }        
        }
        
    }    
    
    private static void astar( Node[][] vl, int a, int l, int[] nodes, boolean[] checked, int[] path, Heap minheap) {

        while (checked[l-1]==false) { //while the end node (kept record by its id) has not been dealt with

            Node nyk = minheap.popMin();

            checked[nyk.id]=true; 

            for (Node vierus: vl[nyk.id]) { //for neighbour nodes..
                if (vierus!=null) {         //that are not null
                    
                    if (vierus.weight > nyk.weight + nodes[vierus.id]) {
                        
                        /*
                        if node's value is changed, we have to change its value everywhere it appears
                        (everytime it's another node's neighbour)
                        */
                        for (int i=0; i<nodes.length; i++) {
                            
                            for (Node k: vl[i]) {   //for neighbour nodes..
                                if (k!=null) {      //that are not null
                                    
                                    if (k.id==vierus.id) {
                                        k.weight = nyk.weight + nodes[vierus.id];
                                    }
                                }    
                            }
                        }
                        /* 
                        since nodes already put in the heap cannot be changed, we have to create a new node
                        with the same id, but with changed values
                        */    
                        minheap.add(new Node(vierus.id, vierus.weight, vierus.dist));
                        path[vierus.id] = nyk.id;
                    }
                }    
            }
        }
    }
    
    public String ToString(Path obj) {
        String result="Shortest path between given start node and end node:\n";
        for (int i=0; i<nodepath.length; i++) {
            if (i==nodepath.length-1) {
                result+=nodepath[i]+"\n";
            } else {
            result+=nodepath[i]+" => ";
            }
        }
        result+="The weight of this path is: "+totalweight+"\n";
        result+="The number of nodes in this path is: "+nodecount;
        return result+"\n";
    }
    
        
    public void setPath(int[] path) { nodepath=path; }
    
    public void setWeightOfPath(int value) { totalweight+=value; }
    
    public void setNumberOfNodesInPath() { nodecount++; }
    
    public int getNumberOfNodesInPath() { return nodecount; }
}

