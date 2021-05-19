package datastructure.array.optimize;

public class MaximumAverageOfKElementes {
    public static void main(String[] args) {
        int a[] = {1, 12, -5, -6, 50, 3};
        int k = 4;
        System.out.println(findIndex(a,k));
    }
    public static int findIndex(int[] a,int k)
    {
        int n = a.length;
        if(k>n)
            return -1;
        int sum=0,maxSum= Integer.MIN_VALUE,maxEnd=-1;
        for(int i=0;i<k;i++)
            sum+=a[i];

        maxSum = sum;
        maxEnd=k-1;
        for(int i=k;i<n;i++)
        {
            sum = a[i]-a[i-k];
            if(maxSum<sum)
            {
                maxSum = sum;
                maxEnd = i;
            }
        }
        return maxEnd-k+1;
    }
}
