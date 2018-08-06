/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import lazyroute.Dijkstra;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vbinkeri
 */
public class DijkstraTest {
    
    Dijkstra koe;
    
    @Before
    public void setUp() {
        koe = new Dijkstra(1,2,3);
    }
    
    @Test
    public void setIdToimii() {
        koe.setId(2);
        assertEquals(2,koe.id);
    }
    @Test
    public void setPainoToimii() {
        koe.setPaino(333);
        assertEquals(333,koe.paino);
    }
    @Test
    public void setDistToimii() {
        koe.setDist(2000);
        assertEquals(2000,koe.dist);
    }
    @Test
    public void getIdToimii() {
        assertEquals(1,koe.getId());
    }
    @Test
    public void getPainoToimii() {
        assertEquals(2,koe.getPaino());
    }
    @Test
    public void getDistToimii() {
        assertEquals(3,koe.getDist());
    }
    @Test
    public void toimiikoGetIdSetIdnJalkeen() {
        koe.setId(33);
        assertEquals(koe.id,koe.getId());
    }
    @Test
    public void toimiikoGetPainoSetPainonJalkeen() {
        koe.setPaino(44);
        assertEquals(koe.paino,koe.getPaino());
    }
    @Test
    public void toimiikoGetDistSetDistJalkeen() {
        koe.setDist(1000000);
        assertEquals(koe.dist, koe.getDist());
    }
    @Test
    public void toStringToimii() {
        assertEquals("1, 2, 3", koe.toString());
    }
    @Test
    public void compareToToimii() {
        Dijkstra vertaa = new Dijkstra(7,7,7);
        Dijkstra sama = new Dijkstra(1,2,3);
        
        assertEquals(-1,koe.compareTo(vertaa));
        
        assertEquals(1,vertaa.compareTo(koe));
        
        assertEquals(0, sama.compareTo(koe));
    }
}
