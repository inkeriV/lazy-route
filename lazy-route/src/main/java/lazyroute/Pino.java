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

/* 

Pino-tietorakenteen toteutus array:lla. Pino-olioon kuuluu int array, joka toimii pinona sekä int koko,
jossa pidetään kirjaa siitä, kuinka monta alkiota listassa on.

Jos pinoon halutaan lisätä enemmän alkioita kuin mitä sinne mahtuu, luodaan uusi, kaksinkertainen array, jonka alkuun
kopioidaan täynnä oleva array, ja osoitetaan uusi array pino-olion arrayksi.

*/
public class Pino {
    
    public int[] pino; //pino-array
    public int koko; //pinon koko
    
    private static final int ALKU_KOKO = 1000; //alustetaan aluksi tuhanteen
    
    public Pino() {
        pino=new int[ALKU_KOKO];
        koko=0;
    }

    public static Pino createPino() {
        Pino pino = new Pino();
        return pino;
    }
    
    public void kasvataPinoa() { //kun pino tulee täyteen
        int pituus = pino.length;
        int[] uusi=new int[pituus*2];

        for (int i=0; i<pituus; i++) { 
            uusi[i]=pino[i];
        }
        pino = uusi;
    }
    
    public void addPinoon(int arvo) { 
        if (koko == pino.length) {
            kasvataPinoa();
        }
        pino[koko]=arvo;
        koko++;
    }
    
    public int popPino() {
        koko--;
        return pino[koko];
    }
    
    public boolean isEmpty() {
        if (koko==0) {
            return true;
        }
        return false;
    }
  
}
