package arrays;

import java.util.Arrays;

public class EvenOdd {

    public static int[] evenOdd(int[] arr) {

        int i = 0;
        int last = arr.length - 1;

        while (i < last) {
            if (arr[i] % 2 == 1) {
                int temp = arr[i];
                arr[i] = arr[last];
                arr[last] = temp;
                last--;
            } else {
                i++;
            }
        }
        return  arr;
    }

    public static void main(String[] args) {

        int[] test = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println(Arrays.toString(evenOdd(test)));
    }
}
