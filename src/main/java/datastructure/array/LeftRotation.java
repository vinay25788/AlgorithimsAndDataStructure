package datastructure.array;


import java.util.ArrayList;
import java.util.List;

public class LeftRotation {

    public static void main(String[] args) {
        int[] a={1,2,3,4,5,6,7};
        int length = a.length;
        leftRotate(a,0,1);
        leftRotate(a,2,length-1);
        leftRotate(a,0,length-1);
        System.out.println(a.toString());
        for(int el:a)
        {
            System.out.print(" "+el);
        }

    }

    public static void leftRotate(int[] a,int start,int end )
    {
        while(start<end)
        {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }
    }
}
