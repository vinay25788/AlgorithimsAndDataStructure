package practice.datastructure.array.optimization;

public class MinimumLengthSubArrayWithSumGreater {
    public static void main(String[] args) {
        int a[] = { 1, 4, 45, 6, 10, 19 };
        int x = 51;
        findSubArray(a,x);
    }
    public static void findSubArray(int[] a,int x)
    {
        int curSum =0,minLength = Integer.MAX_VALUE;
        int end =0, start =0,n = a.length;
        while(end<n)
        {
            while(curSum<= x && end < n)
                curSum+=a[end++];

            while(curSum>x && start<n)
            {
                if(minLength>end - start)
                    minLength = end -start;
                curSum -=a[start++];
            }

        }
        System.out.println(minLength);
    }

}
