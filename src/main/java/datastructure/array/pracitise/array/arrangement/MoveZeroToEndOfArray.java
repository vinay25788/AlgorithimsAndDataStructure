package datastructure.array.pracitise.array.arrangement;

import java.util.Arrays;

public class MoveZeroToEndOfArray {
    public static void main(String[] args) {
        int[] a ={1,0,2,0,3,0};
        moveZero(a);
    }
    public static void moveZero(int[] a)
    {
        int count=0;
        for(int i=0;i<a.length;i++)
        {
            if(a[i] !=0)
            {
                int temp = a[i];
                a[i] = a[count] ;
                a[count]    = temp;
                count++;
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
