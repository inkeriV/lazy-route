/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import lazyroute.Node;
import lazyroute.Verkko;
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
public class VerkkoTest {
    
    Verkko testi;
    
    @Before
    public void setUp() {
        int[] painot = new int[]{4,3,2,1,1,2,3,4,3,4,2,1,1,4,2,3};
        testi = new Verkko(painot, 1,16,4,4,"d");
    }    
    
    @Test
    public void toimiikoH() {
        assertEquals(1,testi.h(2,1,1,1));
        assertEquals(7,testi.h(1,2,7,3));
    }
}
