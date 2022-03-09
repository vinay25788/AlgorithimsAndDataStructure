package dynamicprogramming.mcm;

public class MatrixChainMultiplicationRecursive {
    public static void main(String[] args) {
        int[] a = {40, 20, 30, 10, 30};
        System.out.println(mcm(a,1,a.length-1));
    }

    public static int mcm(int[] a,int i,int j)
    {
        if(i>=j)
            return 0;
        int min = Integer.MAX_VALUE;
        for(int k= i;k<j;k++)
        {
            int tempAns = mcm(a,i,k)+mcm(a,k+1,j)+a[i-1]*a[k]*a[j];
            if(min>tempAns)
                min = tempAns;
        }
        return min;
    }
}
