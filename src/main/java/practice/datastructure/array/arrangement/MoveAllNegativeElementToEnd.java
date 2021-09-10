package practice.datastructure.array.arrangement;

import java.util.Arrays;

public class MoveAllNegativeElementToEnd {

    public static void main(String[] args) {
        int[] a ={-1,-2,2,-3,10,-11};
        reArrange(a);
    }
    public static void reArrange(int[] a)
    {
        int n = a.length;
        int id = n-1;
        int temp =0;
        for(int i=n-1;i>=0;i--)
        {
            if(a[i]<0)
            {
                temp = a[i];
                a[i] = a[id];
                a[id] = temp;
                id--;
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
