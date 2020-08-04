package datastructure.array.searching_and_sorting;

public class FindInSortedRotated {
    public static void main(String[] args) {
        int[] a = {5,1,2,3,4};
        int key = 4;
        System.out.println(findKey(a,key,0,a.length-1));
    }

    public static int findKey(int[] a,int key,int low,int high)
    {
        if(low>high)
            return -1;
        int mid = (low+high)/2;
        if(a[mid] == key)
            return mid;
        if(a[low] <= a[mid])
        {
            if(a[low]<= key && a[mid]>= key)
                return findKey(a,key,0,mid-1);
            else
                return findKey(a,key,mid+1,high);
        }
        else if(a[mid] <= key && a[high]>= key)
            return findKey(a,key,mid+1,high);

        return findKey(a,key,0,mid-1);

    }
}
