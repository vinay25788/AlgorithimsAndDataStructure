package practice.datastructure.array.searching;

import java.util.HashSet;
import java.util.Set;

public class CheckDuplicateWithInKDistance {
    public static void main(String[] args) {
        int[] a = {10, 5, 3, 4, 3, 5, 6};
        int k=2;
        checkDuplicate(a,k);
    }
    public static void checkDuplicate(int[] a,int k)
    {
        Set<Integer> set = new HashSet<>();
        int n = a.length;
        for(int i=0;i<n;i++)
        {
            if(set.contains(a[i]))
            {
                System.out.println("found "+a[i]);
                return;
            }
            set.add(a[i]);
            if(i>=k)
                set.remove(a[i-k]);
        }
    }
}
