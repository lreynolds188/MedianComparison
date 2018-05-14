package medianAlgorithms;

import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main{

    static DefaultCategoryDataset execTimeDataSet = new DefaultCategoryDataset( );
    static DefaultCategoryDataset operationsDataSet = new DefaultCategoryDataset( );

    public static void main(String[] args) throws Exception
    {
    	//partitionBasicCounterTest();
    	//partitionExecutionTimeTest();
    	bruteForceBasicOperationCounterTests();
    	//bruteForceTimeExecutionTests();
        //plotGraph("Execution Time", "Partition Algorithm Execution Time", "Dataset Size", "Execution Time (ns)", execTimeDataSet);
        plotGraph("Basic Operations", "Brute Force Basic Operations", "Dataset Size", "Number of Basic Operations", operationsDataSet);
    }

    /**
     * Tests run on partition median algorithm to produce experimental basic operation counter results for analysis
     * @throws Exception
     */
    public static void partitionBasicCounterTest() throws Exception 
    {
        int numTests = 10;
        int numArraysTested = 100;
        
        int increamentSize = 5000;
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
            operationsDataSet.addValue(basicOperationCounter[j], "Partition", Integer.toString(sizeOfArray[j]));
            
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
    	int numTests = 10;
        int numArraysTested = 100;
        
        int increamentSize = 5000;
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
            execTimeDataSet.addValue(executionTimeCounter[j], "Partition", Integer.toString( sizeOfArray[j] ) );
            
            // Write to CSV
        	fl.write( sizeOfArray[j] + "," );
        	fl.write(executionTimeCounter[j] + "\n");
            
            size += increamentSize;

        }
        
        fl.close();
    }
    
    public static void bruteForceBasicOperationCounterTests() throws Exception 
    {
    	int numTests = 10;
        int numArraysTested = 100;
        
        int increamentSize = 5000;
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
            operationsDataSet.addValue(basicOperationCounter[j], "Partition", Integer.toString(sizeOfArray[j]));
            
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
    	int numTests = 10;
        int numArraysTested = 100;
        
        int increamentSize = 5000;
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
            execTimeDataSet.addValue(executionTimeCounter[j], "Brute Force", Integer.toString( sizeOfArray[j] ) );
            
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

    /**
     * Calculates the average of an array of long's
     * @param data
     * @return
     */
	public static long calculateAverage(long[] data){
		// calculate average
        long temp = 0;
		for ( int i = 0; i < data.length; i++ )
		{
			temp += data[i];
		}
		return temp /= data.length;
	}

    /**
     * Creates a new plot class and sends it the required variables to plot the graph
     * @param appTitle
     * @param title
     * @param xAxisLabel
     * @param yAxisLabel
     * @param dataSet
     */
    public static void plotGraph(String appTitle, String title, String xAxisLabel, String yAxisLabel, DefaultCategoryDataset dataSet){
        Plot chart = new Plot(appTitle, title, xAxisLabel, yAxisLabel, dataSet);
        chart.pack( );
        RefineryUtilities.centerFrameOnScreen( chart );
        chart.setVisible( true );
    }

    /**
     * Saves all data stored in a HashMap<Integer, Long[]> to the specified filename in a csv format
     * @param data
     * @param filename
     * @throws IOException
     */
	public static void saveData(HashMap<Integer, Long[]> data, String filename) throws IOException {
		FileWriter fl = new FileWriter( filename );

        fl.write("Array Size, Basic Operations, Execution Time(ms)\n");
		for (Map.Entry<Integer, Long[]> temp : data.entrySet()){
			// save data in csv format
			fl.write(temp.getKey() + "," + temp.getValue()[0] + "," + temp.getValue()[1] + "\n");
		}

		fl.close();
	}

}
