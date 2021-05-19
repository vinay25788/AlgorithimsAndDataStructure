package datastructure.array.order_statics_practis.practise;

public class KthLargestElementUsingMinHeap {
    public static void main(String[] args) {
        int[] a={1,3,5,7,9,4,6};
        int k=4;
        kthLargestElement(a,k);
        System.out.println(a[0]);
    }
    public static void kthLargestElement(int[] a,int k)
    {
        int n = a.length;

        for(int i=k;i>=0;i--)
            minHeap(a,i,n);

        for(int i=k;i<n;i++)
        {
            if(a[i]>a[0])
            {
                a[0] = a[i];
                minHeap(a,0,k);
            }
        }
    }

    public static void minHeap(int[] a,int i,int n)
    {
        int first = 2 * i+1;
        int second = 2 * i +2;
        int smallest = i;
        if( first < n && a[i]>a[first])
            smallest = first;
        if( second < n && a[smallest]> a[second])
            smallest = second;
        if( i != smallest)
        {
            int temp = a[i];
            a[i] = a[smallest];
            a[smallest] = temp;
            minHeap(a,smallest,n);
        }
    }
}
