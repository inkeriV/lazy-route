

package lazyroute.main;
import lazyroute.graph.Graph;

/**
 *
 * @author inkeriv
 */

public class Main {
    
    public static void main(String[] args) {

        /*
        When executed from terminal. Under is an example command.
        
        mvn compile exec:java -Dexec.mainClass=lazyroute.main.Main -Dexec.args="1,1,1,1,2,3,2,1,2,3,1,2,3,4,2,4,1,1,1,1,1,2,1,2,1,4,2,4,2,4,2,1,2,2,1,1, 1 35 6 6 d"
        */
        
        String patki = args[0];
        int[] lista = new int[(int)Math.floor(patki.length()/2)];
        int apu=0;
        
        try {
            for (String k: patki.split(",")) {

                lista[apu]=Integer.parseInt(k);

                apu++;
            }
            
        } catch (NumberFormatException e) {
            System.err.println("Argument" + args[0] + " must be a list of integers.");
            return;
        }
        
        int alkusolmu = Integer.parseInt(args[1]);
        int loppusolmu = Integer.parseInt(args[2]);
        int m = Integer.parseInt(args[3]);
        int n = Integer.parseInt(args[4]);
        String algoritmi = args[5];
        
        Graph koe=new Graph(lista, alkusolmu, loppusolmu, m, n, algoritmi); 
        System.out.println(koe.init());
        
                
        /*
        //To run in NetBeans, here's an example graph and execution calls
        
        int[] nodes = new int[]{  10,10,10,10,10,
                                  10,10,5,5,10,
                                  10,5,5,10,10,
                                  10,5,10,10,10,
                                  10,10,10,10,10 };
        
        
        Graph test2 =  new Graph(nodes, 16, 4, 5, 5, "a");
        System.out.println(test2.init());
        
        */
    }
}
