package datastructure.array.arragement_rearrangement;

public class ReverseArray {
    public static void main(String[] args) {
        int[] a ={1,2,3};
        reverse(a);
        for(int el:a)
            System.out.print("  "+el);
    }
    public static void reverse(int[] a)
    {
        int low =0 , high = a.length-1;
        while(low<high)
        {
            int temp = a[low];
            a[low] = a[high];
            a[high]= temp;
            low++;
            high--;
        }
    }
}
