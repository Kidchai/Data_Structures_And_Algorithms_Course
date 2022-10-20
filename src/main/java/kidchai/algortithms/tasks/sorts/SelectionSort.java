package kidchai.algortithms.tasks.sorts;

public class SelectionSort {
    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = Integer.MAX_VALUE;
            int indexOfMin = 0;
            for (int j = i; j < array.length; j++) {
                if (min > array[j]) {
                    min = array[j];
                    indexOfMin = j;
                }
            }
            array[indexOfMin] = array[i];
            array[i] = min;
        }
    }
}
