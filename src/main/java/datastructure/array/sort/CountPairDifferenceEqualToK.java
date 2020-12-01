package datastructure.array.sort;

import java.util.Arrays;

public class CountPairDifferenceEqualToK {
    public static void main(String[] args) {
        int [] a= new int[]{ 5,3,1,7,9,13,15};
        int k =2;
        System.out.println("count -------->"+findCount(a,k));
    }
    public static int findCount(int [] a,int k)
    {
        Arrays.sort(a);
        int l =0,h = 0,count =0,n = a.length-1;
        System.out.println(Arrays.toString(a));
        while(h<n)
        {
            if(a[h] - a[l] == k)
            {
                count++;
                l++;
                h++;
            }
            else if ( a[h] - a[l] > k )
                l++;
            else
                h++;
        }
        return count;
    }

}
