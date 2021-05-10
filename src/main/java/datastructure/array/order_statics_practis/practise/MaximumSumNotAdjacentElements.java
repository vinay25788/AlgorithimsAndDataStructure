package datastructure.array.order_statics_practis.practise;

public class MaximumSumNotAdjacentElements {
    public static void main(String[] args) {
        int[] a = {5, 5, 10, 100, 10, 5};
        findMax(a);
    }
    public static void findMax(int[] a)
    {
        int incl=0,excl=0;
        incl+=a[0];
        for(int i=1;i<a.length;i++)
        {
            int excl_new = Math.max(incl,excl);
            incl = excl+a[i];
            excl = excl_new;
        }
        System.out.println( "maximum-->"+Math.max(incl,excl));
    }
}
