/**
 * Tester class to do a performance comparison of
 * your sorting algorithms
 */
public class Tester {
    private SortingAlgorithm sorting;
    //constructor for the Tester that takes parameter the sorting algorithm to be tested
    public Tester(SortingAlgorithm sa) {
        sorting = sa;
    }

    public double singleTest(int size) {
        //create an array of integers of given size
        int[] array = new int[size];
        //fill array with random numbers
        for (int i = 0; i < size; i++) {
            array[i] = (int)(Math.random() * size);
        }
        //run the sorty method and record the time it takes to sort the array
        long startTime =  System.nanoTime();
        sorting.sorty(array);
        long endTime = System.nanoTime();
        //return the time it takes to sort the array
        return (endTime - startTime)/1000000.0;
    }

    public String test(int iterations, int size) {
        double totalTime = 0.0;
        //run the singleTest method as many times as number of iterations provided
        for (int i = 0; i < iterations; i++) {
            totalTime += singleTest(size);
        }
        //print the average time the algorithm takes to sort an array of given size
        double averageTime = totalTime / iterations;
        return "Sorted " + size + " elements in " + averageTime + " ms (avg)";
    }

    public double singleTestKSorted(int size) {
        int[] array = new int[size];

        KSorting.generateKSorted(array);

        long startTime =  System.nanoTime();
        sorting.sorty(array);
        long endTime = System.nanoTime();

        return (endTime - startTime)/1000000.0;
    }

    public String testKSorted(int iterations, int size) {
        double totalTime = 0.0;

        for (int i = 0; i < iterations; i++) {
            totalTime += singleTestKSorted(size);
        }

        double averageTime = totalTime / iterations;
        return "Sorted " + size + " elements in " + averageTime + " ms (avg)";
    }
}
