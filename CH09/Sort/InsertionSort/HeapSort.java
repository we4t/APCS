public class HeapSort {
    private static int[] arr, returnArray;
    private static int tail, order;

    public static void sort(int[] array, int sortOrder) {
        arr = array;
        tail = array.length - 1; //maximum index
        order = sortOrder;
        returnArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            upHeapify(i);
        }

        while (tail >= 0) {
            returnArray[array.length - 1 - tail] = arr[0];
            swap(0, tail);
            tail--;
            downHeapify(0);
        }
        array = returnArray;
    }

    public static void upHeapify(int pivot) {
        if (pivot == 0) {
            return;
        } else {
            // pivot : child, piv - 1 /2 : parent
            // parent should be smaller than the child
            // if chlid >= parent : order = 1
            if (!ordered(arr[(pivot - 1) / 2], arr[pivot])) {
                swap(pivot, (pivot - 1) / 2);
                upHeapify((pivot - 1) / 2);
            }
        }
    }

    public static void downHeapify(int pivot) {
        if (pivot >= tail) {
            return;
        } else {
            int tmp = findChild(pivot);
            if (tmp == 0) {
                return;
            }
            // pivot = parent, tmp = child
            // parent should be smaller than the child
            // if parent <= child
            if (!ordered(arr[pivot], arr[tmp])) {
                swap(pivot, tmp);
                downHeapify(tmp);
            }
        }
    }

    public static boolean ordered(int x, int y) { // check the pairs are ordered
        if (order == 1) {
            return x > y;
        } else {
            return x < y;
        }
    }

    public static int findChild(int pivot) {
        if (pivot * 2 + 1 > tail) {
            return 0;
        } else if (pivot * 2 + 2 > tail) {
            return (pivot * 2 + 1);
        } else {
            if (!ordered(arr[pivot * 2 + 1], arr[pivot * 2 + 2])) {
                return (pivot * 2 + 2);
            } else {
                return (pivot * 2 + 1);
            }
        }
    }

    public static void swap(int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }
}