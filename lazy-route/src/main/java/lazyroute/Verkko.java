/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lazyroute;

import java.util.ArrayList;
import static lazyroute.Prints.printVieruslista;

/**
 *
 * @author inkeriv
 */


public class Verkko {
    
    //alkusolmun koordinaatit
    private int ai;
    private int aj;

    //loppusolmun koordinaatit
    private int li;
    private int lj;
    
    //"ääretön"-arvo
    static int infi=1000000000;
    
    public int[] solmut;
    public int a;
    public int l;
    public int m;
    public int n;
    public String alg;
    
    public Verkko (int[] s, int alku, int loppu, int lev, int pit, String al) {
        solmut = s;
        a = alku;
        l = loppu;
        m = lev;
        n = pit;
        alg = al;
    }
     
    //verkkojen luonti
    //public void alustus(int[] solmut, int a, int l, int m, int n, String alg) {
    public void alustus() {
        Node[] lista = new Node[solmut.length] ;
        int[][] verkko = new int[m][n];
        
        
        //lista solmuista, painot
        int luku=0;
        for (int j=0; j<m; j++) {
            for (int i=0; i<n; i++) {
                
                //alkusolmun koordinaatit
                if (luku==a-1) {
                    ai=i;
                    aj=j;
                }
                
                //loppusolmun koordinaatit
                if (luku==l-1) {
                    li=i;
                    lj=j;
                }
                
                verkko[i][j] = solmut[luku];
                luku++;
            }
        }

        ArrayList<Node>[] vl = new ArrayList[solmut.length+1];
        for (int i=1; i<=solmut.length; i++) {
            vl[i]=new ArrayList<Node>();
        }
        //VIERUSLISTA
        
        if (alg=="a" || alg=="A") {
            int x = 1;
            lista[x]=new Node(x,infi,h(1,0,li,lj));
            for (int j=0; j<n; j++) {
                for (int i=0; i<m; i++) {

                    //Solmu-oliot listaan (täällä lista[1] jää null)
                    if (lista[x-1]==null) {
                        lista[x-1]=new Node(x-1, infi,h(i,j,li,lj));
                    }

                    if (i==1 && j==0){
                        //vasen yläkulma
                        vl[x].add(new Node(1,infi,h(1,0,li,lj))); //seuraava solmu
                        vl[x].add(new Node(m,infi,h(0,1,li,lj))); //alempi solmu
                        x++;

                    }
                    if (i==m-1 && j==0){
                        //oikea yläkulma
                        vl[x].add(new Node(m-2,infi,h(m-2,0,li,lj))); //edellinen solmu
                        vl[x].add(new Node((m*2)-1,infi,h(m-1, 1,li,lj))); //alempi solmu
                        x++;

                    }
                    if (x==m*(n-1)+1 && j==n-1) {
                        //vasen alakulma
                        vl[x].add(new Node(m*(n-2),infi,h(0, n-1, li, lj))); //ylempi solmu
                        vl[x].add(new Node(m*(n-1)+1,infi,h(1,j,li,lj))); //seuraava solmu
                        x++;
                    }
                    if (x==m*n && j==n) {
                        //oikea alakulma
                        vl[x].add(new Node(m*(n-1)-1,infi,h(0,n-2,li,lj))); //ylempi solmu
                        vl[x].add(new Node(m*n-2,infi,h(m-2, n-1, li, lj))); //edeltävä solmu
                        x++;
                    }


                    //Verkon reunoilla olevat solmut (ei kulmasolmut)
                    if (j==0 && vl[x].isEmpty() && i!=0 && i!=m-1) { 
                        //yläreuna
                        vl[x].add(new Node(x-2,infi,h(i-1,j,li,lj))); //edeltävä 
                        vl[x].add(new Node(i+m, infi,h(i,j+1,li,lj))); //alla oleva
                        vl[x].add(new Node(x,infi,h(x,j,li,lj))); //seuraava
                        x++;

                    }
                    if (i==0 && vl[x].isEmpty() && j!=0 && j!=n-1) { 
                        //vasen reuna
                        vl[x].add(new Node(x-m-1,infi,h(i,j-1,li,lj))); //ylempi 
                        vl[x].add(new Node(x,infi,h(i+1,j,li,lj))); //seuraava
                        vl[x].add(new Node(x+m-1,infi,h(i,j+1,li,lj))); //alempi
                        x++;

                    }
                    if (i==m-1 && vl[x].isEmpty() && j!=0 && j!=n-1) { 
                        //oikea reuna
                        vl[x].add(new Node(x-m-1,infi,h(i,j-1,li,lj))); //ylempi
                        vl[x].add(new Node(x-2,infi,h(i-1,j,li,lj))); //edellinen
                        vl[x].add(new Node(x+m-1,infi,h(i,j+1,li,lj))); //alempi
                        x++;

                    }
                    if (j==n-1 && vl[x].isEmpty() && i!=0 && i!=m-1) { 
                        //alareuna
                        vl[x].add(new Node(x-2,infi,h(i-1,j,li,lj))); //edellinen
                        vl[x].add(new Node(x-m-1,infi,h(i,j-1,li,lj))); //ylempi
                        vl[x].add(new Node(x,infi,h(i+1,j,li,lj)));//seuraava
                        x++;


                    // Muut solmut, joilla 4 vierussolmua
                    } else if (j!=0 && j!=n-1 && i!=0 && i!=m-1){
                        vl[x].add(new Node(x-m-1,infi,h(i,j-1,li,lj))); //ylä
                        vl[x].add(new Node(x+m-1,infi,h(i,j+1,li,lj))); //ala
                        vl[x].add(new Node(x-2,infi,h(i-1,j,li,lj))); //edellinen
                        vl[x].add(new Node(x,infi,h(i+1,j,li,lj))); //oikea
                        x++;

                    }
                }
            }
        }
        //Vieruslista Dijkstralle
        if (alg == "d" || alg == "D") {
            int x = 1;
            lista[x]=new Node(x,solmut[x],infi);
            for (int j=0; j<n; j++) {
                for (int i=0; i<m; i++) {

                    //Solmu-oliot listaan (täällä lista[1] jää null)
                    if (lista[x-1]==null) {
                        lista[x-1]=new Node(x-1, solmut[x-1],infi);
                    }

                    if (i==1 && j==0){
                        //vasen yläkulma
                        vl[x].add(new Node(1,solmut[1],infi)); //seuraava solmu
                        vl[x].add(new Node(m,solmut[m],infi)); //alempi solmu
                        x++;

                    }
                    if (i==m-1 && j==0){
                        //oikea yläkulma
                        vl[x].add(new Node(m-2,solmut[m-2],infi)); //edellinen solmu 
                        vl[x].add(new Node((m*2)-1,solmut[m*2-1], infi)); //alempi solmu
                        x++;

                    }
                    if (x==m*(n-1)+1 && j==n-1) {
                        //vasen alakulma
                        vl[x].add(new Node(m*(n-2),solmut[m*(n-2)], infi)); //ylempi solmu
                        vl[x].add(new Node(m*(n-1)+1,solmut[m*(n-1)], infi)); //seuraava solmu
                        x++;
                    }
                    if (x==m*n && j==n) {
                        //oikea alakulma
                        vl[x].add(new Node(m*(n-1)-1,solmut[m*(n-1)], infi)); //ylempi solmu
                        vl[x].add(new Node(m*n-2,solmut[m*n-2], infi)); //edeltävä solmu
                        x++;
                    }


                    //Verkon reunoilla olevat solmut (ei kulmasolmut)
                    if (j==0 && vl[x].isEmpty() && i!=0 && i!=m-1) { 
                        //yläreuna
                        vl[x].add(new Node(x-2,solmut[x-2], infi)); //edeltävä 
                        vl[x].add(new Node(i+m, solmut[i+m], infi)); //alla oleva
                        vl[x].add(new Node(x,solmut[x], infi)); //seuraava
                        x++;

                    }
                    if (i==0 && vl[x].isEmpty() && j!=0 && j!=n-1) { 
                        //vasen reuna
                        vl[x].add(new Node(x-m-1,solmut[x-m-1], infi)); //ylempi 
                        vl[x].add(new Node(x,solmut[x], infi)); //seuraava
                        vl[x].add(new Node(x+m-1,solmut[x+m-1], infi)); //alempi
                        x++;

                    }
                    if (i==m-1 && vl[x].isEmpty() && j!=0 && j!=n-1) { 
                        //oikea reuna
                        vl[x].add(new Node(x-m-1,solmut[x-m-1], infi)); //ylempi
                        vl[x].add(new Node(x-2,solmut[x-2], infi)); //edellinen
                        vl[x].add(new Node(x+m-1,solmut[x+m-1], infi)); //alempi
                        x++;

                    }
                    if (j==n-1 && vl[x].isEmpty() && i!=0 && i!=m-1) { 
                        //alareuna
                        vl[x].add(new Node(x-2,solmut[x-2], infi)); //edellinen
                        vl[x].add(new Node(x-m-1,solmut[x-m-1], infi)); //ylempi
                        vl[x].add(new Node(x,solmut[x], infi));//seuraava
                        x++;


                    // Muut solmut, joilla 4 vierussolmua
                    } else if (j!=0 && j!=n-1 && i!=0 && i!=m-1){
                        vl[x].add(new Node(x-m-1,solmut[x-m-1], infi)); //ylä
                        vl[x].add(new Node(x+m-1,solmut[x+m-1], infi)); //ala
                        vl[x].add(new Node(x-2,solmut[x-2], infi)); //edellinen
                        vl[x].add(new Node(x,solmut[x], infi)); //oikea
                        x++;

                    }
                }
            }
        }
        //printVieruslista(vl);
        FindPath.shortestPath(lista, vl, a, l, alg, solmut);
    }
    
    
    public int h( int ai, int aj, int bi, int bj) { 
        int lop = Math.abs(ai-bi)+Math.abs(aj-bj);
        return lop;
    }


