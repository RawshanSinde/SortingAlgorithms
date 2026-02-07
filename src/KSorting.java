public class KSorting {
    /**
     * method generateKSorted(my_array) that fills the array that is passed as
     * an argument with 10-sorted data (each element is within 10 positions of
     * its correct position in the array)
     */
    public static void generateKSorted(int[] myArray) {
        int k = 10;
        //fill array with 10 sorted data
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = i;
        }

        //swap within distance k
        for (int i = 0; i < myArray.length; i++) {
            //determine valid range for swapping
            int min = i - k;
            if (min < 0) {
                min = 0;
            }

            int max = i + k;
            if (max > myArray.length - 1) {
                max = myArray.length - 1;
            }
            //choose random index within [min, max]
            int j = min + (int)(Math.random() * (max - min + 1));
            //swap the two elements
            int temp = myArray[i];
            myArray[i] = myArray[j];
            myArray[j] = temp;
        }
    }
}
