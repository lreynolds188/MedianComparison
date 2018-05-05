package medianAlgorithms;

public class Algorithms {

    /**
     * Returns the median value in a given array A of n numbers.
     * @param array
     * @return
     */
    public static int BruteForceMedian(int[] array){
        int k = (int)Math.ceil((array.length+1)/2);
        for (int i = 0; i < array.length; i++){
            int smaller = 0;
            int equal = 0;
            for (int j = 0; j < array.length; j++){
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
    }

    public static int Median(int[] array){
        return 0;
    }

    public static int Select(int[] array, int low, int mid, int high){
        return 0;
    }

    public static int Partition(int[] array, int low, int high){
        return 0;
    }

}
