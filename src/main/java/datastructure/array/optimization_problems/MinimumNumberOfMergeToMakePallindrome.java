package datastructure.array.optimization_problems;

public class MinimumNumberOfMergeToMakePallindrome {
    public static void main(String[] args) {
        int[] a={1, 4, 5, 9, 1};
        findMergeOperation(a);
    }
    public static void findMergeOperation(int[] a)
    {
        int ans=0;
        int n = a.length;
        for(int i=0,j=n-1;i<=j;)
        {
            if(a[i] == a[j])
            {
                i++;j--;
            }
            else if ( a[i] > a[j])
            {
                j--;
                a[j] +=a[j+1];
                ans++;
            }
            else
            {
                i++;
                a[i] +=a[i-1];
                ans++;
            }
        }
        System.out.println(" Answer "+ans);
    }
}
