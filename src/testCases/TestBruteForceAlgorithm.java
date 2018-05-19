package testCases;

import org.junit.*;

import static org.junit.Assert.assertEquals;

import medianAlgorithms.*;

/**
 * @author Luke Reynolds
 * @version 1.0
 * @email lreynolds188@gmail.com
 * @website lukereynolds.net
 * @github https://github.com/lreynolds188
 */
public class TestBruteForceAlgorithm {

    @Test
    public void testBasicCase(){
        assertEquals(4, BruteForceAlgorithm.BruteForceMedian(new int[]{1, 3, 4, 6, 7}));
        assertEquals(4, BruteForceAlgorithm.BruteForceMedian(new int[]{4, 7, 6, 1, 3}));
        assertEquals(3, BruteForceAlgorithm.BruteForceMedian(new int[]{-1, -2, 3, 4, 7, 9}));
        assertEquals(3, BruteForceAlgorithm.BruteForceMedian(new int[]{7, 4, 9, 3, 1, 2}));
    }

    @Test
    public void testEdgeCases(){
        assertEquals(1, BruteForceAlgorithm.BruteForceMedian(new int[]{1}));
        assertEquals(8, BruteForceAlgorithm.BruteForceMedian(new int[]{8}));
        assertEquals(1, BruteForceAlgorithm.BruteForceMedian(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}));
        assertEquals(4, BruteForceAlgorithm.BruteForceMedian(new int[]{1, 1, 1, 1, 8, 8, 8, 8, 4}));
    }

    @Test
    public void testEmptyCase(){
        assertEquals(0, BruteForceAlgorithm.BruteForceMedian(new int[]{}));
    }

    @Test
    public void testOperationCount(){
        BruteForceAlgorithm.operCounter = 0;
        BruteForceAlgorithm.BruteForceMedianBasicCounter(new int[]{1, 2, 3, 4, 5});
        assertEquals(15, BruteForceAlgorithm.operCounter);
    }
}
