package datastructure.array.arragement_rearrangement;

public class MinimumSwapRequiredToGroupAll1sTogether {
    public static void main(String[] args) {
        int[] a= new int[]{0, 0, 1, 0, 1, 1, 0, 0, 1};
        System.out.println(minSwap(a));
    }
    public static int minSwap(int [] a)
    {
        int numberOfOnes=0;
        for(int i=0;i<a.length;i++)
            if(a[i] == 1)
                numberOfOnes++;

         int x = numberOfOnes;
        int countOnes =0 ,maxOnes =0;
        for(int i=0;i<x;i++)
        {
            if(a[i] ==1)
                countOnes++;
        }

        maxOnes = countOnes;
        for(int i=1;i<a.length-x;i++)
        {
            if(a[i-1] ==1)
                countOnes--;
            if(a[i+x-1] ==1)
                countOnes++;
            if(maxOnes < countOnes)
                maxOnes = countOnes;
        }

        return x - maxOnes;
    }
}
