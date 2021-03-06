package com.google.codejam._2018.q;

import com.utils.FileLoader;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Solution1Test {


    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream printStream = new PrintStream(outContent);

    @Before
    public void before() {
        System.setOut(printStream);
    }

    @Test
    public void init() {

        ByteArrayInputStream in = new ByteArrayInputStream(FileLoader.get("google/codejam/_2018/q/solution1/init.in").getBytes());
        System.setIn(in);

        Solution1.main(null);

        assertThat(outContent.toString(), is(FileLoader.get("google/codejam/_2018/q/solution1/init.out")));

    }


}