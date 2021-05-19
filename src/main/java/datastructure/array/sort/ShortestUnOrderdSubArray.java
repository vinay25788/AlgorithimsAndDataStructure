package datastructure.array.sort;

public class ShortestUnOrderdSubArray {
    public static void main(String[] args) {
        int a[] = new int[]{7, 9, 10, 8, 11};
        System.out.println("length of the unsorted array -->"+findLength(a));
    }
    public static int findLength(int[] a)
    {
        int n  = a.length;
        if(increasing(a,n) == true || decreasing(a,n) == true)
        {
            return 0;
        }
        else
            return 3;
    }

    public static boolean increasing(int[] a,int n)
    {

        for(int i=0;i<n;i++)
        {
            if(a[i]>=a[i+1])
                return false;
        }
        return true;
    }
    public static boolean decreasing(int[] a,int n)
    {

        for(int i=0;i<n;i++)
        {
            if(a[i]<=a[i+1])
                return false;
        }
        return true;
    }
}
