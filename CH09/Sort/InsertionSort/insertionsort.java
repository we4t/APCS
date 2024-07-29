public class insertionsort {
    public static void sort(int[] array, int sortOrder) {
        // sortOrder = 1 : ascending
        // sortOrder = 0 : descending
        int key, i, j;
        for (i = 1; i < array.length; i++) {
            key = array[i];
            for (j = i - 1; j >= 0 && array[j] > key; j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = key;
        }
    }

    public static boolean ordered(int sortOrder, int a, int b) {
        if (sortOrder == 1) {
            return a < b;
        } else {
            return a > b;
        }
    }

}
