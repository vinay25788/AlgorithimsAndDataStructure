package datastructure.array.order_statics_practis.practise;

public class LargestElementInArray {
    public static void main(String[] args) {
        int[] a = {1,2,5,10,15};
        System.out.println(findLargest(a));
    }
    public static int findLargest(int[] a)
    {
        int max=Integer.MIN_VALUE;
        for(int i =0;i<a.length;i++)
        {
            if(max<a[i])
                max = a[i];
        }
        return max;
    }
}
