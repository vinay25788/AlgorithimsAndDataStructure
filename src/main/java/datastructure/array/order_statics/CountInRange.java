package datastructure.array.order_statics;

import java.util.Arrays;

public class CountInRange {
    public static void main(String[] args) {
        int[] a={1,2,3,4,5,2,2,4,5};
        int i=1,j=3;
        Arrays.sort(a);
        System.out.println(countInRange(a,i,j));
    }
    public static int countInRange(int[] a,int i,int j)
    {
        int n=a.length;
        return upperIndex(a,n,j) - lowerIndex(a,n,i)+1;

    }
    public static int upperIndex(int[] a,int n,int y)
    {
        int l=0, h = n-1;
        while(l<=h){
            int mid = (l+h)/2;
            if(a[mid]<=y)
                l = mid+1;
            else
                h = mid-1;
        }
        return h;
    }

    public static int lowerIndex(int[] a,int n,int x)
    {
        int l=0,h = n-1;
        while(l<=h)
        {
            int mid = (l+h)/2;
            if(a[mid]>=x)
                h = mid-1;
            else
                l = mid+1;
        }
        return l;
    }
}
