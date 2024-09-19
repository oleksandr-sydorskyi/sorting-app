package com.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SortingAppParameterizedTest {

    private final String[] input;
    private final String expectedOutput;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    public SortingAppParameterizedTest(String[] input, String expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][] {
                {new String[] {"3", "2", "1"}, "Sorted numbers: [1, 2, 3]"},
                {new String[] {}, "No numbers provided."},
                {new String[] {"5"}, "Sorted numbers: [5]"},
                {new String[] {"10", "20", "15"}, "Sorted numbers: [10, 15, 20]"}
        };
    }

    @Test
    public void testSorting() {
        SortingApp.main(input);
        assertEquals(expectedOutput, outContent.toString().trim());
    }
}
