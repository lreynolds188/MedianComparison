package testCases;

import org.junit.*;

import static org.junit.Assert.assertEquals;

import medianAlgorithms.*;

public class TestBruteForceAlgorithm {

    @Before@Test
    public void test(){
        assertEquals(4, Algorithms.BruteForceMedian(new int[]{1, 3, 4, 6, 7}));
        assertEquals(3, Algorithms.BruteForceMedian(new int[]{1, 3, 4, 6}));
        assertEquals(4, Algorithms.BruteForceMedian(new int[]{1, 3, 4, 4, 7, 9}));
        assertEquals(9, Algorithms.BruteForceMedian(new int[]{1, 3, 4, 4, 7, 9, 20, 1, 1, 1, 1}));
    }

}
