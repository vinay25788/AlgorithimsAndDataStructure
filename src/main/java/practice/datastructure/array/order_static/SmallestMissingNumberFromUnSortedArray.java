package practice.datastructure.array.order_static;

public class SmallestMissingNumberFromUnSortedArray {
    public static void main(String[] args) {
        int a[] = { 0, 10, 2, -10, -20 };
        findMissingNumber(a);
    }
    public static void findMissingNumber(int[] a)
    {
        int n = a.length;
        boolean[] present = new boolean[n+1];

        for(int i=0;i<n ;i++)
        {
            if(a[i]>0 && a[i]<=n)
                present[a[i]] = true;
        }
        for(int i=1;i<=n;i++)
            if(!present[i])
            {
                System.out.print(i+" ");
                return;
            }

        System.out.println(n+1);
    }
}
