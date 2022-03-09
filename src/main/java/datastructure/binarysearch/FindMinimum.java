package datastructure.binarysearch;

public class FindMinimum {

    public static int findMin(int[] nums) {


        int l =0;
        int h = nums.length-1;

        return search(nums,l,h);
    }

    private static int search(int[] a,int l,int h)
    {
        if(l>h)
            return -1;
        if(l==h)
            return a[l];
        int mid = (l+(h-l)/2);

        if(mid ==0 && a[mid]<a[mid+1])
            return a[mid-1];


        if((mid>1 && a[mid] < a[mid-1]) && (mid<h && a[mid] < a[mid+1]))
            return a[mid];

        if(a[mid]<a[h])
        {
            return search(a,l,mid-1);
        }
        else
            return search(a,mid+1,h);
    }

    public static void main(String[] args) {
        int[] a ={1,2};
        System.out.println(findMin(a));
    }
}
