package datastructure.array.order_statics_practis.practise;

public class SmallestAndSecondSmallest {
    public static void main(String[] args) {
        int[] a = {4,2,10,1,15,2};
        findSmallest(a);
    }
    public static void findSmallest(int[] a)
    {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        int n = a.length;
        for(int i=0;i<n;i++)
        {
            if(a[i]<smallest)
            {
                secondSmallest = smallest;
                smallest = a[i];
            }
        }
        System.out.println(secondSmallest);
    }
}
