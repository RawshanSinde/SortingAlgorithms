public class MergeSort implements SortingAlgorithm {
    @Override
    public int[] sorty(int[] input) {
        int[] numbers = input.clone();

        if (numbers.length > 1) {
            mergeSort(numbers, 0, numbers.length - 1);
        }
        return numbers;
    }

    private void merge(int[] numbers, int leftFirst, int leftLast, int rightLast) {
        //size of merged partition
        int mergedSize = rightLast - leftFirst + 1;
        //array for merged numbers
        int[] mergedNumbers = new int[mergedSize];
        //position to insert merged number
        int mergePos = 0;
        //initialize left partition
        int leftPos = leftFirst;
        //initialize right partition
        int rightPos = leftLast + 1;

        //add smallest element from left or right partition to merge numbers
        while (leftPos <= leftLast && rightPos <= rightLast) {
            if (numbers[leftPos] <= numbers[rightPos]) {
                mergedNumbers[mergePos] = numbers[leftPos];
                leftPos++;
            } else {
                mergedNumbers[mergePos] = numbers[rightPos];
                rightPos++;
            }
            mergePos++;
        }

        //if left partition is not empty, add remaining elements to merged numbers
        while (leftPos <= leftLast) {
            mergedNumbers[mergePos] = numbers[leftPos];
            leftPos++;
            mergePos++;
        }

        //if right partition is not empty, add remaining elements to merged numbers
        while (rightPos <= rightLast) {
            mergedNumbers[mergePos] = numbers[rightPos];
            rightPos++;
            mergePos++;
        }

        //copy merged numbers back to numbers
        for (mergePos = 0; mergePos < mergedSize; mergePos++) {
            numbers[leftFirst + mergePos] = mergedNumbers[mergePos];
        }
    }

    private void mergeSort(int[] numbers, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            //find the midpoint in the partition
            int mid = (startIndex + endIndex) / 2;

            //recursively sort left and right partitions
            mergeSort(numbers, startIndex, mid);
            mergeSort(numbers, mid + 1, endIndex);

            //merge left and right partition in sorted order
            merge(numbers, startIndex, mid, endIndex);
        }
    }
}
