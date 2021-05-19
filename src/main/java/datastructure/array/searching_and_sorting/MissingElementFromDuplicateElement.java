package datastructure.array.searching_and_sorting;

public class MissingElementFromDuplicateElement {
    public static void main(String[] args) {
        int a1[] = { 4, 1, 5, 9, 7 };
        int a2[] = { 7, 5, 9, 4 };
        findMissingElement(a1,a2);
    }
    public static void findMissingElement(int[] a1,int[] a2)
    {
        int res = a1[0];
        int n = a1.length;
        int m = a2.length;
        for(int i=1;i<n;i++)
            res = res ^ a1[i];
        for(int i=0;i<m;i++)
            res = res ^ a2[i];
        System.out.println(res);
    }
}
