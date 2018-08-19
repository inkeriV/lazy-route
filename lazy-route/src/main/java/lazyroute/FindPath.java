/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lazyroute;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;
import static lazyroute.Prints.tulostaReitti;

/**
 *
 * @author inkeriv
 */

/*

Laskenta tapahtuu täällä.

*/
public class FindPath {
    
    /* Alustava metodi dijkstraan ja a-stariin. */
    public static void shortestPath(Node[] lista, ArrayList<Node>[] vl, int alku, int loppu, String alg, int[] solmut) {
        
        PriorityQueue<Node> keko = new PriorityQueue<Node>();

        boolean[] checked = new boolean[lista.length];
        int[] reitti = new int[lista.length];
        
        if (alg == "d" || alg == "D") {
            lista[alku-1].dist=0;
        } else {
            lista[alku-1].paino=0;
        }
        
        
        for (int i=0; i<lista.length; i++) {   
            checked[i]=false; 
        }

        for (Node solmu: lista) {
            keko.add(solmu);
        }
        
        if (alg == "d" || alg == "D") {
            dijkstra(lista, vl, alku, loppu, solmut, checked, reitti, keko);
        } else {
            astar(lista, vl, alku, loppu, solmut, checked, reitti, keko); //tarvii viel int[] solmut & reitti+checked
        }    
    }
    
    private static void dijkstra(Node[] lista, ArrayList<Node>[] vl, int alku, int loppu, int[] solmut, boolean[] checked, int[] reitti, PriorityQueue<Node> keko) {
       
        while (checked[loppu-1]==false) { 
            
            Node nyk = keko.poll(); 
            checked[nyk.id]=true; 
            
            for (Node vierus: vl[nyk.id+1]) { 
               
                if (nyk.dist+vierus.paino < vierus.dist) {
                     
                    for (int i=1; i<solmut.length+1; i++) {
                        for (Node k: vl[i]) {
                            if (k.id==vierus.id) {
                                k.dist = nyk.paino + solmut[vierus.id];
                            }    
                        }
                    }
                    keko.add(new Node(vierus.id, vierus.paino, vierus.dist));
                        
                    reitti[vierus.id]=nyk.id; 
                }
            }
        }
        tulostaReitti(reitti, alku, loppu);        
    }
    
    private static void astar(Node[] lista, ArrayList<Node>[] vl, int a, int l, int[] solmut, boolean[] checked, int[] reitti, PriorityQueue<Node> keko) {

        while (checked[l-1]==false) { 

            Node nyk = keko.poll();

            checked[nyk.id]=true; 

            for (Node vierus: vl[nyk.id+1]) {  
                    
                if (vierus.paino > nyk.paino + solmut[vierus.id]) {

                    for (int i=1; i<solmut.length+1; i++) {
                        for (Node k: vl[i]) {
                            if (k.id==vierus.id) {
                                k.paino = nyk.paino + solmut[vierus.id];
                            }    
                        }
                    }

                    keko.add(new Node(vierus.id, vierus.paino, vierus.dist));
                    reitti[vierus.id] = nyk.id;
                }    
            }
        }   
        tulostaReitti(reitti, a, l);
    }   
}
