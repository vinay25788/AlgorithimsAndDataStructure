package datastructure.array.order_statics_practis.practise;

public class LargestThreeElement {
    public static void main(String[] args) {
        int[] a ={4,2,6,10,15};
        findLargestThree(a);
    }
    public static void findLargestThree(int[] a)
    {
        int first =0,second = 0, third = 0;

        int n = a.length;
        for(int i=0;i<n;i++)
        {
            if(first<a[i])
            {
                third = second;
                second = first;

                first = a[i];

            }
            else if ( a[i] < first && second < a[i])
            {
                third = second;

                second = a[i];

            }
            else
            {
                third = a[i];
            }
        }
        System.out.println(" first "+first+" second "+second+" third "+third);
    }
}
