package datastructure.array.rotation;

public class ArrayRotationUsingReversalAlgo {
    public static void main(String[] args) {

        int[] a = {1,2,3,4,5,6,7,8,9};
        int d = 2;
        rotate(a,d);
        for(int el:a)
            System.out.print(" "+el);

    }
    public static void rotate(int[] a,int d)
    {
        int length = a.length -1;
        leftRotate(a,0,d-1);
        leftRotate(a,d,length);
        leftRotate(a,0,length);
    }
    public static void leftRotate(int[] a,int low,int high)
    {
        int temp;
        while(low < high)
        {
            temp = a[low];
            a[low] = a[high];
            a[high] = temp;
            low++;
            high--;

        }
    }
}
