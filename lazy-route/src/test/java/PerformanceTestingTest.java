

import static lazyroute.main.PerformanceTesting.createRandomGraph;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author inkeriv
 */

public class PerformanceTestingTest {
    
    private boolean lessThanHundred(int i) {
        return i<100;
    }
    
    @Test
    public void isRandomGraphCorrect() {
        int[] random = createRandomGraph();
        
        for (int i=0; i<random.length; i++) {
            assertEquals(true, lessThanHundred(random[i]));
        }
    }
}
