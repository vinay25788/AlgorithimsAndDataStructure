package datastructure.array.searching_and_sorting;

import java.util.HashSet;
import java.util.Set;

public class SumOfNonRepeatingInArray {
    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 1, 1, 4, 5, 6};
        findSum(arr);
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
        System.out.println(" sum -->"+sum);
    }
}
