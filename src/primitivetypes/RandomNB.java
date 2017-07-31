package primitivetypes;

import java.util.Random;

public class RandomNB {

    private static Random rand = new Random();

    public static int random(int lower, int higher) {
        int outcomes = higher - lower + 1;
        int result;

        do {
            result = 0;
            for (int i = 0; (1 << i) < outcomes; i++) {
                int coin = rand.nextInt(2);
                result = (result << 1) | coin;
            }
        } while (result >= outcomes);

        return result + lower;
    }

    public static void main(String[] args) {
        int T = 100;

        while (T > 0) {
            System.out.println(new RandomNB().random(0,16));
        }

    }
}
