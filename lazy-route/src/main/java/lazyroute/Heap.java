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

/*Itse tekemä, arrayta käyttävä tietokanta minimikeolle, joka voi ottaa mitä tahansa tietotyyppiä. Kesken.*/
public class Heap<T extends Comparable<T>> {
    
    private T[] keko;
    private T t;
    private int pituus; //listan pituus
    private int koko; //kuinka monta alkiota
    
    /*public Heap(T[] keko, T t, int pituus, int koko) {
        this.t=t;
        this.keko=keko;
        this.pituus=pituus;
        this.koko=koko;
    }*/
    
    public Heap() {
    }
    
    //Keon luonti
    public void createHeap(T[] lista)  {
        keko = (T[]) new Comparable[lista.length+2];
        pituus = keko.length;
        koko = lista.length;
        for(int i=0; i<lista.length; i++) {
            keko[i+1]=lista[i];
        }
        heapify(keko);
    }
    
    //Minimikekorakenteen ylläpito
    public void heapify(T[] keko) {
        //pitää olla get vasen,oikea lapsi
        //comparator, miten vertaan, 
        //kun nodessa id ja distance?
    }
    
    //Pienimmän arvon poisto & pinon lyhennys
    public T popMin(T[] keko) {
        T palauta = keko[1];
        keko[1] = keko[koko];
        
        //hmm, pitääkö tosiaan luoda aina uusi lista, 
        //pystyy vähentämään kekoa, kun siitä popataan
        //alkioita pois??
        pituus--; koko--;
        T[] uusikeko = (T[]) new Comparable[pituus-1];
        for (int i=1; i<=koko; i++) {
            uusikeko[i]=keko[i];
        }
        heapify(uusikeko);
        return palauta;
    }

}
