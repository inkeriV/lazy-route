/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lazyroute;

/**
 *
 * @author inkeriv
 */

/*Käsiteltävän verkon luonti. Ei lopullinen verkkojen presentaatio.*/
public class Verkko {
    
    public static void main(String[] args){   
        int[][] verkko = alusta();
        int alku = 0; int loppu = 99;
        dijkstra(verkko, alku, loppu);
    }
    
    
    public static void dijkstra(int[][] verkko, int alku, int loppu){
        int[][] vlista = vieruslista(verkko);     
    }
    
    
    /*Tässä testiversiossa yhteyden ja painot randomilla*/
    public static int[][] alusta(){
        int[][] verkko = new int[100][100];
        
        for (int i = 0; i < 100; i++){
            for (int j = 0; j < i; j++){
                if (Math.random() < 0.2){
                    verkko[i][j] = (int)Math.floor(Math.random()*100);
                    verkko[j][i] = verkko[i][j];
                }else{
                    verkko[i][j] = 0; verkko[j][i] = 0;
                }
            }
        }
        tulostaVerkko(verkko);
        return verkko;
    }
    
    //vieruslista atm matriisina
    public static int[][] vieruslista(int[][] verkko){
        int[][] vlista = new int[100][50];
        
        for (int i = 0; i < 100; i++){
            for (int j = 0; j< 100; j++){
                vlista[i][j] = 0;
            }
        }
        
        for (int i = 0; i < 100; i++){
            int apu = 0;
            for (int j = 0; j< 100; j++){
                if (verkko[i][j]!=0){
                    vlista[i][apu]=j;
                    apu++;
                }
            }
        }
        return vlista;
    }
    
    //verkon tulostus, tulostaa solmu1 -> solmu2, ja niiden välisen painon
    public static void tulostaVerkko(int[][] graph){

        for (int i = 0; i < 100; i++){
            for (int j = 0; j < 100; j++){
                System.out.println(i + " -> " + j + ": " + graph[i][j]);
            }
        }
    }
}
