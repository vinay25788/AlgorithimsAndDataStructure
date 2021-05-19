package datastructure.array.searching_and_sorting;

import java.util.Arrays;

public class TripletSumTwoEqualToThirdElement {
    public static void main(String[] args) {
        int[] a ={ 5, 32, 1, 7, 10, 50, 19, 21, 2};
        findTriplet(a);
    }
    public static void findTriplet(int[] a)
    {
        int n = a.length;
        Arrays.sort(a);
        for(int i=n-1;i>=0;i--)
        {
            int j=0,k=i-1;
            while(j<k)
            {
                if(a[i] == a[j]+a[k])
                {
                    System.out.println(" first  "+a[i]+" second "+a[j]+" third "+a[k]);
                    return;
                }
                else if ( a[i]> a[j]+a[k])
                    j++;
                else
                    k--;
            }

        }
        System.out.println(" no such triplet");
    }
}
