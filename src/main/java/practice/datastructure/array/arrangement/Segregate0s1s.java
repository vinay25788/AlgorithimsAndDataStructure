package practice.datastructure.array.arrangement;

import java.util.Arrays;

public class Segregate0s1s {
    public static void main(String[] args) {
        int[] a ={1,0,1,1,0,1,0,1};
        segregate(a);
    }
    public static void segregate(int[] a)
    {
        int left =0,right = a.length-1;

        while(left<right)
        {
                while(a[left] ==0 && left < a.length)
                    left++;
                while(a[right] == 1 && right<a.length )
                    right--;
                if(left<right)
                {
                    int temp = a[left];
                    a[left] = a[right];
                    a[right] = temp;
                    left++;
                    right--;
                }
        }
        System.out.println(Arrays.toString(a));

    }
}
