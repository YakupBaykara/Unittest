package com.yb.unittest.assertj;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.contentOf;

import java.io.File;

import org.junit.jupiter.api.Test;

import com.yb.unittest.customer.MailServerUnavailableException;

public class CustomerFileTest {

    @Test
    public void testFiles() throws Exception {

        File file = new File("/Kullanıcı Bilgileri/test.txt");

        assertThat(file)
                .exists()
                .canRead()
                .canWrite()
                .hasExtension("txt")
                .hasName("test.txt");

        assertThat(contentOf(file))
                .startsWith("Lorem");

    }
    
    @Test
    public void testException() throws Exception {

        Exception exception = new MailServerUnavailableException("this is a test");

        assertThat(exception)
                .hasMessage("this is a test")
                .isInstanceOf(MailServerUnavailableException.class)
                .hasMessageContaining("is a");


    }
}
