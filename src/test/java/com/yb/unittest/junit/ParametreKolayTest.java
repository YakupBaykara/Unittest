package com.yb.unittest.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runners.Parameterized.Parameters;

import com.yb.unittest.ornek.HesapMakinesi;

//@RunWith(JUnitParams.class)
public class ParametreKolayTest {

    private HesapMakinesi hesapMakinesi = new HesapMakinesi();

    @Test
    @Parameters //({"10,2,20", "20,3,60"}) 
    public void testMetreKareHesaplama(int eni, int boyu, int toplamMetreKare) throws Exception {

        assertEquals(toplamMetreKare, hesapMakinesi.metreKareHesapla(eni, boyu));

    }
}
