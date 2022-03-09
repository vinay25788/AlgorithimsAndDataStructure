package datastructure_pattern.slidingwindow;

public class MinimumLengthSubArrayTargetSum {

    static  public  int minSubArrayLen(int target, int[] a) {

        if(a.length == 1 && a[0]<target)
            return 0;

        int i=0,j=0;
        int minLength = Integer.MAX_VALUE;
        int n = a.length;
        int curSum = 0;
        while(j<n)
        {
            curSum +=a[j];
            if(curSum>= target)
            {

                while(curSum>=target)
                {
                    int length = j-i+1;
                    if(length<minLength)
                        minLength = length;

                    if(curSum>=target)
                    {
                        curSum -= a[i];
                        i++;
                    }
                }
            }
            j++;
        }

        if(minLength == Integer.MAX_VALUE)
            return 0;
        return minLength;

    }

    public static void main(String[] args) {
        int[] a ={2,3,1,2,4,3};
        int sum = 7;
        System.out.println(minSubArrayLen(sum,a));
    }
}
