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

/*Käsiteltävän verkon luonti. Ei lopullinen verkkojen presentaatio.*/
public class Verkko {
    
            public static void teeLista() {
            Dijkstra[] lista = new Dijkstra[9];
            lista[0]=new Dijkstra(0,3,100); lista[1]=new Dijkstra(1,4,100);
            lista[2]=new Dijkstra(2,5,100); lista[3]=new Dijkstra(3,4,100);
            lista[4]=new Dijkstra(4, 6, 100); lista[5]=new Dijkstra(5, 4, 100);
            lista[6]=new Dijkstra(6, 3, 100); lista[7]=new Dijkstra(7, 3, 100);
            lista[8]=new Dijkstra(8, 3, 100); 
            
            //vieruslista
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

            int a=0;
            int l=8;
            Dijkstra.dijkstra(lista, vl, a, l);    
        }
              
        public static void main(String[] args) {
            teeLista();
        } 
}
