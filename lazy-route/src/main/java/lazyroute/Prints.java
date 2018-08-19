/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lazyroute;

import java.util.ArrayList;
import static lazyroute.Pino.createPino;

/**
 *
 * @author inkeriv
 */

/*

Luokka tulostusmetodeja varten.

*/
public class Prints {
    
    public static void printVieruslista(ArrayList<Node>[] vl) {
        for (int i=1; i<vl.length; i++) {
            System.out.println(i+ " => ");
            for (Node solmu: vl[i]) {
                System.out.println(solmu);
            }
        }
    }
    
    public static void printVerkko(int[][] verkko) {
        for (int i=0; i<verkko.length; i++) {
            for (int j=0; j<verkko[i].length; j++) {
                System.out.print(verkko[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    public static void printSolmut(Node[] lista) {
        for (Node solmu:lista) {
            System.out.println(solmu);
        }
    }
    
    /* Tulostetaan lyhin reitti alkusolmusta loppusolmuun */
    public static void tulostaReitti(int[] reitti, int alku, int loppu) {

        int u = reitti[loppu-1]; //u on sen solmun indeksi, josta viimeiseen solmuun kuljettiin

        Pino pino = createPino();
        
        //siirrytään reitti-taulukossa taaksepäin niin kauan, kunnes tullaan alkusolmuun
        while (u != alku-1) { 
            pino.addPinoon(u);
            u = reitti[u]; 
        }
        
        System.out.print(alku+" -> ");
        
        while (!pino.isEmpty()) { 

            u=pino.popPino();
            System.out.print(u+1 + " -> ");
        }
        System.out.println(loppu);
    }
    
    /* Reitti taulukon tulostus, tämä metodi lähinnä koodin toimivuuden tarkastelua varten.
    Tulostaa solmun indeksin ja sen solmun, josta kyseiseen solmuun oli lyhin matka. */
    public void tulostaReittiTaulukko(int[] reitti ) {
        int luku=0;
        for (int i:reitti) {
            System.out.println(luku+": "+i);
            luku++;
        }
    }
}