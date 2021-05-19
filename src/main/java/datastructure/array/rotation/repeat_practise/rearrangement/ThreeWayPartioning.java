package datastructure.array.rotation.repeat_practise.rearrangement;

import java.util.Arrays;

public class ThreeWayPartioning {
    public static void main(String[] args) {
        int[] a = {1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32};

        int lo = 10;
        int hi = 20;
        threeWayPartioning(a,lo,hi);
        System.out.println(Arrays.toString(a));
    }

    public static void threeWayPartioning(int[] a,int lo,int hi)
    {

        int n = a.length;

        int start =0,end = n-1;

        for(int i=0;i<=end;)
        {
            if(a[i] < lo)
            {
                int temp = a[i];
                a[i] = a[start];
                a[start] = temp;
                start++;
                i++;
            }
            else if (a[i] > hi)
            {
                int temp = a[i];
                a[i] = a[end];
                a[end] = temp;
                end--;
            }
            else
            {
                i++;
            }
        }
    }
}
