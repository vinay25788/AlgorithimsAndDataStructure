package practice.datastructure.array.searching;

import java.util.HashSet;
import java.util.Set;

public class SumOfNonRepeatingNumber {
    public static void main(String[] args) {
        int[] a ={1, 2, 3, 1, 1, 4, 5, 6};
        findSum(a);
    }
    public static void findSum(int[] a)
    {
        Set<Integer> set = new HashSet<>();
        int n = a.length;
        int sum =0;
        for(int i=0;i<n;i++)
        {
            if(!set.contains(a[i]))
            {
                sum +=a[i];
                set.add(a[i]);
            }


        }
        System.out.println(sum);
    }
}
