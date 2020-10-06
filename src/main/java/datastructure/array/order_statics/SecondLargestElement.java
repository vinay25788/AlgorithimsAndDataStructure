package datastructure.array.order_statics;

public class SecondLargestElement {
    public static void main(String[] args) {
        int[] a = {5, 4, 3, 2, 1, 22, 55, 33, 21};
        findSecondLargest(a);
    }

    public static void findSecondLargest(int[] a) {
        int n = a.length;
        int first = -1, second = -1;
        for (int i = 0; i < n; i++) {
            if (first < a[i]) {
                second = first;
                first = a[i];
            } else if (second < a[i]) {
                second = a[i];
            }
        }
        System.out.println("second largest " + second);
    }
}
