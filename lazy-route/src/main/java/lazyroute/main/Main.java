/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lazyroute.main;

import lazyroute.graph.Graph;
import lazyroute.pathing.Path;

/**
 *
 * @author inkeriv
 */
public class Main {
    
    public String toString(int[][] graph) {

       String result="";
        
        return result;
    }
    
    private static String multiplyString(String mult, int val) {
        String ret="";
        for (int i=0; i<val; i++) {
            ret+=mult;
        }
        return ret;
    }
    
    public static void toString2(int[][] graph, int[] path, int m, int n) {
        String result = "";
        String middle = " - ";
        String between = "|";
        String empty = " ";
        String star = "*";
        
        int x=0;
        for (int j=0; j<graph.length; j++) {
            for (int i=0; i<graph[0].length; i++) {
                if (graph[i][j] == path[x]-1) {
                    System.out.println(graph[i][j]+star+empty);
                } else {
                    System.out.println(graph[i][j]+empty);
                }
                x++;
            }
            System.out.println(); System.out.println();
        }
    }
    
    public static void main(String[] args) {
        
        //running in NetBeans
        
        /*
        Graph test = new Graph(new int[]{1,3,3,4,4,4,5,5,5,2,2,1,4,2,5,3}, 1, 12, 4, 4, "d");
        System.out.println(test.init().ToString());
        */
        /*
        int[] nodes = new int[]{  10,10,10,10,10,
                                  10,10,5,5,10,
                                  10,5,5,10,10,
                                  10,5,10,10,10,
                                  10,10,10,10,10};
        System.out.println(toString2(nodes,5,5));
        /*
        Graph test2 =  new Graph(nodes, 16, 4, 5, 5, "a");
        System.out.println(test2.init().ToString());*/
 
        //System.out.println(p2.ToString(p2));
        

        
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
                                        2,1,1,7,7,7,7,3,3,2 }, 1, 99, 10,10,"d");
        System.out.println(koe.init().ToString()); */
        
        
        /*
        Graph sama = new Graph(new int[]{1,1,1,1,2,3,2,1,2,3,1,2,3,4,2,4,1,1,1,1,1,2,1,2,1,4,2,4,2,4,2,1,2,2,1,1}
                                ,1,35,6,6,"d");
        System.out.println(sama.init());
        */
        
        //------------------------------------------------------------
        //running in terminal
        //command: 
        //mvn compile exec:java -Dexec.mainClass=lazyroute.main.Main -Dexec.args="1,1,1,1,2,3,2,1,2,3,1,2,3,4,2,4,1,1,1,1,1,2,1,2,1,4,2,4,2,4,2,1,2,2,1,1, 1 35 6 6 d"
        
        
        
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
        }
        
        int alkusolmu = Integer.parseInt(args[1]);
        int loppusolmu = Integer.parseInt(args[2]);
        int m = Integer.parseInt(args[3]);
        int n = Integer.parseInt(args[4]);
        String algoritmi = args[5];
        
        Graph koe=new Graph(lista, alkusolmu, loppusolmu, m, n, algoritmi); 
        System.out.println(koe.init());
        
    }
}
