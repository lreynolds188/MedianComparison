package testCases;

import static org.junit.Assert.*;

import org.junit.Test;

import medianAlgorithms.Algorithms;
import medianAlgorithms.PartitionAlgorithm;

public class TestPartitionMedian {

	@Test
	public void testSimpleCases() 
	{
		assertEquals( 5, PartitionAlgorithm.Median( new int[] { 1, 2, 3, 4, 5, 6, 7, 8 } ) );
		assertEquals( 4, PartitionAlgorithm.Median( new int[] { 9, 1, 2, 8, 3, 4, 4, 1, 9, 2 } ) );
		assertEquals( 5, PartitionAlgorithm.Median( new int[] { 1, 2, 3, 4, 6, 6, 7, 8, 5 } ) );
		assertEquals( 7, PartitionAlgorithm.Median( new int[] { 5, 9, 11, 0, -4, 6, 7, 60, 11, 99, 1 } ) );
		assertEquals( 7, PartitionAlgorithm.Median( new int[] { 5, 9, 11, 0, -4, 6, 7, 60, 11, 99, 1, -99 } ) );
	}

	
	@Test
	public void testEdgeCases()
	{
		assertEquals( 1, PartitionAlgorithm.Median( new int[] { 1 } ) );
		assertEquals( 5, PartitionAlgorithm.Median( new int[] { 5 } ) );
		
		assertEquals( 4, PartitionAlgorithm.Median( new int[] { 1, 1, 1, 1, 1, 5, 5, 5, 5, 5, 4 } ) );
		assertEquals( 1, PartitionAlgorithm.Median( new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } ) );
	}
	
	@Test (expected = Exception.class)
	public void testEmptyArray() throws Exception
	{
		PartitionAlgorithm.Median( new int[] {} );
	}
}
