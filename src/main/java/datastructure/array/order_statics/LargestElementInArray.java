package datastructure.array.order_statics;

public class LargestElementInArray {
    public static void main(String[] args) {
        int[] a = {100, 6, 4, 10, 95, 99};
        findLargest(a);
    }

    public static void findLargest(int[] a) {
        int n = a.length - 1;
        int max = a[n];
        for (int i = n - 2; i >= 0; i--) {
            if (max < a[i])
                max = a[i];
        }
        System.out.println("*****************************************");
        System.out.println(max);
    }
}
