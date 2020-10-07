package datastructure.array.order_statics;


//find-the-maximum-element-in-an-array-which-is-first-increasing-and-then-decreasing/
public class FindElementFirstIncreasingThenDecreasing {
    public static void main(String[] args) {
        int a[] = {1, 3, 50, 10, 9, 7, 6};
        System.out.println(find(a, 0, a.length - 1));
    }

    public static int find(int[] a, int low, int high) {
        if (low == high)
            return a[low];
        if (high == low + 1 && a[low] >= a[high])
            return a[low];
        if (high == low + 1 && a[high] >= a[low])
            return a[high];
        int mid = (low+high)/2;
        if(a[mid] >a[mid+1] && a[mid] > a[mid-1])
            return a[mid];
        if(a[mid] >a[mid+1] && a[mid] < a[mid-1] )
            return find(a,low,mid-1);
        else
            return find(a,mid+1,high);
    }
}
