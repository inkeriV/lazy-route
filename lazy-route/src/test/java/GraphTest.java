/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import lazyroute.Node;
import lazyroute.Graph;
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
        Node[][] nodes =new Node[16][4];
        int[] weights = new int[]{4,3,2,1,1,2,3,4,3,4,2,1,1,4,2,3};
        Node[] list1 = new Node[weights.length];
        Node[][] tulos = test.AdjacencyLforD(weights, nodes, 4,4, list1);
        int i=0;
        for (Node kaikki:tulos[i]) {
            if (kaikki!=null) {
                assertEquals(1000000000,kaikki.dist);
                assertEquals(kaikki.weight, weights[kaikki.id]);
                i++;
            }    
        }
    }
    
    @Test
    public void doesAdjacencyListGetInitializedCorrectlyforAStar() {
        Node[][] nodes =new Node[16][4];
        int[] weights = new int[]{4,3,2,1,1,2,3,4,3,4,2,1,1,4,2,3};
        Node[] list1 = new Node[weights.length];
        Node[][] tulos = test.AdjacencyLforA(weights, nodes, 4,4, list1);
        int i=0;
        for (Node kaikki:tulos[i]) {
            if (kaikki!=null) {
                assertEquals(1000000000,kaikki.weight);
                i++;
            }    
        }
    }
    
}
