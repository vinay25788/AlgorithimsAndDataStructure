package datastructure.array.sort;

import java.util.Arrays;

public class SortTwoDifferentTypeOfElements {
    public static void main(String[] args) {
        int a[] = { 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1 };
        int low=0,high = a.length-1;
        int ind=0;
        while(low<=high)
        {
            if(a[low]==0)
            {
                a[ind] = a[low];
                ind++;
            }
            low++;

        }
        while(ind<=high)
            a[ind++] =1;
        System.out.println(Arrays.toString(a));
    }
}
