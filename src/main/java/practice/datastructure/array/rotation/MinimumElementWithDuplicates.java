package practice.datastructure.array.rotation;

public class MinimumElementWithDuplicates {
    public static void main(String[] args) {
        int[] a = {3,4,5,6,1,3,3};
        int key = 1;
        System.out.println(findKey(a,0,a.length,key));
    }
    public static int findKey(int[] a,int l,int h,int key)
    {
        if(h<l)
            return -1;
        int mid = (l+h)/2;
        if(a[mid] == key)
            return mid;
        if(a[l] == a[mid] && a[h] == a[mid])
        {
            l++;
            h--;
           return findKey(a,l,h,key);
        }
        else if (a[l]<=a[mid])
        {
            if(key>=a[l] && key<=a[mid])
                return findKey(a,l,mid-1,key);
            else
            return findKey(a,mid+1,h,key);
        }
        else
        {  if(key<=a[mid] && key<=a[h] )
                return findKey(a,mid+1,h,key);
            return findKey(a,l,mid-1,key);
        }
    }
}
