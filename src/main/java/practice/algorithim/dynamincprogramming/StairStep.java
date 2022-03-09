package practice.algorithim.dynamincprogramming;

public class StairStep {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(count(n));
    }
    private static int count(int n)
    {
        int stairs[] = new int[n+1];
        stairs[0] =   1;
        stairs [1] = 1;
        stairs[2] = 2;
        for(int i=3;i<=n;i++)
            stairs[i] = stairs[i-1]+stairs[i-2]+stairs[i-3];
        return stairs[n];
    }
}
