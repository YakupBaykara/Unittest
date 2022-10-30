package com.yb.unittest.junit;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

public class IgnoreTest {

    @Test
    public void testMerhaba() throws Exception {
        System.out.println("Merhaba");
    }

    @Test
    @Ignore("Bu method daha sonra kullanilacak")
    public void testMerhaba2() throws Exception {
        System.out.println("Merhaba 2");
    }
}
