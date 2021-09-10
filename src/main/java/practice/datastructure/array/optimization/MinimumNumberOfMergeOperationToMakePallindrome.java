package practice.datastructure.array.optimization;

public class MinimumNumberOfMergeOperationToMakePallindrome {
    public static void main(String[] args) {
        int a[] = new int[]{1, 4, 5, 9, 1} ;
        mergeOperation(a);
    }
    public static void mergeOperation(int[] a)
    {
        int op =0,n = a.length;
        for(int i=0,j=n-1;i<=j;)
        {
            if(a[i] == a[j])
            {
                i++;
                j--;
            }
            else if ( a[i]>a[j])
            {
                j--;
                a[j] +=a[j+1];
                op++;
            }
            else
            {
                i++;
                a[i]+=a[i-1];
                op++;
            }
        }
        System.out.println(op);
    }
}
