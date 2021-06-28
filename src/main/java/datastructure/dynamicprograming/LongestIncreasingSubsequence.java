package datastructure.dynamicprograming;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] a = {3,4,-1,0,6,2,3};
        find(a);
    }
    public static void find(int[] a)
    {
        int[] T = new int[a.length];
        int max=Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++)
            T[i] = 1;
        for(int i=1;i<a.length;i++)
        {
            for(int j=0;j<i;j++)
                if(a[i]>a[j])
                {
                    T[i] = Math.max(T[i],1+T[j] );
                    if(max<T[i])
                        max = T[i];
                }
        }
        System.out.println(max);
    }
}
