package datastructure.array.arragement_rearrangement;

import java.util.Arrays;

public class EvenPositionGreaterThanOdd {
    public static void main(String[] args) {
        int[] a={1,2,3,4,5,6,7,8,9};
        reArrange(a);
    }
    public static void reArrange(int[] a)
    {
        Arrays.sort(a);
        int l =0, h= a.length-1;
        int[] ans = new int[h+1];
        for( int i=0;i<a.length;i++)
        {
            if(i %2 ==0)
                ans[i] = a[h--];
            else
                ans[i] = a[l++];
        }
        System.out.println(Arrays.toString(ans));

    }
}
