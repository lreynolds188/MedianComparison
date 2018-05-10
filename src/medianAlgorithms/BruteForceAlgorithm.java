package medianAlgorithms;

/**
 * @author Luke Reynolds
 * @version 1.0
 * @email lreynolds188@gmail.com
 * @website lukereynolds.net
 * @github https://github.com/lreynolds188
 */
public class BruteForceAlgorithm {

    public static long operCounter = 0;

    /**
     * Returns the median value in a given array A of n numbers.
     * @param array
     * @return
     */
    public static int BruteForceMedian(int[] array) throws Exception{
        if (array.length != 0){
            int k = (int)Math.ceil((array.length+1)/2);
            for (int i = 0; i < array.length; i++){
                int smaller = 0;
                int equal = 0;
                for (int j = 0; j < array.length; j++){
                    operCounter++;
                    if (array[j] < array[i]){
                        smaller += 1;
                    } else if (array[j] == array[i]){
                        equal += 1;
                    }
                }
                if (smaller < k && k <= (smaller + equal)){
                    return array[i];
                }
            }
            return k;
        } else {
            throw new Exception();
        }

    }
}