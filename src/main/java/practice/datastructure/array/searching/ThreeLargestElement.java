package practice.datastructure.array.searching;

public class ThreeLargestElement {
    public static void main(String[] args) {
        int[] a ={2,3,4,5,6,7,8,};
        find(a);
    }
    public static void find(int [] a)
    {
        int n = a.length;
        int first =Integer.MIN_VALUE,second =Integer.MIN_VALUE,third =Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            if(first<a[i])
            {
                third = second;
                second = first;
                first = a[i];
            }
            else if ( second < a[i] )
            {
                third = second;
                second = a[i];
            }
            else if ( third < a[i])
            {
                third = a[i];
            }
        }
        System.out.println(first+"  "+second+" "+third);
    }
}
