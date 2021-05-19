package datastructure.array.searching_and_sorting;

public class FindEquilibriumOfArray {
    public static void main(String[] args) {
        int[] a = {-7, 1, 5, 2, -4, 3, 0};
        findEquilibrium(a);
    }

    public static void findEquilibrium(int[] a) {
        int sum = 0;
        int n = a.length;
        for (int i = 0; i < n; i++)
            sum += a[i];
        System.out.println(" sum "+sum);
        int leftSum = 0, rightSum = 0;
        for(int i=0;i<n;i++)
        {
            sum = sum - a[i];
            System.out.println(" sum deduction "+sum);
            if(leftSum == sum)
            {
                System.out.println(" Equilibrium index "+i);
                System.out.println(leftSum +" "+sum);
                return;
            }
            leftSum += a[i];

        }
    }
}
