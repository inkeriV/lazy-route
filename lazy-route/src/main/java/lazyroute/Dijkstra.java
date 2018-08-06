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
    
    /* Dijkstra*/

    public int id;
    public int paino;
    public int dist;
    
    //konstruktori oliolle    
    public Dijkstra(int nid, int npaino, int ndist) {
        id = nid;
        paino = npaino;
        dist = ndist;
    }
    
    
    // SET ja GET metodit 
    public void setId(int nid) { this.id = nid; }
    public void setPaino(int npaino) { this.paino = npaino; }
    public void setDist(int ndist) { this.dist = ndist; }
        
    public int getId() { return this.id; }
    public int getPaino() { return this.paino; }
    public int getDist() { return this.dist; }
        
    
    
    /* compareTo metodi solmuille minimikekoa varten. Järjestetään painon ja etäisyyden summan mukaan. */
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
    
    // yksittäisen solmun tulostusta varten
    @Override
    public String toString() {
        return  id+", "+paino+", "+dist;
    }
    
    // minimikeko
    static PriorityQueue<Dijkstra> keko = new PriorityQueue<Dijkstra>();
        
    
    /* Dijkstra-metodin parametrit: 
    lista - Solmut listassa ruudukon mittojen mukaan rivi kerrallaan
    vl - vieruslista muodossa vl[int i]=lista solmu-olioita
    alku ja loppu - solmujen järjestysnumerot */
    
    public static void dijkstra(Dijkstra[] lista, ArrayList<Dijkstra>[] vl, int alku, int loppu) {
        
        //alkusolmun etäisyys nollaksi 
        lista[alku].setDist(0);
        
        //lista käsiteltyjen solmujen kirjanpitoa varten
        boolean[] checked = new boolean[lista.length];
        for (int i=0; i<lista.length; i++) {
            
            checked[i]=false; //aluksi yhtäkään solmua ei ole käsitelty
        }
        
        //kaikki solmuoliot minimikekoon
        for (Dijkstra solmu: lista) {
            keko.add(solmu);
        }
        
        //taulukko lyhintä reittiä varten
        int[] reitti = new int[lista.length];
        
        
        while (checked[loppu]==false) { 
            
            Dijkstra nyk = keko.poll(); 
            checked[nyk.id]=true; 
            
            //jokaiselle käsittelyssä olevan solmun vierussolmuille
            for (Dijkstra vierus: vl[nyk.id+1]) { 
               
                if (nyk.dist+vierus.paino < vierus.dist) {
                    vierus.dist = nyk.dist+vierus.paino;
                    
                    /* Koska keossa jo olevien solmujen arvoja ei voi muuttaa, lisätään kekoon
                    uusi olio. Luodaan muutettava solmu uudestaan uudella distance-arvolla. */
                    keko.add(new Dijkstra(vierus.id, vierus.paino, vierus.dist));
                        
                    reitti[vierus.id]=nyk.id; 
                }
            }
        }

        tulostaReitti(reitti, alku, loppu);        
    }
    

    /* Tulostetaan lyhin reitti alkusolmusta loppusolmuun */
    public static void tulostaReitti(int[] reitti, int alku, int loppu) {
        
        int u = reitti[loppu]; //u on sen solmun indeksi, josta viimeiseen solmuun kuljettiin

        Stack<Integer> print = new Stack();
        
        //siirrytään reitti-taulukossa taaksepäin niin kauan, kunnes tullaan alkusolmuun
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