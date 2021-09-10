package practice.datastructure.array.order_static;

public class ArrayElementsGreaterThanTwoElement {
    public static void main(String[] args) {
        int[] a ={ 2, -6, 3, 5, 1};
        findElements(a);
    }
    public static void findElements(int[] a)
    {
        int first=Integer.MIN_VALUE;
        int second = 0;
        int n = a.length;
        for(int i=0;i<n;i++)
        {
            if(a[i]>first)
            {
                second = first;
                first = a[i];
            }
            else if ( a[i]> second)
            {
                second = a[i];
            }
        }
        for(int i=0;i<n;i++)
            if(a[i]<second)
                System.out.print(a[i]+" ");
    }
}
