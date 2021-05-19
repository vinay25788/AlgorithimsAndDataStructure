package datastructure.array.searching_and_sorting;

import java.util.HashSet;
import java.util.Set;

public class FirstNonRepeatingElement {
    public static void main(String[] args) {
        int[] a={10, 5, 3, 4, 3, 3, 5,3};
        findFirstRepeatingElement(a);

    }
    public static void findFirstRepeatingElement(int[] a)
    {
        int n = a.length;
        Set<Integer> set = new HashSet<>();
        int min=-1;
        for(int i=n-1;i>=0;i--)
        {
            if(set.contains(a[i]))
            {
                min = i;
            }
            else
                set.add(a[i]);
        }
        if(min != -1)
            System.out.println(" repeating "+a[min]);
    }
}
