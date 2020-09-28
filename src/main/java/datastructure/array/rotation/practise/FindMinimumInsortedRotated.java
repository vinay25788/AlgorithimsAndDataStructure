package datastructure.array.rotation.practise;

public class FindMinimumInsortedRotated {
    public static void main(String[] args) {
        int[] a={5, 6, 1, 2, 3, 4};
        System.out.println(findMin(a,0,a.length-1));
    }
    public static int findMin(int[] a,int low,int high)
    {
        if(high<low)
            return a[low];
        if(high ==low)
            return a[low];
        int mid = (low+high)/2;
        if(mid>0 && mid< high && a[mid] <a[mid-1] && a[mid ]< a[mid+1])
            return a[mid];
        if(a[mid] < a[high])
            return findMin(a,0,mid-1);
        return findMin(a,mid+1,high);

    }
}
