package datastructure.array.rotation;

public class SortedRotatedUsingStandardBinarySearch {
    public static void main(String[] args) {
        int[] a=    {3,4,5,1,2};
        int[] b= {1,2,3,4,5};
        int[] c= {4,5,1,2,3};
        int[] d = {5,1,2,3,4};
        int key =1;
        System.out.println("element found at "+findThroughPivot(a,key));
    }

    public static int findThroughPivot(int[] a, int key)
    {
        int pivot = findPivot(a,0,a.length-1);
        if(pivot ==-1)
            return binarySearch(a,0,a.length-1,key);
        if(a[pivot ] == key )
            System.out.println("element found at "+pivot);
        if(a[0]<=key)
           return binarySearch(a,0,pivot-1,key);
      return  binarySearch(a,pivot+1,a.length-1,key);
    }

    public static int findPivot(int[] a,int low,int high)
    {
        if(high<low)
            return -1;
        int mid= (low+high)/2;
        if(mid<high && a[mid]>a[mid+1])
            return mid;
        if(mid > low && a[mid]<a[mid-1])
            return mid-1;
        if(a[low] >=a[mid])
            return findPivot(a,low,mid-1);
        return findPivot(a,mid+1,high);
    }

    public static int binarySearch(int[] a,int low,int high,int key)
    {
        if(high<low)
            return -1;
        int mid = (low+high)/2;
        if(key == a[mid])
            return mid;
        if(key>a[mid])
            return binarySearch(a,mid+1,high,key);
        return binarySearch(a,low,mid-1,key);
    }

}
