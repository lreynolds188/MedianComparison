package testCases;

import org.junit.*;

import static org.junit.Assert.assertEquals;

import medianAlgorithms.*;

public class TestBruteForceAlgorithm {

    @Test
    public void testBasicCase() throws Exception{
        assertEquals(4, BruteForceAlgorithm.BruteForceMedian(new int[]{1, 3, 4, 6, 7}));
        assertEquals(3, BruteForceAlgorithm.BruteForceMedian(new int[]{1, 3, 4, 6}));
        assertEquals(4, BruteForceAlgorithm.BruteForceMedian(new int[]{1, 3, 4, 4, 7, 9}));
        assertEquals(0, BruteForceAlgorithm.BruteForceMedian(new int[]{0, 0, 0, 0, 0, 0, 0}));
    }

    @Test
    public void testEdgeCases() throws Exception{
        assertEquals(1, BruteForceAlgorithm.BruteForceMedian(new int[]{1}));
        assertEquals(8, BruteForceAlgorithm.BruteForceMedian(new int[]{8}));

        assertEquals(1, BruteForceAlgorithm.BruteForceMedian(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}));
        assertEquals(4, BruteForceAlgorithm.BruteForceMedian(new int[]{1, 1, 1, 1, 8, 8, 8, 8, 4}));
    }

    @Test (expected = Exception.class)
    public void testEmptyCase() throws Exception{
        BruteForceAlgorithm.BruteForceMedian(new int[]{});
    }

    @Test
    public void testOperationCount() throws Exception{
        assertEquals(5, BruteForceAlgorithm.BruteForceMedian(new int[]{1, 2, 3, 4, 5}));
    }



}
