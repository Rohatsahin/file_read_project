package com.app.util;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class ProcessUtilTest {

    @Test
    public void shouldMakeEncodeGivenString() {
        String test[] = {"string", "test"};

        assertThat(ProcessUtil.process(test, 0), equalTo("word is even : gnirts"));
        assertThat(ProcessUtil.process(test, 1), equalTo("word is odd : test"));
    }
}