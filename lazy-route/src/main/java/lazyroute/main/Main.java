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
    
    public static String toString2(int[] graph, int m, int n) {
        String result = "";
        String middle = " - ";
        String between = "|";
        String empty = " ";
        
        //-------------FIND-LONGEST-NUMBER-------------------
        int max = 0;
        
        for (int a=0; a<graph.length; a++) {
            if (max < Integer.toString(graph[a]).length()) {
                max = Integer.toString(graph[a]).length();
            }
        }
        //---------------------------------------------------
        
        //goes through the graph
        int index=0;
        //---------------------------------------------------
        String middleRow="";
        for (int b=0; b<m-1; b++) {
            middleRow+=between+multiplyString(empty,max+2);
        }
        middleRow+=between;
        //---------------------------------------------------
        int rowLength = middleRow.length();
        //---------------------------------------------------
        
        
        for (int j=0; j<n; j++) {
            result+="\n";
            for (int i=0; i<m; i++) {
                //--------------TÄÄLLÄ ONGELMIA-:(--------------------
                if (i==m-1) {
                    result+=multiplyString(empty,max)+Integer.toString(graph[index]);
                    index++; 
                  
                } else {
                    result+=Integer.toString(graph[index])+middle;
                    index++; 
                }
                //----------------------------------------------------------
            }
            result+="\n"+middleRow; //pystyviivoja niin monta kuin m, väliin niin monta kuin max +2 (molemmille puolille)
        } 

        return result;
    }
    
    public static void main(String[] args) {
        
        //running in NetBeans
        //Graph test = new Graph(new int[]{1,3,3,4,4,4,5,5,5,2,2,1,4,2,5,3}, 1, 12, 4, 4, "a");
        
        //Path p = getPath(test);
        //System.out.println(p.ToString(p));
        
        /*int[] nodes = new int[]{  10,10,10,10,10,
                                  10,10,5,5,10,
                                  10,5,5,10,10,
                                  10,5,10,10,10,
                                  10,10,10,10,10};
        
        System.out.println(toString2(nodes,5,5));*/
        /*Graph test2 =  new Graph(nodes, 16, 4, 5, 5, "a");
        Path p2 = getPath(test2);*/
        //System.out.println(p2.ToString(p2));
        

        
        
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
        Path result = koe.init();
        System.out.println(result.ToString(result)); 
        
        
        /*
        Graph sama = new Graph(new int[]{1,1,1,1,2,3,2,1,2,3,1,2,3,4,2,4,1,1,1,1,1,2,1,2,1,4,2,4,2,4,2,1,2,2,1,1}
                                ,1,35,6,6,"d");
        Path result = sama.init();
        System.out.println(result.ToString(result));
        */
        
        //------------------------------------------------------------
        //running in terminal
        //command: 
        //mvn compile exec:java -Dexec.mainClass=lazyroute.main.Main -Dexec.args="1,1,1,1,2,3,2,1,2,3,1,2,3,4,2,4,1,1,1,1,1,2,1,2,1,4,2,4,2,4,2,1,2,2,1,1, 1 35 6 6 d"
        
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

        Graph koe=new Graph(lista, alkusolmu, loppusolmu, m, n, algoritmi);
        Path result = koe.init();
        System.out.println(result.ToString(result));;
        */   
    }
}
