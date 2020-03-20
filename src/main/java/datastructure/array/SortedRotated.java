package datastructure.array;

public class SortedRotated {

    public static void main(String[] args) {
        int[] a=    {3,4,5,1,2};
        int[] b= {1,2,3,4,5};
        int[] c= {4,5,1,2,3};
        int[] d = {5,1,2,3,4};
        int element = 4;
        int index = search(d,element,0,4);
        if(index ==-1)
            System.out.println("not found");
        else
            System.out.println("found at "+index);
    }


    private static int search(int[] a,int key,int low,int high)
    {
        System.out.println("inside the function  ");
        if(high <low)
            return -1;

        int mid = (low+high)/2;
        if(a[mid] == key)
            return mid;

        if(a[low]<=a[mid])
        {
            if(key>=a[low] && key<=a[mid])
                return search(a,key,low,mid-1);
            return search(a,key,mid+1,high );
        }


            if(key>=a[mid] && key<=a[high])
                return search(a,key,mid+1,high);

            return search(a,key,low,mid-1);

    }
}
