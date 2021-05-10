package datastructure.array.order_statics_practis.practise;

public class SecondLargestElementInArray {
    public static void main(String[] args) {
        int[] a ={1,3,10,9,7};
        findSecondLargest(a);
    }
    public static void findSecondLargest(int[] a)
    {
        int n = a.length;
        int max = Integer.MIN_VALUE;
        int secondMax = 0;
        for(int i=0;i<n;i++)
        {
            if(max< a[i])
            {
                secondMax = max;

                max = a[i];
            }
            else if ( a[i] < max && a[i] > secondMax)
                secondMax = a[i];
        }
        System.out.println(secondMax);
    }
}
