package practice.datastructure.array.arrangement;

public class SecondLargest {
    public static void main(String[] args) {
        int[] a ={1,12,23,4,5,6,10};
        find(a);
    }
    public static void find(int[] a)
    {
        int first = 0,second =0;
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
        System.out.println(second);
    }
}
