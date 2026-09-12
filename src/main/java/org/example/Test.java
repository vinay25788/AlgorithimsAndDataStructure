package org.example;

public class Test {

    public static void main(String[] args) {
        int[] stocks={20,5,9,12,24,2, 16};
        System.out.println(getMaxProfit(stocks));
        System.out.println(getMaxProfitByMulitple(stocks));
    }

    private static int getMaxProfitByMulitple(int[] stocks)
    {
        int profit = 0;

        for (int i = 1; i < stocks.length; i++)
        {
            if (stocks[i] > stocks[i - 1])
            {
                profit += stocks[i] - stocks[i - 1];
            }
        }

        return profit;
    }

    private static int getMaxProfit(int[] stocks)
    {
        int prev = stocks[0];
        int profit =0;

        for(int i=1;i<stocks.length;i++)
        {
            if(prev>stocks[i])
                prev = stocks[i];
            else
                profit = Math.max(profit, stocks[i]-prev);
        }
        return profit;
    }


}
