package datastructure.array.order_statics;

public class FindSmallestAndSecondSmallest {
    public static void main(String[] args) {
        int[] a={5,3,2,1,77,55,33};
        find(a);
    }
    public static void find(int[] a){
        int n = a.length;
        int smallest = Integer.MAX_VALUE,secondSmallest =Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            if(smallest>a[i])
            {
                secondSmallest = smallest;
                smallest = a[i];
            }
            else if( secondSmallest>a[i])
            {
                secondSmallest = a[i];
            }
        }
        System.out.println(smallest+"  "+secondSmallest);
    }
}
