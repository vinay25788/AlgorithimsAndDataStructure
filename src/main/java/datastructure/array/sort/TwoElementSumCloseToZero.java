package datastructure.array.sort;

import java.util.Arrays;

public class TwoElementSumCloseToZero {
    public static void main(String[] args) {
        int[] a={1,5,4,2,7,-3,-9};
        findPair(a);
    }
    public static void findPair(int[] a)
    {
        Arrays.sort(a);
        int l=0,h = a.length-1;
        int sum=0,minSum = Integer.MAX_VALUE;
        int first=-1,second=-1;
        while(l<h)
        {
            sum = a[l]+a[h];
            if(Math.abs(sum)<Math.abs(minSum)){
                System.out.println(" "+a[l]+" "+a[h]+" "+Math.abs(sum));
             minSum = sum;
             first = l;
             second = h;
             l++;
             h--;
            }
            else if ( sum<0)
                l++;
            else
                h--;
        }
        System.out.println(" first "+a[first]+" second "+a[second]);
    }
}
