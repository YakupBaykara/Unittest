package com.yb.unittest.hamcrest;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.either;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;

public class HamcrestTest {
	
    @SuppressWarnings("deprecation")
	@Test
    public void testTemelEslestirmeler() throws Exception {

        String text1 = "Baris";
//        String text2 = "Baris2";

        assertEquals("Baris", text1);

        assertThat(text1, is(equalTo("Baris")));

        assertThat(text1, is(notNullValue()));

        assertThat(text1, containsString("ris"));

        assertThat(text1, anyOf(containsString("ris"), containsString("Bar")));
    }
    
    @SuppressWarnings("deprecation")
	@Test
    public void testListeler() throws Exception {

        List<String> sehirler = new ArrayList<String>(Arrays.asList("Istanbul", "Ankara", "Izmir"));

        assertThat(sehirler, hasItem("Istanbul"));

        assertThat(sehirler, hasItems("Istanbul", "Izmir"));

        assertThat(sehirler, allOf(hasItems("Istanbul", "Izmir"), not(hasItem("Bursa"))));

        assertThat(sehirler, either(hasItems("Istanbul", "Izmir")).or((Matcher<? super Iterable<String>>) not(hasItem("Bursa"))));

    }

}
