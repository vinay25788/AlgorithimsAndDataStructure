package datastructure.array.order_statics;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumProductOfKElements {
    public static void main(String[] args) {
        int[] a = {5, 4, 10, 9, 11};
        int k = 2;
        findProduct(a, k);
    }

    public static void findProduct(int[] a, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        int n = a.length;
        for (int i = 0; i < n; i++) {
            pq.add(a[i]);
        }
        int count = 0;
        int ans = 1;
        while (!pq.isEmpty() && count < k) {
            ans *= pq.peek();
            pq.remove();
            count++;
        }
        System.out.println("********************************");
        System.out.println(ans);

    }
}
