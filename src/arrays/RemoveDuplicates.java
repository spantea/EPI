package arrays;

import java.util.Arrays;

/**
 * Created by stefan on 19/06/17.
 */
public class RemoveDuplicates {

    public static int[] removeDuplicates(int[] arr) {
        int i = 0;
        int j = i + 1;
        while (i < arr.length && j < arr.length) {
            if (arr[i] == arr[j]) {
                arr[j] = 0;
                j++;
            } else {
                i++;
                arr[i] = arr[j];
                if (j - i > 1) arr[j] = 0;
                j++;
            }
        }

        return arr;
    }

    public static void main(String[] args) {

        int[] T = new int[] {2,3,5,5,7,11,11,11,13};

        System.out.println(Arrays.toString(removeDuplicates(T)));
    }
}
