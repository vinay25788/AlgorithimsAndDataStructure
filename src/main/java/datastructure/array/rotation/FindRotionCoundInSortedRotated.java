package datastructure.array.rotation;

public class FindRotionCoundInSortedRotated {
    public static void main(String[] args) {
        int a[] = {  15, 18, 2, 3, 6, 12};
        System.out.println(findRotationCount(a,0,a.length-1));
    }
    public static int findRotationCount(int[] a,int low,int high)
    {
        if(high<low)
            return low;
        if(high == low)
            return high;
        int mid = (low+high)/2;
        if(mid>0 && mid < high && a[mid ]<a[mid-1] && a[mid]<a[mid+1])
            return mid;
        if(a[mid] < a[high])
            return findRotationCount(a,low,mid-1);
        return findRotationCount(a,mid+1,high);
    }
}
