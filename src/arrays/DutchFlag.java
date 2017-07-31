package arrays;

import java.util.Arrays;
import java.util.Random;

public class DutchFlag {

    public static int[] partition(int[] arr, int pivot) {

        int value = arr[pivot];
        System.out.println("pivot: " + pivot + " value: " + value);

        int low = 0;
        int eq = arr.length - 1;
        int high = arr.length - 1;

        while (low < eq) {
            if (arr[low] < value) {
                low++;
            } else if (arr[low] == value){
                swap(arr, low, eq--);
            } else if (arr[low] > value){
                swap(arr, low, high--);
                if (high - eq < 1) {
                    eq--;
                }
            }
        }

        return arr;
    }

    public static int[] partition2(int[] arr, int pivot) {
        int value = arr[pivot];
        System.out.println("pivot: " + pivot + " value: " + value);

        int low = 0;
        int eq = 0;
        int high = arr.length - 1;

        while (eq < high) {
            if (arr[eq] < value) {
                swap(arr, eq, low);
                eq++;
                low++;
            } else if (arr[eq] == value) {
                eq++;
            } else {
                swap(arr, eq, high);
                high--;
            }
        }

        return arr;
    }

    private static int[] swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }

    public static void main(String[] args) {
        int size = 10;
        int[] T = new int[size];
        int[] err = new int[] {2, 7, 3, 9, 1, 3, 6, 1, 2, 3};

        for (int i = 0; i < size; i++) T[i] = new Random().nextInt(size);

        System.out.println(Arrays.toString(T));

        //System.out.println(Arrays.toString(partition(err, 5)));
        System.out.println(Arrays.toString(partition2(err, 5)));
        // [2, 2, 1, 3, 3, 3, 1, 6, 9, 7]
        //[2, 2, 1, 1, 3, 3, 3, 6, 9, 7] mine
    }
}
