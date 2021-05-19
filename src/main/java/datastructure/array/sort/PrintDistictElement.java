package datastructure.array.sort;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PrintDistictElement {
    public static void main(String[] args) {
        int[] a= {1,2,1,2,3,4,4};
        print(a);
        System.out.println(" ");
        printDistinct(a);
    }

    public static void printDistinct(int[] a)
    {
        Arrays.sort(a);
        int n = a.length;
        for(int i=0;i<n;i++)
        {
            while(i<n-1 && a[i] == a[i+1])
                i++;
            System.out.print(a[i]+ " ");
        }
    }
    public static void print(int[] a)
    {
        Set<Integer> set = new HashSet<>();

        for(int el:a)
        {
           if(!set.contains(el))
           {
               set.add(el);
               System.out.print(" "+ el);
           }
        }

    }
}
