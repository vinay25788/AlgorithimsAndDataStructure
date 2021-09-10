package practice.datastructure.array.optimization;

public class MaximumProfitByBuyingAndSelling {

    public static void main(String[] args) {
        int [] price = { 2, 30, 15, 10, 8, 25, 80 };
        findMaxProfit(price);
    }
    public static void findMaxProfit(int[] price)
    {
        int n = price.length;
        int[] profit = new int[n];

        int maxPrice=price[n-1];
        for(int i=n-2;i>=0;i--)
        {
            if(price[i]>maxPrice)
                maxPrice = price[i];
            profit[i] = Math.max(profit[i+1],maxPrice-price[i]  );
        }

        int minPrice = price[0];
        for(int i=1;i<n;i++)
        {
            if(price[i]<minPrice)
                minPrice= price[i];
            profit[i] = Math.max(profit[i-1],profit[i]+(price[i]-minPrice));
        }
        System.out.println(profit[n-1]);
    }
}
