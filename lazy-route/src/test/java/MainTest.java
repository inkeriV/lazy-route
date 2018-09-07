
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import lazyroute.graph.Graph;
import static lazyroute.main.Main.main;
import static org.junit.Assert.assertEquals;
import org.junit.Test;




/**
 *
 * @author vbinkeri
 */

public class MainTest {
    
        
    @Test
    public void mainMethodGetsArgumentsRight() { //tested as if the printed String is as expected
        
        String[] args  = new String[6];
        args[0] = "1,1,2,1,2,2,1,1,2,";
        args[1] = "1";
        args[2] = "9";
        args[3] = "3";
        args[4] = "3";
        args[5] = "a";
        
        /* graph looks like this:
        1-1-2
        1-2-2
        1-1-2
        so shortest path from 1st node to last node is to go along the left side, then bottom
        path is 1 => 4 => 7 => 8 => 9 */
        
        Graph h = new Graph(new int[]{1,1,2,1,2,2,1,1,2},1,9,3,3,"a");
        
        final ByteArrayOutputStream output = new ByteArrayOutputStream();
 
        System.setOut(new PrintStream(output));
        
        main(args);

        assertEquals(h.getPath()+"\n", output.toString());       
    }

    @Test
    public void mainMethodThrowsException() {
        
        String[] args  = new String[6];
        args[0] = "1,1,2,1,EEE,2,1,1,2,"; //EEE is not an integer
        args[1] = "1";
        args[2] = "9";
        args[3] = "3";
        args[4] = "3";
        args[5] = "a";
        
        final ByteArrayOutputStream output = new ByteArrayOutputStream();
        
        System.setErr(new PrintStream(output));
        
        main(args);

        assertEquals("Argument" + args[0] + " must be a list of integers."+"\n", output.toString());       
    }

}
