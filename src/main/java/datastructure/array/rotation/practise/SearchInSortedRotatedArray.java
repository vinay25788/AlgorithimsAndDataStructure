package datastructure.array.rotation.practise;

public class SearchInSortedRotatedArray {

    public static void main(String[] args) {
        //input = 3,4,5,1,2
        int a[] = {3,4,5,1,2};
        int key = 2;
        System.out.println("key present at index ----->"+  search(a,0,a.length-1,key));
    }

    public static int search(int[] a,int low,int high,int key)
    {
        if(low>high)
            return -1;
        int mid =(low+high)/2;
        if(a[mid] == key)
            return mid;
        if(a[low] <= a[mid])
        {
                if(a[low]<= key && a[mid]>=key)
                    return search(a,low,mid-1,key);
                return search(a,mid+1,high,key);
        }
        else
            if(a[mid]<= key && a[high]>=key)
                return search(a,mid+1,high,key);
            return search(a,low,mid-1,key);

    }
}
