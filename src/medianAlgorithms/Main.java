package medianAlgorithms;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Main{


    public static void main(String[] args) throws Exception
    {
    	partitionBasicCounterTest();
    	partitionExecutionTimeTest();
    	bruteForceBasicOperationCounterTests();
    	bruteForceTimeExecutionTests();
    }

    /**
     * Tests run on partition median algorithm to produce experimental basic operation counter results for analysis
     * @throws Exception
     */
    public static void partitionBasicCounterTest() throws Exception 
    {
        int numTests = 40;
        int numArraysTested = 100;
        
        int increamentSize = 1000;
        int size = 1000;

        int[] sizeOfArray = new int[numArraysTested];
        long[] basicOperationCounter = new long[numArraysTested];

        FileWriter fl = new FileWriter( "partitionBasicOperationsCounterTest.csv" );
        
        // Initialise execution time counter
        for ( int i = 0; i < numArraysTested; i++ )
        	basicOperationCounter[i] = 0;

        for (int j = 0; j < numArraysTested; j++)
        {
            for ( int i = 0; i < numTests; i++ )
            {
                System.out.println( "starting array size " + size + " \ttest " + (i + 1) );

                int[] randArray = generateRandomArray( size );

                PartitionAlgorithm.basicCounter = 0;

                PartitionAlgorithm.MedianBasicOperationCount( randArray );

                // save data
                sizeOfArray[j] = size;
                basicOperationCounter[j] += PartitionAlgorithm.basicCounter;

                System.out.println( "Basic operations performed: " + PartitionAlgorithm.basicCounter + "\n");
            }
            
            // Calculate average
            basicOperationCounter[j] /= numTests;
            
            // Write data to file
            fl.write( sizeOfArray[j] + "," );
        	fl.write( basicOperationCounter[j] + "\n");
        	
            size += increamentSize;
        }
        
        fl.close();
    }
    
    /**
     * Tests run on partition median algorithm to produce experimental execution time results for analysis
     * @throws IOException
     */
    public static void partitionExecutionTimeTest() throws Exception
    {
    	int numTests = 40;
        int numArraysTested = 100;
        
        int increamentSize = 1000;
        int size = 1000;
        
        long startTime;

        int[] sizeOfArray;
        long[] executionTimeCounter;

        FileWriter fl = new FileWriter( "partitionExecutionTimeTest.csv" );
        
        sizeOfArray = new int[numArraysTested];
        executionTimeCounter = new long[numArraysTested];
        
        // Initialise execution time counter
        for ( int i = 0; i < numArraysTested; i++ )
        	executionTimeCounter[i] = 0;

        for (int j = 0; j < numArraysTested; j++ )
        {
            for ( int i = 0; i < numTests; i++ )
            {
                System.out.println( "starting array size " + size + " \ttest " + (i + 1) );

                int[] randArray = generateRandomArray( size );

                startTime = System.nanoTime();
                PartitionAlgorithm.Median( randArray );
                long duration = System.nanoTime() - startTime;
                
                // save data
                executionTimeCounter[j] += duration;
                sizeOfArray[j] = size;

                System.out.println(  "Execution time: " + duration + "ns\n");
            }
            
            // calculate Average
            executionTimeCounter[j] /= numTests;
            
            // Write to CSV
        	fl.write( sizeOfArray[j] + "," );
        	fl.write(executionTimeCounter[j] + "\n");
            
            size += increamentSize;

        }
        
        fl.close();
    }
    
    public static void bruteForceBasicOperationCounterTests() throws Exception 
    {
    	int numTests = 40;
        int numArraysTested = 100;
        
        int increamentSize = 1000;
        int size = 1000;

        int[] sizeOfArray = new int[numArraysTested];
        long[] basicOperationCounter = new long[numArraysTested];

        FileWriter fl = new FileWriter( "bruteForceBasicOperationsCounterTest.csv" );
        
        // Initialise execution time counter
        for ( int i = 0; i < numArraysTested; i++ )
        	basicOperationCounter[i] = 0;

        for (int j = 0; j < numArraysTested; j++)
        {
            for ( int i = 0; i < numTests; i++ )
            {
                System.out.println( "starting array size " + size + " \ttest " + (i + 1) );

                int[] randArray = generateRandomArray( size );

                BruteForceAlgorithm.operCounter = 0;

                BruteForceAlgorithm.BruteForceMedianBasicCounter( randArray );

                // save data
                sizeOfArray[j] = size;
                basicOperationCounter[j] += BruteForceAlgorithm.operCounter;

                System.out.println( "Basic operations performed: " + BruteForceAlgorithm.operCounter + "\n");
            }
            
            // Calculate average
            basicOperationCounter[j] /= numTests;
            
            // Write data to file
            fl.write( sizeOfArray[j] + "," );
        	fl.write( basicOperationCounter[j] + "\n");
        	
            size += increamentSize;
        }
        
        fl.close();
	}

    /**
     * Tests run on the brute force median algorithm to produce experimental results for analysis
     * @throws Exception
     */
    public static void bruteForceTimeExecutionTests() throws Exception 
    {
    	int numTests = 40;
        int numArraysTested = 100;
        
        int increamentSize = 1000;
        int size = 1000;
        
        long startTime;

        int[] sizeOfArray;
        long[] executionTimeCounter;

        FileWriter fl = new FileWriter( "bruteForceExecutionTimeTest.csv" );
        
        sizeOfArray = new int[numArraysTested];
        executionTimeCounter = new long[numArraysTested];
        
        // Initialise execution time counter
        for ( int i = 0; i < numArraysTested; i++ )
        	executionTimeCounter[i] = 0;

        for (int j = 0; j < numArraysTested; j++ )
        {
            for ( int i = 0; i < numTests; i++ )
            {
                System.out.println( "starting array size " + size + " \ttest " + (i + 1) );

                int[] randArray = generateRandomArray( size );

                startTime = System.nanoTime();
                BruteForceAlgorithm.BruteForceMedian( randArray );
                long duration = System.nanoTime() - startTime;
                
                // save data
                executionTimeCounter[j] += duration;
                sizeOfArray[j] = size;

                System.out.println(  "Execution time: " + duration + "ns\n");
            }
            
            // calculate Average
            executionTimeCounter[j] /= numTests;
            
            // Write to CSV
        	fl.write( sizeOfArray[j] + "," );
        	fl.write(executionTimeCounter[j] + "\n");
            
            size += increamentSize;
        }
        
        fl.close();
	}

    /**
     * Uses the random number generator to generate an array of int [size] with random numbers in each index
     * @param size
     * @return
     */
    public static int[] generateRandomArray( int size )
    {
        Random randomNumberGenerator = new Random();

        int[] randArray = new int[size];

        for ( int i = 0; i < size; i++ )
        {
            randArray[i] = randomNumberGenerator.nextInt();
        }

        return randArray;
    }
}
