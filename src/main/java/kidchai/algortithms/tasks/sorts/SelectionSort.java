package kidchai.algortithms.tasks.sorts;

public class SelectionSort {
    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            int buf = array[minIndex];
            array[minIndex] = array[i];
            array[i] = buf;
        }
    }
}