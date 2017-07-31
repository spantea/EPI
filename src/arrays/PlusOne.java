package arrays;

import java.util.ArrayList;
import java.util.List;

public class PlusOne {


    public static List<Integer> plusOne(List<Integer> nb) {
        int n = nb.size() - 1;
        nb.set(n, nb.get(n) + 1);

        for (int i = n; i > 0 && nb.get(i) == 10; i--) {
            nb.set(i, 0);
            nb.set(i - 1, nb.get(i - 1) + 1);
        }

        if (nb.get(0) == 10) {
            nb.set(0, 0);
            nb.add(0, 1);
        }

        return nb;
    }

    public static void main(String[] args) {

        List<Integer> T = new ArrayList<>();
        T.add(9);
        T.add(9);

        System.out.println(plusOne(T));
    }
}
