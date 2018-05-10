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
    public void testBasicCase() throws Exception{
        assertEquals(4, BruteForceAlgorithm.BruteForceMedian(new int[]{1, 3, 4, 6, 7}));
        assertEquals(3, BruteForceAlgorithm.BruteForceMedian(new int[]{1, 3, 4, 6}));
        assertEquals(2, BruteForceAlgorithm.BruteForceMedian(new int[]{1, 2, 3, 4, 7, 9}));
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
        BruteForceAlgorithm.operCounter = 0;
        BruteForceAlgorithm.BruteForceMedian(new int[]{1, 2, 3, 4, 5});
        assertEquals(15, BruteForceAlgorithm.operCounter);
    }

    @Test
    public void testAverageCount() throws Exception{
        BruteForceAlgorithm.operCounter = 0;
        int[][] arrays = new int[][]{new int[]{1, 3, 4, 6, 7}, new int[]{1, 3, 4, 6}, new int[]{1, 3, 4, 4, 7, 9}, new int[]{0, 0, 0, 0, 0, 0, 0}};
        long[] basicOperationCounter = new long[arrays.length];
        int index = 0;
        for (int [] arr : arrays){
            BruteForceAlgorithm.BruteForceMedian(arr);
            basicOperationCounter[index] = BruteForceAlgorithm.operCounter;
            index++;
        }
        assertEquals(31, Main.calculateAverage(basicOperationCounter));
    }



}
