package com.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class SortingAppTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testSortingWithValidInput() {
        String[] args = {"3", "1", "2"};
        SortingApp.main(args);
        assertEquals("Sorted numbers: [1, 2, 3]", outContent.toString().trim());
    }

    @Test
    public void testSortingWithNoInput() {
        String[] args = {};
        SortingApp.main(args);
        assertEquals("No numbers provided.", outContent.toString().trim());
    }

    @Test
    public void testSortingWithSingleNumber() {
        String[] args = {"42"};
        SortingApp.main(args);
        assertEquals("Sorted numbers: [42]", outContent.toString().trim());
    }

    @Test
    public void testSortingWithMixedInput() {
        String[] args = {"7", "3", "10", "2"};
        SortingApp.main(args);
        assertEquals("Sorted numbers: [2, 3, 7, 10]", outContent.toString().trim());
    }

    @Test
    public void testSortingWithNonNumericInput() {
        String[] args = {"a", "b", "c"};
        SortingApp.main(args);
        assertEquals("Error: One or more arguments are not valid integers.", outContent.toString().trim());
    }
}
