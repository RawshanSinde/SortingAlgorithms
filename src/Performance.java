import java.io.*;

public class Performance {
    /** a main function that runs the Tester.test() method with 20 iterations
     * for each algorithm for each of the array sizes (100, 500, 1000, 2000, 5000,
     * 10000, 20000, 75000, 150000) and produces a .txt file report with results
     */
    public static void main(String[] args) {
        int[] sizes = {100, 500, 1000, 2000, 5000, 10000, 20000, 75000, 150000};
        int iterations = 20;

        try {
            PrintWriter writer = new PrintWriter(new FileWriter("performance_report.txt"));

            //bubble sort
            writer.println("Sorting algorithm- Bubble sort");
            Tester tester = new Tester(new BubbleSort());
            for (int size : sizes) {
                writer.println(tester.test(iterations, size));
            }
            writer.println();

            //insertion sort
            writer.println("Sorting algorithm- Insertion sort");
            tester = new Tester(new InsertionSort());
            for (int size : sizes) {
                writer.println(tester.test(iterations, size));
            }
            writer.println();

            //selection sort
            writer.println("Sorting algorithm- Selection sort");
            tester = new Tester(new SelectionSort());
            for (int size : sizes) {
                writer.println(tester.test(iterations, size));
            }
            writer.println();

            //shell sort
            writer.println("Sorting algorithm- Shell sort");
            tester = new Tester(new ShellSort());
            for (int size : sizes) {
                writer.println(tester.test(iterations, size));
            }
            writer.println();

            //merge sort
            writer.println("Sorting algorithm- Merge sort");
            tester = new Tester(new MergeSort());
            for (int size : sizes) {
                writer.println(tester.test(iterations, size));
            }
            writer.println();

            //quick sort
            writer.println("Sorting algorithm- Quick sort");
            tester = new Tester(new QuickSort());
            for (int size : sizes) {
                writer.println(tester.test(iterations, size));
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing to the file.");
        }
    }
}
