public class QuickSort implements SortingAlgorithm{
    @Override
    public int[] sorty(int[] input) {
        int[] numbers = input.clone();
        quicksort(numbers, 0, numbers.length - 1);
        return numbers;
    }

    private void quicksort(int[] numbers, int startIndex, int endIndex) {
        if (endIndex <= startIndex) {
            return;
        }

        int high = partition(numbers, startIndex, endIndex);
        quicksort(numbers, startIndex, high);
        quicksort(numbers, high + 1, endIndex);
    }

    private int partition(int[] numbers, int lowIndex, int highIndex) {
        int midpoint = lowIndex + (highIndex - lowIndex)/2;
        int pivot = numbers[midpoint];

        boolean done = false;
        while (!done) {
            while (numbers[lowIndex] < pivot) {
                lowIndex++;
            }
            while (pivot < numbers[highIndex]) {
                highIndex--;
            }

            if (lowIndex >= highIndex) {
                done = true;
            } else {
                int temp = numbers[lowIndex];
                numbers[lowIndex] = numbers[highIndex];
                numbers[highIndex] = temp;
                lowIndex++;
                highIndex--;
            }
        }
        return highIndex;
    }
}