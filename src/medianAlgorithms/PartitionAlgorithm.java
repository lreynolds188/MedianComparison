package medianAlgorithms;

public class PartitionAlgorithm 
{
	static long basicCounter = 0;
	
	/**
     * Returns the median value given to the array, if an event number
     * exists it returns the element to the right of the middle
     * @param array
     * @return
     */
    public static int MedianBasicOperationCount(int[] array)
    {
        if ( array.length == 1 )
        	return array[0];
        else
        	return Select( array, 0, (int)Math.floor( array.length / 2 ), array.length - 1 );
    }
    
    
	/**
     * Returns the median value given to the array, if an event number
     * exists it returns the element to the right of the middle
     * @param array
     * @return
     */
    public static int Median(int[] array)
    {
        if ( array.length == 1 )
        	return array[0];
        else
        	return Select( array, 0, (int)Math.floor( array.length / 2 ), array.length - 1 );
    }

    /**
     * Returns the value at index m in array slice A[l...h], if the slice
     * where sorted into nondecreasing order
     * @param array
     * @param low
     * @param mid
     * @param high
     * @return
     */
    public static int Select(int[] array, int low, int mid, int high)
    {
    	int pos = PartitionBasicOperationsCount( array, low, high );
    	
    	if ( pos == mid )
    		return array[pos];
    	if ( pos > mid )
    		return Select( array, low, mid, pos - 1 );
    	if ( pos < mid )
    		return Select( array, pos + 1, mid, high );
    	
        return 0;
    }

    /**
     * Partitions array slice A[l...h] by moving element A[l] to the position
     * it would have if the array slice was sorted, and by moving all values in
     * the slice smaller than A[l] to earlier positions, and all values larger
     * than or equal to A[l] to later positions. 
     * @param array
     * @param low
     * @param high
     * @return Returns the index at which the pivot element formerly at location
     * A[l] is placed
     */
    public static int PartitionBasicOperationsCount(int[] array, int low, int high)
    {
    	int pivotval = array[low];
    	int pivotloc = low;
    	
    	for ( int j = low + 1; j <= high; j++ )
    	{

    			basicCounter++;
    		
    		if ( array[j] < pivotval )
    		{
    			pivotloc++;
    			
    			// swap elements
    			int tempVal = array[pivotloc];
    			array[pivotloc] = array[j];
    			array[j] = tempVal;
    		}
    	}
    	
		int tempVal = array[low];
		array[low] = array[pivotloc];	// swap elements around pivot
		array[pivotloc] = tempVal;			// put pivot element in place
    	
        return pivotloc;
    }
    
    
    /**
     * Partitions array slice A[l...h] by moving element A[l] to the position
     * it would have if the array slice was sorted, and by moving all values in
     * the slice smaller than A[l] to earlier positions, and all values larger
     * than or equal to A[l] to later positions. 
     * @param array
     * @param low
     * @param high
     * @return Returns the index at which the pivot element formerly at location
     * A[l] is placed
     */
    public static int Partition(int[] array, int low, int high)
    {
    	int pivotval = array[low];
    	int pivotloc = low;
    	
    	for ( int j = low + 1; j <= high; j++ )
    	{	
    		if ( array[j] < pivotval )
    		{
    			pivotloc++;
    			
    			// swap elements
    			int tempVal = array[pivotloc];
    			array[pivotloc] = array[j];
    			array[j] = tempVal;
    		}
    	}
    	
		int tempVal = array[low];
		array[low] = array[pivotloc];	// swap elements around pivot
		array[pivotloc] = tempVal;			// put pivot element in place
    	
        return pivotloc;
    }
}
