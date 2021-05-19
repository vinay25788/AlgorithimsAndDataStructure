package datastructure.array.optimize;

public class MinimumLengthSubArraySumGreaterThanX {
    public static void main(String[] args) {
        int a[] = {1, 4, 45, 6, 10, 19};
        int x = 51;
        System.out.println(findMinLength(a,x));
    }
    public static int findMinLength(int[] a,int x)
    {
        int n = a.length;
        int curSum =0, start =0,end =0;
        int minLength=Integer.MAX_VALUE;
        while(end<n)
        {
            while(curSum<=x&& end<n)
                curSum+=a[end++];

            while(curSum>x && start<n)
            {
                if( end - start < minLength)
                    minLength = end - start;
                curSum -= a[start++];
            }
        }
        return minLength;
    }
}
