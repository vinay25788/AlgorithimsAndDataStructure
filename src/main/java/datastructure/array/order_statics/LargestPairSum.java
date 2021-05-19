package datastructure.array.order_statics;

public class LargestPairSum {
    public static void main(String[] args) {
        int[] a={2,3,10,15,25,2,1,3,50};
        findLargestPairSum(a);
    }
    public static void findLargestPairSum(int[] a)
    {
        int first=0,second=0;
        int n = a.length;
        for(int i=0;i<n;i++)
        {
            if(a[i]>first)
            {
                second = first;
                first = a[i];
            }
            else if ( a[i]> second && a[i] != first)
            {
                second = a[i];
            }
        }
        System.out.println(" first "+first+" second "+second+ " sum "+(first+second));

    }
}
