package datastructure.dynamicprograming;

public class CountWaysToReachNthStair {
    public static void main(String[] args) {
        int n=4;
        countWays(n);
    }
    public static void countWays(int n)
    {
        int res[] = new int[n+1]  ;
        res[0] =1;
        res[1] = 1;
        res[2] =2;
        for(int i=3;i<=n;i++)
            res[i] = res[i-1]+res[i-2] +res[i-3];
        System.out.println(res[n]);
    }
}
