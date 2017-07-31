package arrays;

import java.util.List;

/**
 * Created by stefan on 20/06/17.
 */
public class BuySellsStock {

    public static int trade(List<Integer> stock) {
        int maxProfit = 0;
        int lowestBuyPrice = Integer.MAX_VALUE;

        for (Integer price : stock) {
            maxProfit = Math.max(lowestBuyPrice - price, maxProfit);
            lowestBuyPrice = Math.min(lowestBuyPrice, price);
        }

        return maxProfit;
    }

    public static void main(String[] args) {

    }
}
