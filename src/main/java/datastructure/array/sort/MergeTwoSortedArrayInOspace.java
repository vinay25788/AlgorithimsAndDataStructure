package datastructure.array.sort;


import java.util.Arrays;
import java.util.Calendar;

public class MergeTwoSortedArrayInOspace {
    public static void main(String[] args) {
        int[] a1 = {1,5,9,10,15,20};
        int[] a2 = {2,3,8,13};
        merge(a1,a2);
        System.out.println(Arrays.toString(a1)+" "+Arrays.toString(a2));
        Calendar cl = Calendar.getInstance();
        Boolean bo = Boolean.valueOf("false");
        Double d = Double.valueOf(11.1);
        Integer in = Integer.valueOf(11);
        Integer in2 = Integer.valueOf(11);
        System.out.println("in   "+in+"     in2     "+in2);
        in2 = 12;
        System.out.println("in   "+in+"     in2     "+in2);
    }
    public static void merge(int[] a1,int[] a2)
    {
        int m= a1.length;
        int n = a2.length;
        for(int i=n-1;i>=0;i--)
        {
            int j,last = a1[m-1];
            for(j=m-2; j>=0 && a1[j]>a2[i];j--)
            {
                a1[j+1] = a1[j];
            }
            if(j != m-2 || last >a2[i])
            {
                a1[j+1] = a2[i];
                a2[i] = last;

            }
        }
    }
}
