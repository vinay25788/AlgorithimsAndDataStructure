package practice.datastructure.array.arrangement;

import java.util.Arrays;

public class SegregateEvenOdd {
    public static void main(String[] args) {
        int[] a ={1,2,3,4,5,6,7};
        segrage(a);
    }
    public static void segrage(int[] a)
    {
        int n = a.length;
        int id= n-1;
        for(int i=id;i>=0;i--)
        {
            if(a[i]%2 !=0)
            {
                int temp = a[i];
                a[i] = a[id];
                a[id]    = temp;
                id--;
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
