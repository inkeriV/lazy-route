/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lazyroute;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 *
 * @author inkeriv
 */

public class Dijkstra implements Comparable<Dijkstra> {

        private int id;
        private int paino;
        private int dist;
        
        public Dijkstra(int nid, int npaino, int ndist) {
            id = nid;
            paino = npaino;
            dist = ndist;
        }
        
        public void setId(int nid) { this.id = nid; }
        public void setPaino(int npaino) { this.paino = npaino; }
        public void setDist(int ndist) { this.dist = ndist; }
        
        public int getId() { return this.id; }
        public int getPaino() { return this.paino; }
        public int getDist() { return this.dist; }
        
        @Override
        public int compareTo(Dijkstra a) { 
            if (dist+paino<a.dist+a.paino) {
                return -1;
            }
            if (dist+paino>a.dist+a.paino) {
                return 1;
            }
            return 0;
        }
        
        @Override
        public String toString() {
            return  id+", "+paino+", "+dist;
        }
        
        static PriorityQueue<Dijkstra> keko = new PriorityQueue<Dijkstra>();
        
        public static void addKeko(Dijkstra a) {
            keko.add(a);
        }
        public static void printKeko() {
            while (!keko.isEmpty()) {
                Dijkstra a = keko.poll();
                System.out.println(a);
            }
        }
        public static void peekKeko() {
            Dijkstra a = keko.peek();
        }
        
        public static void dijkstra(Dijkstra[] lista, ArrayList<Dijkstra>[] vl, int alku, int loppu) {
            lista[alku].setPaino(0);
            lista[alku].setDist(0);
            
            boolean[] checked = new boolean[lista.length];
            for (int i=0; i<lista.length; i++) {

                checked[i]=false; 

            }
            for (Dijkstra solmu: lista) {
                keko.add(solmu);
            }
           
            int[] reitti = new int[lista.length];
            
            while (checked[loppu]==false) { 
                Dijkstra nyk = keko.poll();
                checked[nyk.id]=true;
                
                for (Dijkstra vierus: vl[nyk.id+1]) { 
                    //relax
                    if (nyk.dist+vierus.paino < vierus.dist) {
                        vierus.dist = nyk.dist+vierus.paino;
                        
                        keko.add(new Dijkstra(vierus.id, vierus.paino, vierus.dist));
                        
                        reitti[vierus.id]=nyk.id;
                    }
                }
            }

            tulostaReitti(reitti, alku, loppu);        
        }
        
        public static void tulostaReitti(int[] reitti, int alku, int loppu) {
            int u = reitti[loppu];

            Stack<Integer> print = new Stack();
            while (u != alku) { 
                print.add(u);
                u = reitti[u];

            }
            System.out.print(alku+" -> ");
            while (!print.isEmpty()) {
                u = print.pop();
                System.out.print(u + " -> ");
            }
            System.out.println(loppu);
        }

}