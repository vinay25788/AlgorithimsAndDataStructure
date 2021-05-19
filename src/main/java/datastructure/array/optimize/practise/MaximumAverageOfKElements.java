package datastructure.array.optimize.practise;

public class MaximumAverageOfKElements {
    public static void main(String[] args) {
        int a[] = {1, 12, -5, -6, 50, 3};
        int k = 4;
        System.out.println(findMin(a,k));
    }
    public static int findMin(int[] a,int k)
    {
        int n=a.length;
        if(k>n)
            return -1;
        int sum =0, maxSum = Integer.MIN_VALUE,maxEnd = -1;
        for(int i=0;i<k;i++)
            sum +=a[i];
        maxEnd = k-1;
        maxSum= sum;
        for(int i=k;i<n;i++)
        {
            sum = a[i] - a[i-k];
            if(sum>maxSum)
            {
                maxEnd = i;
                maxSum = sum;
            }
        }
        return maxEnd - k +1;
    }
}
