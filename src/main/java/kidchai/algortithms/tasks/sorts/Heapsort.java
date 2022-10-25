package kidchai.algortithms.tasks.sorts;

public class Heapsort {
    public static void sort(int[] array, int length) {
        heapify(array, length);
        sortMaxHeap(array, length);
    }

    private static void sortMaxHeap(int[] array, int length) {
        int buf = array[0];
        array[0] = array[length - 1];
        array[length - 1] = buf;

        length--;

        if (length > 1) {
            siftDown(array, length);
            sort(array, length);
        }
    }

    private static void heapify(int[] array, int length) {
        for (int i = 0; i < length; i++) {
            int j = i;
            while (array[j] > array[(j - 1) / 2]) {
                int buf = array[(j - 1) / 2];
                array[(j - 1) / 2] = array[j];
                array[j] = buf;

                j = (j - 1) / 2;
            }
        }
    }

    private static void siftDown(int[] array, int length) {
        int j = 0;

        while (array[j] < array[(2 * j) + 1] || array[j] < array[(2 * j) + 2]) {

            if (array[j] < array[(2 * j) + 1]) {
                if ((2 * j) + 2 < length - 1 && array[j] < array[(2 * j) + 2]) {
                    int index = array[(2 * j) + 1] <= array[(2 * j) + 2] ? 1 : 2;
                    swapWithChild(j, array, index);
                    j = (2 * j) + index;
                } else {
                    swapWithChild(j, array, 1);
                    j = (2 * j) + 1;
                }
            } else if ((2 * j) + 2 <= length - 1) {
                swapWithChild(j, array, 2);
                j = (2 * j) + 2;
            }

            if ((2 * j) + 1 >= length - 1) {
                return;
            }
        }
    }

    private static void swapWithChild(int j, int[] array, int childId) {
        int buf = array[j];
        array[j] = array[(2 * j) + childId];
        array[(2 * j) + childId] = buf;
    }
}