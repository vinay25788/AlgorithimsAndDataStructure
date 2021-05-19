package datastructure.array.rotation.practise;

public class ArrayRotation {
    public static void main(String[] args) {

        int[] a={1,2,3,4,5,6,7,8,9};
        int d= 15;
        d = d%10;
        rotate(a,d);

        System.out.println("=---------------------=");
        for(int el:a)
            System.out.print(el +" ");
    }

    public static void rotate(int[] a,int d)
    {
        leftRotate(a,0,d-1);
        leftRotate(a,d,a.length-1);
        leftRotate(a,0,a.length-1);
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
