/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.PriorityQueue;
import lazyroute.Graph;
import lazyroute.Heap;
import lazyroute.Node;
import lazyroute.Path;
import static lazyroute.Path.shortestPath;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author inkeriv
 */
public class PathTest {
    
    Path obj;
    
    @Before
    public void setUp() {
        obj = new Path();
    }
    
    @Test
    public void PathObjectValuesAreSetCorrectly() {
        obj.setNumberOfNodesInPath();
        obj.setWeightOfPath(100);
        obj.setPath(new int[]{1});
        assertEquals(1,obj.nodecount);
        assertEquals(1,obj.getNumberOfNodesInPath());
        assertEquals(100,obj.totalweight);
        assertEquals(1,obj.nodepath.length);
    }
    
    @Test
    public void doesDijkstraMakeTheCorrectPathArray(){
        int[] nodes = new int[]{  10,10,10,10,10,
                                  10,10,5,5,10,
                                  10,5,5,10,10,
                                  10,5,10,10,10,
                                  10,10,10,10,10};
        Graph test =  new Graph(nodes, 16, 4, 5, 5, "d");
        Node[][] vl = new Node[25][];
        for (int i=0; i<25; i++) {
            vl[i]=new Node[4];
        }
        Node[] list = new Node[25];
        vl=test.AdjacencyLforD(nodes,vl,5,5,list);
        
        PriorityQueue<Node> heap = new PriorityQueue<Node>();
         
        obj=shortestPath(list,vl,16,4,"D",nodes);
       
        assertEquals(16,obj.nodepath[0]); //first node in path: start node
        assertEquals(17,obj.nodepath[1]); //2nd node in the shortest path 
        assertEquals(12,obj.nodepath[2]); //and so on
        assertEquals(13,obj.nodepath[3]);
        assertEquals(8,obj.nodepath[4]);
        assertEquals(9,obj.nodepath[5]);
        assertEquals(4,obj.nodepath[6]); //end node
    }
    
    @Test
    public void doesAStarMakeTheCorrectPathArray(){
        int[] nodes = new int[]{  10,10,10,10,10,
                                  10,10,5,5,10,
                                  10,5,5,10,10,
                                  10,5,10,10,10,
                                  10,10,10,10,10};
        Graph test =  new Graph(nodes, 16, 4, 5, 5, "a");
        Node[][] vl = new Node[25][];
        for (int i=0; i<25; i++) {
            vl[i]=new Node[4];
        }
        Node[] list = new Node[25];
        vl=test.AdjacencyLforA(nodes,vl,5,5,list);
         
        obj=shortestPath(list,vl,16,4,"A",nodes);
       
        assertEquals(16,obj.nodepath[0]); //first node in path: start node
        assertEquals(17,obj.nodepath[1]); //2nd node in the shortest path 
        assertEquals(12,obj.nodepath[2]); //and so on
        assertEquals(13,obj.nodepath[3]);
        assertEquals(8,obj.nodepath[4]);
        assertEquals(9,obj.nodepath[5]);
        assertEquals(4,obj.nodepath[6]); //end node
    }  
}
