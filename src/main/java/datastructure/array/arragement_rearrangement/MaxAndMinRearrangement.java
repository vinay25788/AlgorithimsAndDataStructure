package datastructure.array.arragement_rearrangement;

import java.util.Arrays;

public class MaxAndMinRearrangement {
    public static void main(String[] args) {
        int[] a= {1,2,3,4,5,6,7};
        reArrange(a);
        System.out.println(Arrays.toString(a));
    }
    public static void reArrange(int[] a)
    {
        int max_id = a.length-1;
        int max_element = a[max_id]+1;
        int min_id = 0;
        for(int i=0;i<a.length;i++)
        {
            if(i %2 ==0)
            {
                a[i]+= (a[max_id] %max_element) * max_element;
                max_id--;
            }
            else
            {
                a[i]+= (a[min_id] %max_element) * max_element;
                min_id++;
            }
        }
        for(int i=0;i<a.length;i++)
            a[i] = a[i]/max_element;
    }
}
