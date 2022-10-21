package kidchai.algortithms.tasks.sorts;

import java.util.Arrays;

public class MergeSort {
    public static void sort(int[] array) {
        if (array.length > 1) {
            int mid = array.length / 2;
            int[] leftArray = Arrays.copyOfRange(array, 0, mid);
            int[] rightArray = Arrays.copyOfRange(array, mid, array.length);

            sort(leftArray);
            sort(rightArray);

            int i = 0;
            int j = 0;
            int y = 0;

            while (i < leftArray.length && j < rightArray.length) {
                if (leftArray[i] < rightArray[j]) {
                    array[y] = leftArray[i];
                    i++;
                } else {
                    array[y] = rightArray[j];
                    j++;
                }
                y++;
            }

            if (i < leftArray.length) {
                for (; y < array.length; y++) {
                    array[y] = leftArray[i];
                }
            } else if (j < rightArray.length) {
                for (; y < array.length; y++) {
                    array[y] = rightArray[j];
                }
            }
        }
    }
}
