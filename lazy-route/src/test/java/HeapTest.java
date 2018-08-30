/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.PriorityQueue;
import junit.framework.Assert;
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
    // testing if heap returns same node values as java.util.PriorityQueue
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
    
    @Test
    public void heapConstructorWorks() {
        assertEquals(1000, heap.harray.length);
        assertEquals(-1, heap.size);
        assertEquals(1000,heap.length);
    }
    
    @Test
    public void addingWorksAndSizeIsRigthAfterThat() {
        heap.add(new Node(1,1,1));
        assertEquals("1, 1, 1",heap.peekMinNode().toString());
        assertEquals(0, heap.size);
    }
    
    @Test
    public void sizeIsCorrectAfterPopping() {
        heap.add(new Node(1,1,1));
        assertEquals(0, heap.size);
        heap.add(new Node(2,1,1));
        heap.popMin();
        heap.popMin();
        assertEquals(-1, heap.size);           
    }
    
    @Test
    public void addMethodCallsSizeDoubleingCorrectly() {
        for (int i=0; i<2600; i++) {
            heap.add(new Node(1,1,1));
        }
        assertEquals(4000, heap.harray.length);
        assertEquals(2599, heap.size);
    }
    
    @Test
    public void popWorks() {
        heap.add(new Node(1,1,3));
        heap.add(new Node(2,1,4));
        heap.add(new Node(3,5,1));
        
        assertEquals("1, 1, 3", heap.popMin().toString());    
    }
    
    @Test
    public void bubbleUPWorks() {
        heap.add(new Node(1,1,3));
        heap.add(new Node(2,1,4));
        heap.add(new Node(3,5,1));
        
        assertEquals("1, 1, 3", heap.peekMinNode().toString());
        assertEquals(4, heap.peekMinValue());
        
        heap.add(new Node(4,2,1));
        
        assertEquals(3, heap.peekMinValue());
        
        heap.add(new Node(5,1,1));
        
        assertEquals(2, heap.peekMinValue());
    }
    
    @Test
    public void bubbleDownWorks() {
        heap.add(new Node(1,1,3));
        heap.add(new Node(3,5,1));
        heap.add(new Node(2,1,4));
        
        heap.popMin();
        
        assertEquals("2, 1, 4", heap.popMin().toString());
        assertEquals(6, heap.peekMinValue());
    }
    
    @Test
    public void doubleSizeWorks() {
        heap.doubleSize();
        assertEquals(2000, heap.harray.length);
        heap.doubleSize();
        assertEquals(4000, heap.harray.length);
    }
    
    @Test
    public void bothPeekMethodsWork() {
        assertEquals(null, heap.peekMinNode());
        assertEquals(-1 , heap.peekMinValue());
        
        heap.add(new Node(1,233, 99));
        heap.add(new Node(2, 1000, 1000));
        
        assertEquals("1, 233, 99", heap.peekMinNode().toString());
        assertEquals(332 , heap.peekMinValue());
    }
    
    @Test 
    public void bothPeeksWontPop() {
        heap.add(new Node(1,233, 99));
        heap.add(new Node(2, 1000, 1000));
        
        heap.peekMinNode();
        heap.peekMinValue();
        
        assertEquals("1, 233, 99", heap.popMin().toString());
    }
}
