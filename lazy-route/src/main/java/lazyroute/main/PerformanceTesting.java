/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lazyroute.main;

import lazyroute.graph.Graph;

/**
 *
 * @author inkeriv
 */
public class PerformanceTesting {
    
    public static int[] createRandomGraph() {
        
        int[] graph = new int[1000000];
        
        for (int i=0; i<1000000; i++) {
            graph[i]=(int)Math.floor(Math.random()*100);
        }
        
        return graph;
    }
    
    public static void main(String[] args) {
        
        String input = args[0];
        int n = Integer.parseInt(input);
        
        for (int i=1; i<=n; i++) {
            int[] graph = createRandomGraph();
            
            Graph a = new Graph(graph, 1, 1000000, 1000, 1000, "a");
            Graph d = new Graph(graph, 1, 1000000, 1000, 1000, "d");

            long beginningTimeAStar = System.currentTimeMillis();

            a.init();

            long endingTimeAStar = System.currentTimeMillis();
            System.out.println("Computing with A-star took "+ (endingTimeAStar - beginningTimeAStar) + " ms.\n");

            long beginningTimeDijkstra = System.currentTimeMillis();

            d.init();

            long endingTimeDijkstra = System.currentTimeMillis();
            System.out.println("Computing with Dijkstra took " + (endingTimeDijkstra - beginningTimeDijkstra) + " ms.\n");

        }  
    }  
}
