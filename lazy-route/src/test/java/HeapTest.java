/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.PriorityQueue;
import lazyroute.Heap;
import lazyroute.Node;
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
public class HeapTest {
    
    Heap heap;
    
    @Before
    public void setUp() {
        heap = new Heap();
    }
    
    @Test
    public void isHeapOrderCorrect() {
        Node[] list = new Node[] {
            new Node(1,1,1), new Node(2,1,1), new Node(3,1,2),
            new Node(4,1,0), new Node(5,0,7), new Node(6,2,2), 
            new Node(7,55,0), new Node(8,6,6), new Node(9,2,2),
            new Node(10,5,5), new Node(11,5,0), new Node(12,12,12),
            new Node(13,12,11), new Node(14,3,3), new Node(15,24,22),
            new Node(16,3,1), new Node(17,1,3), new Node(18,22,22),
            new Node(19,2,30), new Node(20,22,5), new Node(21,2,6),
            new Node(22,10,10), new Node(23,2,3), new Node(24,0,9),
            new Node(25,4,5), new Node(26,0,7), new Node(27,50,2),
            new Node(28,1,0), new Node(29,1,6), new Node(30,2,2),
        };
        
        PriorityQueue<Node> stack = new PriorityQueue<Node>();
        for (Node node : list) {
            stack.add(node);
        }
        heap.createHeap(list);
        
        for (int i=0; i<list.length; i++) {
            assertEquals(stack.peek().dist+stack.peek().weight, heap.peekMinValue());
            stack.poll();
            heap.popMin();
        }     
    }
}
