package DSA.DynamicProgramming.DynamicProgramming2D;

public class BestTime2BuyAndSellStockWithCooldown {

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int hold = Integer.MIN_VALUE; // max profit when holding a stock
        int sold = 0;                 // max profit when just sold
        int rest = 0;                 // max profit when in cooldown (not holding)

        for (int price : prices) {
            int prevSold = sold;

            // Sell today if holding, or keep previous sold
            sold = hold + price;

            // Update hold: either keep holding, or buy today after rest
            hold = Math.max(hold, rest - price);

            // Update rest: either keep resting, or enter rest after selling
            rest = Math.max(rest, prevSold);
        }

        // Max profit is either resting or just sold (not holding stock)
        return Math.max(sold, rest);
    }

    public static void main(String[] args) {
        int[] prices1 = {1, 2, 3, 0, 2};
        System.out.println(maxProfit(prices1)); // 3

        int[] prices2 = {1, 2, 3, 0, 0};
        System.out.println(maxProfit(prices2)); // 2

        int[] prices3 = {2, 1, 4};
        System.out.println(maxProfit(prices3)); // 3
    }
}
