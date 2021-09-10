package practice.datastructure.array.arrangement;

import java.util.Arrays;

public class MoveAllZeroToEnd {
    public static void main(String[] args) {
        int a[] = {0,2,0,4,0,1,3,0};
        reArrange(a);
    }
    public static void reArrange(int[] a)
    {
        int n = a.length;
        int id = n-1;
        for(int i=n-1;i>=0;i--)
        {
            if(a[i]==0)
            {
                int temp =a [i];
                a[i] = a[id]    ;
                a[id] = temp;
                id--;
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
