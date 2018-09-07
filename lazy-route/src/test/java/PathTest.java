

import lazyroute.graph.Graph;
import lazyroute.graph.Node;
import lazyroute.pathing.Path;
import static lazyroute.pathing.Path.shortestPath;
import org.junit.Before;
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
        int[][] vl = new int[25][];
        for (int i=0; i<25; i++) {
            vl[i]=new int[4];
        }
        Node[] list = new Node[25];
        int[] dists = new int[25];
        int[] weights = new int[25];
        
        vl=test.AdjacencyListDijkstra(nodes,vl,5,5,list,dists);
         
        obj=shortestPath(list, vl ,16,4,"D", nodes, weights, dists);
       
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
        int[][] vl = new int[25][];
        for (int i=0; i<25; i++) {
            vl[i]=new int[4];
        }
        Node[] list = new Node[25];
        int[] dists = new int[25];
        int[] weights = new int[25];
        
        vl=test.AdjacencyListAStar(nodes,vl,5,5,list,weights,dists);
         
        obj=shortestPath(list, vl ,16,4,"A", nodes, weights, dists);;
       
        assertEquals(16,obj.nodepath[0]); //first node in path: start node
        assertEquals(17,obj.nodepath[1]); //2nd node in the shortest path 
        assertEquals(12,obj.nodepath[2]); //and so on
        assertEquals(13,obj.nodepath[3]);
        assertEquals(8,obj.nodepath[4]);
        assertEquals(9,obj.nodepath[5]);
        assertEquals(4,obj.nodepath[6]); //end node
    }  
}
