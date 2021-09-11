package practice.datastructure.array.searching;

import java.util.HashSet;
import java.util.Set;

public class FirstRepeatingElemenent {
    public static void main(String[] args) {
        int a[] ={6, 10, 5, 4, 9, 120, 4, 6, 10};
        findFirstRepeating(a);
        firstRepeatingUsingArray(a);
    }

    public static void firstRepeatingUsingArray(int[] a)
    {
        int n = a.length;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            if(max<a[i])
                max = a[i];
        }
        int temp[] = new int[max+1];
        for(int i=0;i<n;i++)
        {
            temp[a[i]]++;
        }

        for(int i=0;i<n;i++)
        {
            if(temp[a[i]]>1)
            {
                System.out.println(a[i]);
                return;
            }
        }
    }
    public static void findFirstRepeating(int[] a)
    {
        Set<Integer> set = new HashSet<>();
        int ind=0;

        for(int i = a.length-1;i>=0;i--)
        {
            if(set.contains(a[i]))
            {
                ind = i;

            }
            set.add(a[i]);
        }
        System.out.println(a[ind]);
    }
}
