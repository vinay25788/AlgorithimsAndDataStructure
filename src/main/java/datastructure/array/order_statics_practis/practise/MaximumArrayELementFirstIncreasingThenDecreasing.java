package datastructure.array.order_statics_practis.practise;

public class MaximumArrayELementFirstIncreasingThenDecreasing {
    public static void main(String[] args) {
        int[] a= {1, 3, 50, 10, 9, 7, 6};
        System.out.println("Maximum Element "+findMax(a,0,a.length-1));
    }
    public static int findMax(int[] a,int l,int h)
    {
        if(a[l] == a[h])
            return a[l];

        if(l == h+1 && a[l]> a[h])
            return a[l];
        if(l == h+1 && a[h]>a[l])
            return a[h];
        int mid = (l+h)/2;

        if(a[mid] > a[mid+1] && a[mid]>a[mid-1])
            return a[mid];

        if(a[mid] >a[mid+1] && a[mid]<a[mid-1])
            return findMax(a,l,mid-1);
        else
            return findMax(a,mid+1,h);

    }

}
