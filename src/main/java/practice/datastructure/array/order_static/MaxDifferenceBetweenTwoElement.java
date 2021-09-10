package practice.datastructure.array.order_static;

public class MaxDifferenceBetweenTwoElement {
    public static void main(String[] args) {
        int[] a ={1,2,10,25,14};
        findMaxDiff(a);
    }
    public static void findMaxDiff(int[] a)
    {
        int maxDiff = a[1] - a[0] ;
        int minEle = a[0];
        for(int i=1;i<a.length;i++)
        {
            if(a[i]-minEle>maxDiff)
            {
                maxDiff = a[i] - minEle;
            }
             if ( minEle>a[i])
                minEle = a[i];
        }
        System.out.println(maxDiff);
    }
}
