package arrays;

/**
 * Created by stefan on 19/06/17.
 */
public class AdvanceArray {


    public static boolean advance(int[] arr) {
        int furthest = arr[0];

        for (int i = 0; i <= furthest && furthest < arr.length; i++) {
            furthest = Math.max(furthest, i + arr[i]);
        }

        return furthest >= arr.length;
    }

    public static void main(String[] args) {
        int[] T = new int[] {2,4,1,1,0,2,3};

        System.out.println(advance(T));
    }
}
