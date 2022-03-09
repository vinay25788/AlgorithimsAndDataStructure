package practice.algorithim.dynamincprogramming;

public class NumberOfWaysToSum {
    public static void main(String[] args) {
        int n = 15;
        System.out.println(count(n));
    }
    public static int count(int n)
    {
        if(n<0)
            return 0;
        if(n ==0)
            return 1;
        return count( n-1)+count(n-3)+count(n-5);
    }

    public static int usingDp(int n)
    {
return 0;
    }
}
