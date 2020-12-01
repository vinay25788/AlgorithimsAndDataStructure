package datastructure.array.sort;

import java.util.Arrays;

public class SortInWaveForm {
    public static void main(String[] args) {
        int[] a ={5,3,2,1,10,4};
        Arrays.sort(a);
        int n = a.length;
        for(int i=0;i<n;i+=2)
        {
            int temp = a[i];
            a[i] = a[i+1] ;
            a[i+1] = temp;
        }
        System.out.println(Arrays.toString(a));
    }
}
