package datastructure.array.pracitise.array.arrangement;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] a ={1,2,3,4,5,6};
        reverse(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
    public static void reverse(int[] a,int start,int end)
    {
        if(end<start)
        {
            return;
        }
        int temp = a[start];
        a[start]    = a[end];
        a[end]  = temp;
        reverse(a,start+1,end-1);

    }
}
