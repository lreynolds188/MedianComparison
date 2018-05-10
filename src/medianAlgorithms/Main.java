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
    	//partitionTests();
    	bruteForceTests();
        plotGraph("Execution Time", "Brute Force vs Partition (Execution Time)", "Dataset Size", "Execution Time (ms)", execTimeDataSet);
        plotGraph("Basic Operations", "Brute Force vs Partition (Basic Operations)", "Dataset Size", "Number of Basic Operations", operationsDataSet);
    }

    public static void partitionTests() throws IOException {
        int numTests = 10;
        int numArraysTested = 100;
        long startTime;

        int[] sizeOfArray = new int[numArraysTested];
        long[] basicOperationCounter = new long[numArraysTested];
        long[] executionTimeCounter = new long[numArraysTested];

        FileWriter fl = new FileWriter( "basicOperationsTest.csv" );
        fl.write("Array Size, Basic Operations, Execution Time(ms)\n");

        for (int size = 1000; size < 502000; size+= 5000){
            for ( int i = 0; i < numTests; i++ )
            {
                System.out.println( "starting array size " + size + " \ttest " + (i + 1) );

                int[] randArray = generateRandomArray( size );

                PartitionAlgorithm.basicCounter = 0;

                startTime = System.currentTimeMillis();
                PartitionAlgorithm.MedianBasicOperationCount( randArray );
                executionTimeCounter[i] = System.currentTimeMillis() - startTime;

                // save data
                sizeOfArray[i] = size;
                basicOperationCounter[i] += PartitionAlgorithm.basicCounter;

                System.out.println( "Basic operations performed: " + PartitionAlgorithm.basicCounter + "\tExecution time: " + executionTimeCounter[i] + "ms\n");
            }

            // calculate average
            for ( int j = 0; j < numTests; j++ )
            {
                basicOperationCounter[j] /= numTests;
                executionTimeCounter[j] /= numTests;

                execTimeDataSet.addValue(executionTimeCounter[j], "Partition", Integer.toString(size));
                operationsDataSet.addValue(basicOperationCounter[j], "Partition", Integer.toString(size));

                // save data in csv format
                fl.write( sizeOfArray[j] + "," );
                fl.write( basicOperationCounter[j] + ",");
                fl.write(executionTimeCounter[j] + "\n");
            }
        }

        fl.close();
    }

    /**
     *
     * @throws Exception
     */
    public static void bruteForceTests() throws Exception {
		int testsPerSize = 10;
        long startTime;
        long avgOperations;
        long avgExecTime;
        long[] basicOperationCounter;
        long[] execTimeCounter;

        HashMap<Integer, Long[]> data = new HashMap<>();

        for (int arraySize = 1000; arraySize < 502000; arraySize += 5000){
            basicOperationCounter = new long[testsPerSize];
            execTimeCounter = new long[testsPerSize];
            for ( int i = 0; i < testsPerSize; i++ ) {
                System.out.print("Array size: " + arraySize + " \tTest: " + (i + 1) + "... ");

                int[] randArray = generateRandomArray(arraySize);
                BruteForceAlgorithm.operCounter = 0;
                startTime = System.currentTimeMillis();
                BruteForceAlgorithm.BruteForceMedian(randArray);
                execTimeCounter[i] = System.currentTimeMillis() - startTime;
                basicOperationCounter[i] = BruteForceAlgorithm.operCounter;

                System.out.println("Basic operations: " + basicOperationCounter[i] + "\t\t" + "Execution time: " + execTimeCounter[i] + "ms");
                data.put(arraySize, new Long[]{basicOperationCounter[i], execTimeCounter[i]});
            }
            avgOperations = calculateAverage(basicOperationCounter);
            avgExecTime = calculateAverage(execTimeCounter);
            execTimeDataSet.addValue(avgExecTime, "Brute Force", Integer.toString(arraySize));
            operationsDataSet.addValue( avgOperations, "Brute Force", Integer.toString(arraySize));

            System.out.println("Average basic operations: " + avgOperations + "\t\t" + "Average execution time: " + avgExecTime + "ms\n");
        }
		saveData(data, "bruteForceData.csv");
	}

    /**
     *
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
     *
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
     * Creates a new plot class and sends it the required variables to plot the graph.
     *
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
     *
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
