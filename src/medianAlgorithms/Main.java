package medianAlgorithms;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Main{
	
	
	public static int[] generateRandomArray( int size )
	{
		Random randomNumberGenerator = new Random();
		
		int[] randArray = new int[size];
		
		for ( int jj = 0; jj < size; jj++ )
		{
			randArray[jj] = randomNumberGenerator.nextInt();
		}
		
		return randArray;
	}
	

    public static void main(String[] args) throws IOException
    {
    	int numTests = 350;
    	int size = 1000;
    	int numArraysTested = 100;
    	
    	int[] sizeOfArray = new int[numArraysTested];
    	long[] basicOperationCounter = new long[numArraysTested];

    	
    	FileWriter fl = new FileWriter( "basicOperationsTest.csv" ); 
    	
    	for ( int j = 0; j < numArraysTested; j++ )
    		basicOperationCounter[j] = 0;
    	
    	for ( int i = 0; i < numTests; i++ )
    	{
    		
    		size = 1000;
    		
    		System.out.println( "Starting test " + (i + 1) + "\n\n\n");
    		for ( int j = 0; j < numArraysTested; j++ )
    		{
    			System.out.println( "starting array size test " + (j + 1) );
    			
    			int[] randArray = generateRandomArray( size );
    			
    			
    			PartitionAlgorithm.basicCounter = 0;
    			
    			PartitionAlgorithm.MedianBasicOperationCount( randArray );
    			
    			
    			// save data
    			sizeOfArray[j] = size;
    			basicOperationCounter[j] += PartitionAlgorithm.basicCounter;
    			
    			System.out.println( "Basic operations performed: " + PartitionAlgorithm.basicCounter + "\n");
    			
    			// incrament size of array
    			size += 5000;
    		}
    	}
    	
    	// calculate average
    	for ( int j = 0; j < numArraysTested; j++ )
    	{
    		basicOperationCounter[j] /= numTests;
    		
    		// save data in csv format
    		fl.write( sizeOfArray[j] + "," );
    		fl.write( basicOperationCounter[j] + "\n");
    	}
    	
    	
    	
    	
    	fl.close();
    }
}
