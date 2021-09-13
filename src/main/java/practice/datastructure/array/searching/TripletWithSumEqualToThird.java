package practice.datastructure.array.searching;

import java.util.Arrays;

public class TripletWithSumEqualToThird {
    public static void main(String[] args) {
        int a[] = { 5, 32, 1, 7, 10, 50, 19, 21, 2 };
        findTriplet(a)  ;

    }
    public static void findTriplet(int[] a)
    {
        int n = a.length;
        Arrays.sort(a);
        for(int i=n-1;i>=0;i--)
        {
            int j=0,k = n-2;
            while(j<k)
            {
                if(a[j]+a[k] == a[i])
                {
                    System.out.println(a[i]+" "+a[j]+" "+a[k]);
                    return;
                }
                else if (a[i]>a[k]+a[j])
                    j++;
                else
                    k--;
            }
        }
    }
}
