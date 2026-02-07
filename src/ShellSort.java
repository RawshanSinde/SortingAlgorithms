public class ShellSort implements SortingAlgorithm{
    @Override
    public int[] sorty(int[] input) {
        int[] numbers = input.clone();
        int[] gapValues = {numbers.length/2, numbers.length/4, 1};
        shellSort(numbers, gapValues);
        return numbers;
    }

    private void shellSort(int[] numbers, int[] gapValues) {
        for (int g = 0; g < gapValues.length; g++) {
            for (int i = 0; i < gapValues[g]; i++) {
                insertionSortInterleaved(numbers, i, gapValues[g]);
            }
        }
    }

    private void insertionSortInterleaved(int[] numbers, int startIndex, int gap) {
        for (int i = startIndex + gap; i < numbers.length; i += gap) {
            int j = i;
            while (j - gap >= startIndex && numbers[j] < numbers[j - gap]) {
                //swap numbers[j] and numbers[j-gap]
                int temp = numbers[j];
                numbers[j] = numbers[j - gap];
                numbers[j - gap] = temp;
                j -= gap;
            }
        }
    }
}
