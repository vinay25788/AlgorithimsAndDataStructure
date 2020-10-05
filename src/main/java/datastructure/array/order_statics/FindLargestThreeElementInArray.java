package datastructure.array.order_statics;

public class FindLargestThreeElementInArray {
    public static void main(String[] args) {
        int[] a={5,4,3,2,1,100,32,99};
        find(a);
    }
    public static void find(int[] a)
    {
        int n= a.length;
        int first = -1,second = -1,third = -1;
        for(int i=0;i<n;i++)
        {
            if(first<a[i])
            {
                third = second;
                second = first;
                first = a[i];

            }
            else if( second< a[i])
            {
                third = second;
                second = a[i];
            }
            else if( third < a[i])
            {
                third = a[i];
            }
        }
        System.out.println( first +"    "+second+ "        "+third);
    }
}
