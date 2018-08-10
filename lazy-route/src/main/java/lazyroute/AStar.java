/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lazyroute;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 *
 * @author inkeriv
 */
public class AStar {
    
    /* Tällä hetkellä aika paljon samaa kuin Dijkstrassa. Kuhan saan A-tähden toimimaan
    niin katon, jos molemmat pärjäisi samalla oliolla. A-tähdestä puuttuu tällä hetkellä
    h-funktio, joka laskee solmuille etäisyydet alku- ja loppusolmusta (sen takia olioilla
    atm vaan nollat noitten arvojen kohdalla).*/
    
    public int id;
    public int paino;
    public int alkuun;
    public int loppuun;
    
    //konstruktori oliolle    
    public AStar(int nid, int npaino, int nalkuun, int nloppuun) {
        id = nid;
        paino = npaino;
        alkuun = nalkuun;
        loppuun = nloppuun;
    }
    
    //Set-metodit etäisyyksien laskemiseen alku- ja loppusolmusta
    public void setPaino(int npaino) { this.paino = npaino; } //kato tarviiko ees tätä
    public void setAlkuun(int nalkuun) { this.alkuun = nalkuun; }
    public void setLoppuun(int nloppuun) { this.loppuun = nloppuun; }
    
    // yksittäisen solmun tulostusta varten
    @Override
    public String toString() {
        return  id+", "+paino+", "+alkuun+", "+loppuun;
    }
    
    //myöhemmin tee niin et dijkstra käyttää tätä kans
    public static void alustus(int[] solmut, int a, int l, int m, int n) {
        AStar[] lista = new AStar[solmut.length] ;
        int[][] verkko = new int[m][n];
        
        int luku=0;
        for (int j=0; j<m; j++) {
            for (int i=0; i<n; i++) {
                verkko[i][j] = solmut[luku];
                System.out.println("korrdinaati i: "+i+" j: "+j+" solmu:" +solmut[luku]);
                luku++;
            }
        }
        
        ArrayList[] vl = new ArrayList[solmut.length+1];
        for (int i=1; i<=solmut.length; i++) {
            vl[i]=new ArrayList<AStar>();
        }
        //VIERUSLISTA
        int x = 1;
        for (int j=0; j<n; j++) {
            for (int i=0; i<m; i++) {
                if (i==1 && j==0){
                    //vasen yläkulma
                    vl[x].add(new AStar(1,verkko[0][0],0,0)); //seuraava solmu
                    vl[x].add(new AStar(m,verkko[m-1][1],0,0)); //alempi solmu
                    x++;
                }
                if (i==m-1 && j==0){
                    //oikea yläkulma
                    vl[x].add(new AStar(m-2,verkko[m-2][0],0,0)); //edellinen solmu
                    vl[x].add(new AStar((m*2)-1,verkko[m-1][1],0,0)); //alempi solmu
                    x++;
                }
                if (x==m*(n-1)+1 && j==n-1) {
                    //vasen alakulma
                    vl[x].add(new AStar(m*(n-2),verkko[0][n-1],0,0)); //ylempi solmu
                    vl[x].add(new AStar(m*(n-1)+1,verkko[1][j],0,0)); //seuraava solmu
                    x++;
                }
                /*if (x==m*n && j==n) {
                    //oikea alakulma
                    vl[x].add(new AStar(m*(n-1)-1,verkko[m-1][n-1],0,0)); //ylempi solmu
                    vl[x].add(new AStar(m*n-2,verkko[m-2][n],0,0)); //edeltävä solmu
                    x++;
                }*/
                // reunat
                if (j==0 && vl[x].isEmpty() && i!=0 && i!=m-1) { 
                    //yläreuna
                    vl[x].add(new AStar(x-2,verkko[i-1][j],0,0)); //edeltävä TÄSSÄ OLI VIRKE verkko[i-1] -> -1
                    vl[x].add(new AStar(i+m, verkko[i][j+1],0,0)); //alla oleva
                    System.out.println(verkko[i-1][j]);
                    vl[x].add(new AStar(x,verkko[x][j],0,0)); //seuraava i on muka 4, eli kulma ei ole tullut?
                    x++;
                }
                if (i==0 && vl[x].isEmpty() && j!=0 && j!=n-1) { 
                    //vasen reuna
                    vl[x].add(new AStar(x-m-1,verkko[i][j-1],0,0)); //ylempi verkko[x-1-m][j]:-3,
                    vl[x].add(new AStar(x,verkko[i+1][j],0,0)); //seuraava
                    vl[x].add(new AStar(x+m-1,verkko[i][j+1],0,0)); //alempi
                    x++;

                }
                if (i==m-1 && vl[x].isEmpty() && j!=0 && j!=n-1) { 
                    //oikea reuna
                    vl[x].add(new AStar(x-m-1,verkko[i][j-1],0,0)); //ylempi
                    vl[x].add(new AStar(x-2,verkko[i-1][j],0,0)); //edellinen
                    vl[x].add(new AStar(x+m-1,verkko[i][j+1],0,0)); //alempi
                    x++;
                }
                if (j==n-1 && vl[x].isEmpty() && i!=0 && i!=m-1) { 
                    //alareuna
                    vl[x].add(new AStar(x-2,verkko[i-1][j],0,0)); //edellinen
                    vl[x].add(new AStar(x-m-1,verkko[i][j-1],0,0)); //ylempi
                    vl[x].add(new AStar(x,verkko[i+1][j],0,0));//seuraava
                    x++;
                    
                } else if (j!=0 && j!=n-1 && i!=0 && i!=m-1){
                    //keskisolmut
                    vl[x].add(new AStar(x-m-1,verkko[i][j-1],0,0)); //ylä
                    vl[x].add(new AStar(x+m-1,verkko[i][j+1],0,0)); //ala
                    vl[x].add(new AStar(x-2,verkko[i-1][j],0,0)); //edellinen
                    vl[x].add(new AStar(x,verkko[i+1][j],0,0)); //oikea
                    x++;
                }
            }
        }
        //oikea alakulma
        vl[n*m].add(new AStar(m*(n-1)-1,verkko[m-1][n-2],0,0)); //ylempi
        vl[n*m].add(new AStar(n*m-2,verkko[m-2][n-1],0,0)); //edellinen
        printVieruslista(vl);
        //printVerkko(verkko);
        
    }
    public static void printVieruslista(ArrayList<AStar>[] vl) {
        for (int i=0; i<vl.length; i++) {
            System.out.println(i +"=>"+ vl[i]);
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
    
    static PriorityQueue<AStar> keko = new PriorityQueue<AStar>();
    
    public void astar(AStar[] lista, ArrayList<AStar>[] vl, int a, int l) {
        
        boolean[] checked = new boolean[lista.length];
        int[] reitti = new int[lista.length];
        
        for (AStar solmu: lista) {
            solmu.alkuun=1000000000;
        }
        for (int i=0; i<lista.length; i++) {   
            checked[i]=false; 
        }
        
        while (checked[l]==false) {
            AStar nyk = keko.poll();
            checked[nyk.id]=true;
            
            for (AStar vierus: vl[nyk.id+1]) { 
               
                if (nyk.alkuun+vierus.paino  < vierus.alkuun) {
                    vierus.alkuun = nyk.alkuun+vierus.paino;
                    
                    keko.add(new AStar(vierus.id, vierus.paino, vierus.alkuun, vierus.loppuun));
                        
                    reitti[vierus.id]=nyk.id; 
                }
            }
        }
    }
}
