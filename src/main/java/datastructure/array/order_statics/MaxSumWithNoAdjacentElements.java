package datastructure.array.order_statics;

public class MaxSumWithNoAdjacentElements {
    public static void main(String[] args) {
        int[] a = {5, 5, 10, 100, 10, 5};
        findSum(a);
    }
    /* logic
    excl_new = incl > excl ? incl : excl;
    incl = excl+a[i];
    excl = excl_new
     */
    public static void findSum(int[] a)
    {
        int incl=0,excl =0,excl_new=0;
        incl = a[0];
        int n = a.length;
        for(int i=1;i<n;i++)
        {
            excl_new = incl>excl?incl:excl;
            incl = excl+a[i];
            excl = excl_new;
        }
        System.out.println(incl>excl?incl:excl);
    }
}
