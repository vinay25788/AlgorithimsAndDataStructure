package datastructure.array.optimization_problems;

public class MaxTwiceBuySellStock {
    public static void main(String[] args) {
        int[] price = {2, 30, 15, 10, 8, 25, 80};
        calculateProfit(price);
    }

    public static void calculateProfit(int[] price) {
        int n = price.length;
        int[] profit = new int[n];
        int maxPrice = price[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (maxPrice < price[i])
                maxPrice = price[i];
            profit[i] = Math.max(profit[i + 1], maxPrice - price[i]);
        }
        int minPrice = price[0];
        for (int i = 1; i < n; i++) {
            if (minPrice > price[i])
                minPrice = price[i];
            profit[i] = Math.max(profit[i - 1], profit[i] + (price[i] - minPrice));
        }

        System.out.println(" maximum profit " + profit[n - 1]);
    }
}
