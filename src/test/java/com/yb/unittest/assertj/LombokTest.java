package com.yb.unittest.assertj;

import org.junit.jupiter.api.Test;

public class LombokTest {

    @Test
    public void testLombok() throws Exception {

        Gift gift = Gift.builder().name("baris").build();
        System.out.println(gift.toString());
    }
}
