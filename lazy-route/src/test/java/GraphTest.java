

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import lazyroute.graph.Node;
import lazyroute.graph.Graph;
import static lazyroute.main.Main.main;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author inkeriv
 */

public class GraphTest {
    
    Graph test;
    Node[] list;
    
    @Before
    public void setUp() {
        int[] painot = new int[]{4,3,2,1,1,2,3,4,3,4,2,1,1,4,2,3};
        test = new Graph(painot, 1,16,4,4,"d");
    }   
    
    @Test
    public void toimiikoH() {
        assertEquals(1,test.h(2,1,1,1));
        assertEquals(7,test.h(1,2,7,3));
    }
    
    @Test  
    public void doesAdjacencyListGetInitializedCorrectlyforDijkstra() {
        int[][] vll =new int[16][4];
        int[] weights = new int[]{4,3,2,1,1,2,3,4,3,4,2,1,1,4,2,3};
        Node[] list1 = new Node[weights.length];
        int[] dists = new int[weights.length];
        int[][] tulos = test.AdjacencyListDijkstra(weights,vll,4,4,list1,dists);
        
        int i=0;
        for (int kaikki:tulos[i]) {
            if (kaikki != -1) {
                assertEquals(1000000000,dists[kaikki]);
            }
            i++;
        }
    }
    
    @Test
    public void doesAdjacencyListGetInitializedCorrectlyforAStar() {
        int[][] vll =new int[16][4];
        int[] weights = new int[]{4,3,2,1,1,2,3,4,3,4,2,1,1,4,2,3};
        Node[] list1 = new Node[weights.length];
        int[] dists = new int[weights.length];
        int[] painot = new int[weights.length];
        
        int[][] tulos = test.AdjacencyListAStar(weights,vll,4,4,list1,painot,dists);
        
        int i=0;
        for (int kaikki:tulos[i]) {
            if (kaikki != -1) {
                assertEquals(list1[kaikki].weight, painot[kaikki]);
                assertEquals(list1[kaikki].dist, dists[kaikki]);
            }
            i++;
        }
    }
    
    @Test
    public void areStartAndEndNodeCoordinatesCorrectAndDoGetsReturnThemRight() {
        Graph g = new Graph(new int[]{  4,4,4,4,4,
                                        4,4,4,4,4,
                                        4,4,4,4,4,
                                        4,4,4,4,4,
                                        4,4,4,4,4 }, 7, 24, 5, 5, "a");
        g.getPath();
        
        assertEquals(1, g.getStartNodeCoordinateI());
        assertEquals(1, g.getStartNodeCoordinateJ());
        
        assertEquals(3, g.getEndNodeCoordinateI());
        assertEquals(4, g.getEndNodeCoordinateJ());    
    }

}
