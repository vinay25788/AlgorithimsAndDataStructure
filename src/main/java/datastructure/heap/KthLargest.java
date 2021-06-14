package datastructure.heap;

public class KthLargest {
    public static void main(String[] args) {
        int[] a = { 11, 3, 2, 1, 15, 5, 4,
                45, 88, 96, 50, 45 };
        int k = 3;
        findKth(a,k);

    }
    public static void findKth(int[] a,int k)
    {
        int n = a.length;
        for(int i=k-1;i>=0;i--)
            heapify(a,i,n);
        for(int i = n-1;i>=k;i--)
        {
            if(a[i]>a[0])
            {
                int temp = a[i];
                a[i] = a[0];
                a[0] = temp;
                heapify(a,0,i);
            }
        }
        for(int i=0;i<k;i++)
        System.out.print(" "+a[i]);
    }
    public static void heapify(int[] a,int i,int n)
    {
        int first = 2 *i+1;
        int second = 2 *i +2;
        int smallest = i;
        if(first< n && a[first] < a[i])
            smallest = first;
        if( second < n && a[second] < a[smallest])
            smallest = second;
        if(smallest != i)
        {
            int temp = a[smallest];
            a[smallest] = a[i];
            a[i] = temp;
            heapify(a,smallest,n);
        }
    }
}
