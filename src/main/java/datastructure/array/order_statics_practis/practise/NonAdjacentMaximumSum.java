package datastructure.array.order_statics_practis.practise;

public class NonAdjacentMaximumSum {
    public static void main(String[] args) {
        int[] a = {5, 5, 10, 100, 10, 5};
        findMaximumSum(a);
    }
    public static void findMaximumSum(int[] a)
    {
        int excl =0, incl =0,excl_new=0;
        incl = a[0];
        int n = a.length;
        for(int i=0;i<n;i++)
        {
            excl_new = incl>excl ? incl:excl;
            incl = excl+a[i];
            excl = excl_new;
        }
        System.out.println(Math.max(excl,excl_new));
    }
}
