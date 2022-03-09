package datastructure.binarysearch;

public class SearchInBitonicArray {
    public static void main(String[] args) {
        int[] a ={3,5,7,9,6,4,1};
        System.out.println(search(a,4));
    }

    public static int search(int[] a,int key)
    {
        int peakIndex = peak(a);
        System.out.println(peakIndex+"  peak ");
        System.out.println();
        int l = binarySearchAsc(a,0,peakIndex,key);
        if(l != -1)
            return l;
        return binarySearchDesc(a,peakIndex,a.length-1,key);
    }

    private static int binarySearchDesc(int[] a, int l, int h, int key) {
        if(l>h)
            return -1;
        while(l<=h) {
            int mid = (l + (h - l) / 2);
            if (a[mid] == key)
                return mid;
            else if (a[mid] > key)
                l = mid + 1;
            else
                h = mid - 1;
        }
        return -1;
    }

    public static int peak(int[] a)
    {
        int start =0;
        int end = a.length-1;
        while(start <= end)
        {
            int mid = (start +(end-start)/2);

            if(mid>0 && mid<a.length-1)
            {
                if(a[mid]>a[mid-1] && a[mid]>a[mid+1])
                    return mid;
                else if(a[mid]>a[mid-1])
                    start = mid+1;
                else
                    end = mid-1;
            }
            if(mid ==0)
            {
                if(a[0]>a[1])
                    return 0;
                else
                    return 1;

            }
            else if( mid == a.length-1)
            {
                if(a[a.length-1]>a[a.length-2])
                    return a.length-1;
                else
                    return a.length-2;
            }
        }
        return -1;
    }

    public static int binarySearchAsc(int[] a,int l,int h,int key)
    {
        if(l>h)
            return -1;
        while( l<= h) {
            int mid = (l + (h - l) / 2);
            if (a[mid] == key)
                return mid;
            else if (a[mid] < key)
                l = mid + 1;
            else
                h = mid - 1;
        }
        return -1;

    }

}
