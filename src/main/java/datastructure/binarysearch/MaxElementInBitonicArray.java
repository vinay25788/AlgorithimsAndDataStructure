package datastructure.binarysearch;

public class MaxElementInBitonicArray {
    public static void main(String[] args) {
        int[] a ={3,5,7,9,4,3};
        System.out.println(findMax(a));
    }

    public static int findMax(int[] a)
    {
        int start = 0;
        int end = a.length-1;
        while(start<=end)
        {
            int mid = start + (end - start)/2;


                if(a[mid]>a[mid-1] && a[mid]>a[mid+1])
                    return mid;
                else if(a[mid] > a[mid-1])
                    start = mid+1;
                else
                    end = mid-1;

             if( mid ==0)
            {
                if(a[0]>a[1])
                    return 0;
                else
                    return 1;
            }
            else if ( mid == a.length-1)
            {
                if(a[a.length-1]>a[a.length-2])
                    return a.length-1;

            }
        }
        return -1;
    }
}
