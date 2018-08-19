/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import lazyroute.Pino;
import static lazyroute.Pino.createPino;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author inkeriv
 */
public class PinoTest {
    
    Pino p;
    
    @Before
    public void setUp() {
        p = createPino();
    }
    
    @Test
    public void pinonLuominenOnnistuu() {
        Pino koe = createPino();
        assertEquals(0,koe.koko);
        assertEquals(1000,koe.pino.length);
    }
    
    @Test
    public void indeksiKasvaaOikein() {
        assertEquals(0,p.koko);
        p.addPinoon(5);
        assertEquals(1,p.koko);
    }
    
    @Test
    public void indeksiKasvaaOikeinKunKokoaPitaaKasvattaa() {
        for (int i=0; i<2240; i++) {
            p.addPinoon(i+12);
        }
        assertEquals(2240, p.koko);
    }
    
    @Test
    public void pinonKokoKasvaaOikeinKunKokoaPitaaKasvattaa() {
        for (int i=1; i<2240; i++) {
            p.addPinoon(i*3);
        }
        assertEquals(4000, p.pino.length);
    }
    
    @Test
    public void indeksiVaheneeOikein() {
        p.addPinoon(44);
        p.addPinoon(11);
        int h = p.popPino();
        assertEquals(1,p.koko);
    }
    
    @Test
    public void indeksiVaheneeOikeinSuurillaArvoilla() {
        for (int i=0; i<2383; i++) {
            p.addPinoon(i+9);
        }
        for (int i=0; i<1168; i++) {
            p.popPino();
        }
        assertEquals(1215,p.koko); //indeksi
    }
    
    @Test
    public void popToimii() {
        p.addPinoon(111);
        int h = p.popPino();
        assertEquals(111,  h);
    }
    
    @Test
    public void popToimiiSuuremmillaLuvuilla() {
        for (int i=0; i<2383; i++) {
            p.addPinoon(i+12);
        }
        int h = p.popPino();
        assertEquals(2394,h);
    }
    
    @Test
    public void toimiikoIsEmpty() {
        assertEquals(true, p.isEmpty());
        p.addPinoon(3);
        assertEquals(false, p.isEmpty());
        int h=p.popPino();
        assertEquals(true, p.isEmpty());
    }
    
    
}
