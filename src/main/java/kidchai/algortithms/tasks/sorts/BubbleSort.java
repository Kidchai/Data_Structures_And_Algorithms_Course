package kidchai.algortithms.tasks.sorts;

public class BubbleSort {
    public static void sort(int[] array) {
        boolean isSwapped = true;

        while (isSwapped) {
            isSwapped = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int buf = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = buf;
                    isSwapped = true;
                }
            }
        }
    }
}
