public class SelectionSort implements SortingAlgorithm{
    @Override
    public int[] sorty(int[] input) {
        int[] numbers = input.clone();

        for (int i = 0; i < numbers.length - 1; i++){
            //find index of smallest remaining element
            int indexSmallest = i;

            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] < numbers[indexSmallest]) {
                    indexSmallest = j;
                }
            }
            //swap arr[i] and arr[indexSmallest]
            int temp = numbers[i];
            numbers[i] = numbers[indexSmallest];
            numbers[indexSmallest] = temp;
        }
        return numbers;
    }
}