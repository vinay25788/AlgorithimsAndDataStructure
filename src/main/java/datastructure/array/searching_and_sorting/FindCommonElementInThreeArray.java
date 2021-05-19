package datastructure.array.searching_and_sorting;

public class FindCommonElementInThreeArray {
    public static void main(String[] args) {
        int a1[] = {1, 5, 10, 20, 40, 80};
        int a2[] = {6, 7, 20, 80, 100};
        int a3[] = {3, 4, 15, 20, 30, 70, 80, 120};
        findCommonElement(a1, a2, a3);
    }

    public static void findCommonElement(int[] a1, int[] a2, int[] a3) {
        int i = 0, j = 0, k = 0;
        int n = a1.length, m = a2.length, p = a3.length;
        while (i < n && j < m && k < p) {
            if (a1[i] == a2[j] && a2[j] == a3[k]) {
                System.out.println(a1[i]);
                i++;
                j++;
                k++;
            } else if (a1[i] < a2[j])
                i++;
            else if(a2[j] < a3[k])
                j++;
            else
                k++;
        }
    }
}
