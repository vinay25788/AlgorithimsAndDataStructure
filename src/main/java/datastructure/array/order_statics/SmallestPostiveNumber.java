package datastructure.array.order_statics;

public class SmallestPostiveNumber {
    public static void main(String[] args) {
        int[] a = {0, 10, 2, -10, -20};
        findPositive(a);
    }
    public static void findPositive(int[] a)
    {
        int n = a.length;
        boolean[] present = new boolean[n];
        for(int i=0;i<n;i++)
        {
            if(a[i] >0 && a[i]<=n)
            {
                present[a[i]] = true;
            }
        }
        for(int i=1;i<=n;i++)
        {
            if(!present[i])
            {
                System.out.println(i);
                return;
            }
            System.out.println(i+1);
            return;

        }
    }
}
