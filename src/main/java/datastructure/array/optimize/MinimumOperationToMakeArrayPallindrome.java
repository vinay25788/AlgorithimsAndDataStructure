package datastructure.array.optimize;

public class MinimumOperationToMakeArrayPallindrome {
    public static void main(String[] args) {
        int a[] = new int[]{1, 4, 5, 9, 1} ;
        System.out.println(findMinOperation(a));
    }
    public static int findMinOperation(int[] a)
    {
        int ans=0;
        int n = a.length;
        for(int i=0,j=n-1;i<=j;)
        {
            if(a[i]==a[j])
            {
                i++;
                j--;

            }
            else if (a[i ]> a[j])
            {
                j--;
                a[j]+=a[j+1];
                ans++;
            }
            else
            {
                i++;
                a[i]+=a[i-1];
                ans++;
            }
        }
        return ans;
    }
}
