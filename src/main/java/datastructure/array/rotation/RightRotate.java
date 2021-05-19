package datastructure.array.rotation;

public class RightRotate {
    public static void main(String[] args) {
        // input = 1,2,3,4,5,6,7,8,9
        //output = 9,8,7,6,5,4,3,2,1,
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int d = 2;

        rotate(a, d);
        for (int el : a)
            System.out.print(el+" ");
    }

    public static void rotate(int[] a, int d) {
        rightRotate(a, a.length - d, a.length - 1);
        rightRotate(a, 0, a.length - d-1);
        rightRotate(a, 0, a.length - 1);
    }

    public static void rightRotate(int[] a, int low, int high) {
        int temp;
        while (low < high) {
            temp = a[low];
            a[low] = a[high];
            a[high] = temp;
            low++;
            high--;
        }
    }
}
