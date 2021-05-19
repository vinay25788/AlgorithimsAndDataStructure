package datastructure.array.searching_and_sorting;

public class PeakOfArray {
    public static void main(String[] args) {
        int[] a = {1, 3, 20, 4, 1, 0};
        findPeak(a);
    }

    public static void findPeak(int[] a) {
        int n = a.length;
        if (n == 2 && a[0] > a[1])
        {
            System.out.println(" peak "+a[0]);
            return;
        }
        if(a[n-1]>a[n-2])
        {
            System.out.println(" peak "+a[n-1]);
            return;
        }

            for (int i = 1; i < n-1; i++) {
                if (a[i] > a[i-1] && a[i] > a[i+1])
                {
                    System.out.println(" Peak "+a[i]);
                    return;
                }
            }
    }
}
