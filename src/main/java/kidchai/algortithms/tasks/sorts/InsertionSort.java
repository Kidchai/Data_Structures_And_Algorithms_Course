package kidchai.algortithms.tasks.sorts;

public class InsertionSort {
    public static void sort(int[] array) {
        for (int i = 0; i + 1 < array.length ; i++) {
            int j = i + 1;
            while (j > 0 && array[j] < array[j - 1]) {
                int buf = array[j];
                array[j] = array[j - 1];
                array[j - 1] = buf;
                j--;
            }
        }
    }
}
