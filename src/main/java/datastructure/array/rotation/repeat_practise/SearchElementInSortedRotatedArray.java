package datastructure.array.rotation.repeat_practise;

public class SearchElementInSortedRotatedArray {
    public static void main(String[] args) {
        int[] a= new int[] {4,5,1,2,3};
        int key = 5;
        int index = findElement(a,0,a.length-1,key);
        if(index == -1)
            System.out.println("not found");
        else
            System.out.println("found  "+index);
    }
    public static int findElement(int[] a,int l,int h,int key)
    {
            if(l>h)
                return -1;
            int mid = (l+h)/2;
            if(a[mid] == key)
                return mid;
            if(a[l]<=a[mid])
            {
                if(key>=a[l] && key<=a[mid])
                    return findElement(a,l,h-1,key);
                return findElement(a,mid+1,h,key);
            }
            if(key>=a[mid] && key<=a[h])
                return findElement(a,mid+1,h,key);
            return findElement(a,l,mid-1,key);

    }
}
