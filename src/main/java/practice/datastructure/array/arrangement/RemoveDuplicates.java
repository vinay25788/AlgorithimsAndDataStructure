package practice.datastructure.array.arrangement;

import java.util.Arrays;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] a ={1,2,2,2,2,3,3,3,3,6,8};
        remove(a);
    }
    public static void remove(int[] a)
    {
        int id = 0;
        int n = a.length;
        for(int i=0;i<n-1;i++)
        {
            if(a[i] != a[i+1])
                a[id++] = a[i];
        }
            a[id++] = a[n-1];

        for(int i=0;i<id;i++)
            System.out.print(a[i]+ " ");
    }
}
