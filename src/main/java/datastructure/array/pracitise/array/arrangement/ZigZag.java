package datastructure.array.pracitise.array.arrangement;

import java.util.Arrays;

public class ZigZag {
    public static void main(String[] args) {
        int[] a ={1,2,3,4,5,6,7,8};
        zigzag(a);
    }
    public static void zigzag(int[] a)
    {
        int temp =0,n = a.length;
        boolean flag= true;
        for(int i=0;i<n-1;i++)
        {
            if(flag)
            {
                if(a[i]>a[i+1])
                {
                    temp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = temp;

                }
            }
            else
            {
                if(a[i]<a[i+1])
                {
                    temp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = temp;
                }
            }
            flag = !flag;
        }
        System.out.println(Arrays.toString(a));
    }
}
