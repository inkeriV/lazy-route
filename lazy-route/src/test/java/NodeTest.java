/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import lazyroute.Node;
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
public class NodeTest {
    
    Node solmu;
    
    @Before
    public void setUp() {
        solmu = new Node(1,4,5);
    }
    
    @Test
    public void solmunLuonti() {
        assertEquals(1,solmu.id);
        assertEquals(4,solmu.paino);
        assertEquals(5,solmu.dist);
    }
    
    @Test
    public void arvojenVaihtoId() {
        solmu.id=44;
        assertEquals(44,solmu.id);
    }
    @Test
    public void arvojenVaihtoPaino() {
        solmu.paino=100001;
        assertEquals(100001,solmu.paino);
    }
    @Test
    public void arvojenVaihtoDist() {
        solmu.dist=4665;
        assertEquals(4665,solmu.dist);
    }
    @Test
    public void toimiikoToSTring() {
        assertEquals("1, 4, 5",solmu.toString());
        solmu.id=77777;
        assertEquals("77777, 4, 5", solmu.toString());
    }
    @Test
    public void toimiikoCompareTo() {
        Node uusi = new Node(3,3,3);
        assertEquals(-1,uusi.compareTo(solmu));
        uusi.paino=7;
        assertEquals(1,uusi.compareTo(solmu));
        solmu.dist++;
        assertEquals(0,uusi.compareTo(solmu));
        solmu.dist--;
        assertEquals(-1,solmu.compareTo(uusi));     
    }   
}
