/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lazyroute;

import java.util.ArrayList;

/**
 *
 * @author inkeriv
 */


public class Verkko {
     
    /* Verkon luonti. Tällä hetkellä vain Dijkstran algoritmille.
    
    Dijkstran toimivuutta kokeillakseni verkko on vielä suoraa valmiina kirjoitettuna ilman
    kummallisempia luomismetodeja. Verkko on m*n ruudukko, jossa solmujen paino kuvaa hankaluutta
    siirtyä kyseiseen solmuun. Solmut ovat Dijkstra-olioita joilla id(=listojen indeksi), 
    paino(= ns. kaaren paino / kulun hankaluus) ja dist(=dijkstran tarvitsema etäisyys alkusolmusta).
    
    Koska verkko on ruudukko, vierussolmut menee niin, että kulmilla on kaksi vierusta, reunasolmuilla
    kolme ja muilla 4. Tarkoitus olisi myöhemmin saada kirjoitettua sellaisen metodit, jotka saa vain
    listan solmujen painoista ja alku- ja loppusolmun, ja metodi osaa itse tehdä oliot ja vieruslistan.
    
    Verkko (solmujen painot):               Verkko (solmujen järjestys):
    3   -   4   -   5                       0   -   1   -   2
    |       |       |                       |       |       |
    4   -   6   -   4                       3   -   4   -   5    
    |       |       |                       |       |       |
    3   -   3   -   3                       6   -   7   -   8
    
    aloitussolmu on 0, painona 3
    maalisolmu on 8, painona 3
    
    kevyin reitti on 0 -> 3 -> 6 -> 7 -> 8
    
    */
    
    public static void teeLista() {
        
        /* Solmu-oliot listaan */
        
        Dijkstra[] lista = new Dijkstra[9];
        lista[0]=new Dijkstra(0,3,100); lista[1]=new Dijkstra(1,4,100);
        lista[2]=new Dijkstra(2,5,100); lista[3]=new Dijkstra(3,4,100);
        lista[4]=new Dijkstra(4, 6, 100); lista[5]=new Dijkstra(5, 4, 100);
        lista[6]=new Dijkstra(6, 3, 100); lista[7]=new Dijkstra(7, 3, 100);
        lista[8]=new Dijkstra(8, 3, 100); 
            
        
        /* Vieruslistan luonti */
        
        ArrayList[] vl = new ArrayList[10];
        for (int i=1; i<=lista.length; i++) {
            vl[i]= new ArrayList<Dijkstra>(); 
        }
        vl[1].add(lista[1]); vl[1].add(lista[3]); 
        vl[2].add(lista[0]); vl[2].add(lista[4]); vl[2].add(lista[2]);
        vl[3].add(lista[1]); vl[3].add(lista[5]); 
        vl[4].add(lista[0]); vl[4].add(lista[4]); vl[4].add(lista[6]);
        vl[5].add(lista[1]); vl[5].add(lista[3]); vl[5].add(lista[5]); vl[5].add(lista[7]);
        vl[6].add(lista[2]); vl[6].add(lista[4]); vl[6].add(lista[8]);
        vl[7].add(lista[3]); vl[7].add(lista[7]);
        vl[8].add(lista[6]); vl[8].add(lista[4]); vl[8].add(lista[8]);
        vl[9].add(lista[5]); vl[9].add(lista[7]);

        int a=0; //alkusolmu
        int l=8; //loppusolmu
        
        // Kutsutaan dijkstraa, joka saa listan olioista, vieruslistan ja alku- ja loppusolmun
        Dijkstra.dijkstra(lista, vl, a, l);    
    }
              
    public static void main(String[] args) {
        //teeLista();
        AStar.alustus(new int[]{1,3,3,4,4,4,5,5,5,2,2,1,4,2,5,3}, 1, 1, 4, 4);
    } 
}
