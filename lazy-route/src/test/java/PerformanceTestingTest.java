/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static lazyroute.main.PerformanceTesting.createRandomGraph;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author inkeriv
 */
public class PerformanceTestingTest {
    
    private boolean lessThanHundred(int i) {
        if (i<100) { return true ; }
        return false;
    }
    @Test
    public void isRandomGraphCorrect() {
        int[] random = createRandomGraph();
        
        for (int i=0; i<random.length; i++) {
            assertEquals(true, lessThanHundred(random[i]));
        }
}
}
