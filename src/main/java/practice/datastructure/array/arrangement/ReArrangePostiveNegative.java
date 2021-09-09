package practice.datastructure.array.arrangement;

import java.util.Arrays;

public class ReArrangePostiveNegative {
    public static void main(String[] args) {
        int[] a ={1,-2,-3,-4,6,-0,-23,11,33,-45,3,4,5};
        reArrange(a);
    }
    public static void reArrange(int[] a)
    {
        int pos = arrangeNegative(a);
        int neg =0;
        while(neg<pos && a[neg]<0)
        {
            int temp = a[pos];
            a[pos] = a[neg];
            a[neg] = temp;
            pos++;
            neg=neg+2;
        }
        System.out.println(Arrays.toString(a));
    }
    public static int arrangeNegative(int[] a)
    {
        int id =0;
        int n = a.length;
        for(int i=0;i<n;i++)
        {
            if(a[i]<0)
            {
                int temp = a[i];
                a[i] = a[id];
                a[id] = temp;
                id++;
            }
        }
        return id;
    }
}
