package practice.datastructure.array.rotation;

public class SearchInSortedRotated {
    public static void main(String[] args) {
        int[] a ={1,2,3,4,5,6};
        int key = 3;
        System.out.println("element present at index ---> "+search(a,0,a.length-1,key));
    }
    public static int search(int[] a,int l,int h,int key)
    {
        if(l>h)
            return -1;
        else
        {
            if(l==h && a[l] == key)
                return l;
            else if(a[l] == key)
                return l;
            else if ( a[h] == key)
                return h;
            else {
                int mid = (l + h) / 2;
                if (a[mid] == key)
                    return mid;
                if(a[l]<= a[mid])
                {
                    if(key>=a[l] && key<=a[mid])
                        return search(a,l,mid-1,key);
                    return search(a,mid+1,h,key);
                }
                if(key>=a[mid] && key<=a[h])
                    return search(a,mid+1,h,key);
                return search(a,l,mid-1,key);
            }
        }
    }
}
