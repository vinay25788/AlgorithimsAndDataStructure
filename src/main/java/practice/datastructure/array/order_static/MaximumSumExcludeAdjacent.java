package practice.datastructure.array.order_static;

public class MaximumSumExcludeAdjacent {
    public static void main(String[] args) {
        int[] a =new int[]{5, 5, 10, 100, 10, 5};

        findSum(a);
    }
    public static void findSum(int[] a)
    {
        int incl =a[0];
        int excl_new =0,n = a.length;
        int excl =0;
        for(int i=1;i<n;i++)
        {
             excl_new = incl > excl ? incl :excl;

             incl = excl+a[i];
            excl = excl_new;
        }

        System.out.println(incl>excl?incl:excl);
    }
}
