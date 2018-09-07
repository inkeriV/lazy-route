

import lazyroute.datastructures.Stack;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static lazyroute.datastructures.Stack.createStack;

/**
 *
 * @author inkeriv
 */

public class StackTest{ 
    
    Stack p;
    
    @Before
    public void setUp() {
        p = createStack();
    }
    
    @Test
    public void creationOfStackWorks() {
        Stack koe = createStack();
        assertEquals(0,koe.size);
        assertEquals(1000,koe.stack.length);
    }
    
    @Test
    public void indexIncreasesCorrectly() {
        assertEquals(0,p.size);
        p.addToStack(5);
        assertEquals(1,p.size);
    }
    
    @Test
    public void indexIncresesCorrectlyWhenSizeIsIncreased() {
        for (int i=0; i<2240; i++) {
            p.addToStack(i+12);
        }
        assertEquals(2240, p.size);
    }
    
    @Test
    public void stackLengthIsCorrectWhenSizeIsIncreased() {
        for (int i=1; i<2240; i++) {
            p.addToStack(i*3);
        }
        assertEquals(4000, p.stack.length);
    }
    
    @Test
    public void sizeDecreasesCorrectly() {
        p.addToStack(44);
        p.addToStack(11);
        int h = p.popStack();
        assertEquals(1,p.size);
    }
    
    @Test
    public void sizeDecreasesCorrectlyAfterSeveralActions() {
        for (int i=0; i<2383; i++) {
            p.addToStack(i+9);
        }
        for (int i=0; i<1168; i++) {
            p.popStack();
        }
        assertEquals(1215,p.size); 
    }
    
    @Test
    public void popWorks() {
        p.addToStack(111);
        int h = p.popStack();
        assertEquals(111,  h);
    }
    
    @Test
    public void popWorksAfterSeveralActions() {
        for (int i=0; i<2383; i++) {
            p.addToStack(i+12);
        }
        int h = p.popStack();
        assertEquals(2394,h);
    }
    
    @Test
    public void isEmptyWorks() {
        assertEquals(true, p.isEmpty());
        p.addToStack(3);
        assertEquals(false, p.isEmpty());
        int h=p.popStack();
        assertEquals(true, p.isEmpty());
    }   
}
