package DSA.DynamicProgramming.DynamicProgramming1D;

public class BestTime2BuyAndSellStock {
    public static int maxProfit(int[] prices) {

        int current = Integer.MAX_VALUE;
        int max = 0;

        for (int price : prices) {
            current = Math.min(current, price);
            max = Math.max(max, price - current);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4})); // 5
    }
}
