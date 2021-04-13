package datastructure.array.rotation.repeat_practise.rearrangement;


public class SortedSubSequenceOfSize3 {
    public static void main(String[] args) {
        int[] a = {1,2,-1,7,5};
        subSequence(a);
    }

    public static void subSequence(int[] a) {
        int n = a.length;
        int min_ele = a[0];
        int max_ele = Integer.MIN_VALUE;
        int seq = 1;
        int store_min = min_ele;
        for (int i = 1; i < n; i++) {
            if (a[i] == min_ele)
                continue;
            else if (a[i] < min_ele) {
                min_ele = a[i];
                store_min = min_ele;
                continue;
            }  else if (a[i] > max_ele) {
                seq++;
                if (seq == 3) {
                    System.out.println("Triplet " + store_min + " " + max_ele + " " + a[i]);
                }

                max_ele = a[i];

            }
        }
    }
}
