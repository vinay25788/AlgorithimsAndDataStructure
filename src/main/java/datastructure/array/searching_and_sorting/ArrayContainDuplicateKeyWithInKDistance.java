package datastructure.array.searching_and_sorting;

import java.util.HashSet;
import java.util.Set;

public class ArrayContainDuplicateKeyWithInKDistance {
    public static void main(String[] args) {
        int[] a ={1, 2, 3, 4, 4};
        int k =3;
        find(a,k);
    }
    public static void find (int[] a,int k)
    {
        Set<Integer> set = new HashSet<>();
        int n = a.length;
        for(int i=0;i<n;i++)
        {
            if(set.contains(a[i]))
            {
                System.out.println(" true ");
                return;
            }

                if(i>=k)
                    set.remove(a[i]);
                set.add(a[i]);
        }
    }
}