    public static void main(String[] args) {
        
        //ohjelman suoritus netbeanssissä
        //alustus(new int[]{1,3,3,4,4,4,5,5,5,2,2,1,4,3,5,3}, 1, 12, 4, 4, "a");
        
        //Verkko koe=new Verkko(new int[]{1,1,1,1,2,3,2,1,2,3,1,2,3,4,2,4,1,1,1,1,1,2,1,2,1,4,2,4,2,4,2,1,2,2,1,1},1,35,6,6,"a");
        //koe.alustus();
        
        // /*
        Verkko koe=new Verkko(new int[]{1,2,2,2,2,2,9,9,9,7,
                                        3,3,3,4,3,4,3,2,1,2,
                                        5,5,5,5,6,6,6,7,3,1,
                                        3,4,4,4,4,4,2,2,1,1,
                                        7,7,7,7,3,3,2,1,5,3,
                                        1,2,2,2,2,2,9,9,9,7,
                                        3,3,3,4,3,4,3,2,1,2,
                                        5,5,5,5,6,6,6,7,3,1,
                                        3,4,4,4,4,4,4,4,4,2,
                                        2,1,1,7,7,7,7,3,3,2 }, 1, 99, 10,10,"d");
        koe.alustus();
        // */
        
        //alla oleva toimii kun käynnistetään komentoriviltä
        
        
        //Komentorivikutsu: mvn compile exec:java -Dexec.mainClass=lazyroute.Verkko 
        //                -Dexec.args="1,1,1,1,2,3,2,1,2,3,1,2,3,4,2,4,1,1,1,1,1,2,1,2,1,4,2,4,2,4,2,1,2,2,1,1, 1 35 6 6 d"
        
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

        Verkko koe=new Verkko(lista, alkusolmu, loppusolmu, m, n, algoritmi);
        koe.alustus();
        */
        
    }  
}
