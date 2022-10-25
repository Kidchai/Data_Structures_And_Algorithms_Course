package kidchai.algortithms.tasks.sorts;

import java.util.Random;

public class QuickSort {
    public static void sort(int[] array, int start, int end) {

        if (start == end - 1 || start == end) {
            return;
        }

        int pivot = putPivotFirst(array, start, end);

        boolean hasRightHalf = false;
        int endOfLeftHalf = start;
        for (int i = start + 1; i < end; i++) {
            if (array[i] < pivot) {
                if (hasRightHalf) {
                    int buf = array[i];
                    array[i] = array[endOfLeftHalf + 1];
                    array[endOfLeftHalf + 1] = buf;
                }
                endOfLeftHalf++;
            } else {
                hasRightHalf = true;
            }
        }

        array[start] = array[endOfLeftHalf];
        array[endOfLeftHalf] = pivot;

        sort(array, start, endOfLeftHalf);
        sort(array, endOfLeftHalf + 1, array.length);
    }

    private static int putPivotFirst(int[] array, int start, int end) {
        Random random = new Random();
        int randomIndex = random.nextInt(end - start);
        int pivot = array[randomIndex + start];
        array[randomIndex + start] = array[start];
        array[start] = pivot;
        return pivot;
    }
}