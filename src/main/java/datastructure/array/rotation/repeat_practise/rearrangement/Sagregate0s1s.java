package datastructure.array.rotation.repeat_practise.rearrangement;

import java.util.Arrays;

public class Sagregate0s1s {
    public static void main(String[] args) {
        int[] a={0,1,0,0,0,1,0,1};
        sagregate(a);
        System.out.println(Arrays.toString(a));
    }
    public static void sagregate(int[] a)
    {
        int left=0,right = a.length-1;
        int temp =0;
        while(left < right)
        {
            while(a[left] ==0 && left<right)
                left++;
            while(a[right] ==1 && right>left)
                right--;
            if(left != right)
            {
                temp = a[left];
                a[left] = a[right];
                a[right] = temp;
            }
        }

    }
}
