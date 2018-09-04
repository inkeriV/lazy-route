/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lazyroute.main;

import lazyroute.graph.Graph;
import static lazyroute.graph.Graph.getPath;
import static lazyroute.graph.Graph.testPerformance;
import lazyroute.pathing.Path;

/**
 *
 * @author inkeriv
 */
public class Main {
    
    
    public static void main(String[] args) {
        
        //running in NetBeans
        Graph test = new Graph(new int[]{1,3,3,4,4,4,5,5,5,2,2,1,4,2,5,3}, 1, 12, 4, 4, "a");
        
        Path p = getPath(test);
        //System.out.println(p.ToString(p));
        
        int[] nodes = new int[]{  10,10,10,10,10,
                                  10,10,5,5,10,
                                  10,5,5,10,10,
                                  10,5,10,10,10,
                                  10,10,10,10,10};
        Graph test2 =  new Graph(nodes, 16, 4, 5, 5, "a");
        Path p2 = getPath(test2);
        //System.out.println(p2.ToString(p2));
        
        //testPerformance(1);
        
         /*
        Graph koe=new Graph(new int[]{1,2,2,2,2,2,9,9,9,7,
                                        3,3,3,4,3,4,3,2,1,2,
                                        5,5,5,5,6,6,6,7,3,1,
                                        3,4,4,4,4,4,2,2,1,1,
                                        7,7,7,7,3,3,2,1,5,3,
                                        1,2,2,2,2,2,9,9,9,7,
                                        3,3,3,4,3,4,3,2,1,2,
                                        5,5,5,5,6,6,6,7,3,1,
                                        3,4,4,4,4,4,4,4,4,2,
                                        2,1,1,7,7,7,7,3,3,2 }, 1, 99, 10,10,"a");
        koe.init();
        */
        //------------------------------------------------------------
        //running in terminal
        
        
        //command: 
        //mvn compile exec:java -Dexec.mainClass=lazyroute.Verkko 
        //                -Dexec.args="1,1,1,1,2,3,2,1,2,3,1,2,3,4,2,4,1,1,1,1,1,2,1,2,1,4,2,4,2,4,2,1,2,2,1,1, 1 35 6 6 d"
        
        /*
        String patki = args[0];
        int[] lista = new int[(int)Math.floor(patki.length()/2)];
        int apu=0;
        
        try {
            for (String k: patki.split(",")) {
                lista[apu]=Integer.parseInt(k);
            }
        } catch (NumberFormatException e) {
            System.err.println("Argument" + args[0] + " must be a list of integers.");
        }
        

        int alkusolmu = Integer.parseInt(args[1]);
        int loppusolmu = Integer.parseInt(args[2]);
        int m = Integer.parseInt(args[3]);
        int n = Integer.parseInt(args[4]);
        String algoritmi = args[5];

        Verkko koe=new Verkko(lista, alkusolmu, loppusolmu, m, n, algoritmi);
        koe.alustus();
        */
        
    }
    
}
