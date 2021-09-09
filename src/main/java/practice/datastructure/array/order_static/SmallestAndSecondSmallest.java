package practice.datastructure.array.order_static;

public class SmallestAndSecondSmallest {
    public static void main(String[] args) {
        int[] a ={10,2,3,4,510,23,31};
        find(a);
    }
    public static void find(int[] a)
    {
        int first = Integer.MAX_VALUE,second= Integer.MAX_VALUE,n = a.length;
        for(int i=0;i<n;i++)
        {
            if(a[i]<first)
            {
                second = first;
                first = a[i];
            }
            else if ( a[i]<second && a[i] != first)
            {
                second = a[i];
            }
        }
        System.out.println(first+" "+second);
    }
}
