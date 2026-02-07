public class InsertionSort implements SortingAlgorithm {
    @Override
    public int[] sorty(int[] input) {
        int[] numbers = input.clone();
        for (int i = 1; i < numbers.length; i++) {
            int j = i;
            while (j > 0 && numbers[j] < numbers[j - 1]) {
                //swap arr[j] and arr[j -1]
                int temp = numbers[j];
                numbers[j] = numbers[j -1];
                numbers[j - 1] = temp;
                j--;
            }

        }
        return numbers;
    }
}
