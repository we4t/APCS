public class MergeSort {
    public static int order;
    public static int tmp;

    public static void sort(int array[], int sortOrder) {
        order = sortOrder;
        mergeSort(array);
    }

    public static void mergeSort(int[] array) {
        // split array into two pieces
        // mergeSort splited arraies
        // termination conition : array.length == 2 or 1
        // merge : 2 ways
        // 1. start from left
        // 2. start from left and right
        if (array.length == 1) {
            return;
        } else if (array.length == 2) {
            if (array[0] > array[1]) {
                int tmp = array[0];
                array[0] = array[1];
                array[1] = tmp;
            }
        } else {
            int[] arr1 = new int[array.length / 2];
            int[] arr2 = new int[array.length - array.length / 2];
            int cnt = 0;
            for (int i = 0; i < arr1.length; i++) {
                arr1[i] = array[cnt];
                cnt++;
            }
            for (int i = 0; i < arr2.length; i++) {
                arr2[i] = array[cnt];
                cnt++;
            }
            mergeSort(arr1);
            mergeSort(arr2);
            int i = 0, j = 0;
            cnt = 0;
            while (i <= arr1.length - 1 && j <= arr2.length - 1) {
                if (arr1[i] < arr2[j]) {
                    array[cnt] = arr1[i];
                    cnt++;
                    i++;
                } else {
                    array[cnt] = arr2[j];
                    cnt++;
                    j++;
                }
            }
            while (i <= arr1.length - 1) {
                array[cnt] = arr1[i];
                cnt++;
                i++;
            }
            while (j <= arr2.length - 1) {
                array[cnt] = arr2[j];
                cnt++;
                j++;
            }
        }
    }

    public static void split(int array[], int startIndex, int endIndex) {
        if (array.length == 2) {
            if (!isOrderd(array[startIndex], array[endIndex])) {
                tmp = array[startIndex];
                array[startIndex] = array[endIndex];
                array[endIndex] = tmp;
            }
        } else if (array.length == 1) {
            return;
        } else {
            int[] arrayOne = new int[array.length / 2];
            int[] arrayTwo = new int[array.length - array.length / 2];
            copyArray(array, arrayOne, startIndex, array.length / 2 - 1);
            copyArray(array, arrayTwo, array.length / 2, array.length - 1);
            split(arrayOne, 0, arrayOne.length - 1);
            split(arrayTwo, 0, arrayTwo.length - 1);
            merge(array, arrayOne, arrayTwo, startIndex);
        }
    }

    public static void merge(int[] originArray, int[] arrOne, int[] arrTwo, int startIndex) {
        int i = 0, j = 0, cnt = startIndex;
        while (i < arrOne.length && j < arrTwo.length) {
            if (isOrderd(arrOne[i], arrTwo[j])) {
                originArray[cnt] = arrOne[i];
                i++;
                cnt++;
            } else {
                originArray[cnt] = arrTwo[j];
                j++;
                cnt++;
            }
        }
        while (i < arrOne.length) {
            originArray[cnt] = arrOne[i];
            cnt++;
            i++;
        }
        while (j < arrTwo.length) {
            originArray[cnt] = arrTwo[j];
            cnt++;
            j++;
        }
    }

    public static boolean isOrderd(int x, int y) {
        if (order == 1) {
            return x < y;
        } else {
            return x > y;
        }
    }

    public static void copyArray(int[] originalArray, int[] cpyArray, int startIndex, int endIndex) {
        for (int i = startIndex; i <= endIndex; i++) {
            cpyArray[i - startIndex] = originalArray[i];
        }
    }
}
