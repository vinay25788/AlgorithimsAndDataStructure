package dynamicprogramming.mcm;

public class EggDroppingMemoization {
    static int[][] t;
    static public int superEggDrop(int e, int f) {

        t = new int[e+1][f+1];

        for(int i=0;i<e+1;i++)
        {
            for(int j=0;j<f+1;j++)
            {
                t[i][j] =-1;
            }
        }

        return solve(e,f);
    }

   static private int solve(int e,int f)
    {
        if(f ==0 || f ==1)
            return f;
        if(e == 1)
            return f;


        if(t[e][f] != -1)
            return t[e][f];
        int min = Integer.MAX_VALUE;

        for(int k=1;k<=f;k++)
        {
            int first = -1;

            if(t[e-1][k-1] != -1 )
                first = t[e-1][k-1];
            else
            {
                t[e-1][k-1] =  superEggDrop(e-1,k-1);
                first = t[e-1][k-1];
            }
            int second = -1;

            if(t[e][f-k] != -1 )
                second = t[e][f-k];
            else
            {
                t[e][f-k] =  superEggDrop(e,f-k);
                second = t[e][f-k];
            }


            int temp = 1 + Math.max( first,second );

            if(min>temp)
                min = temp;
        }
        t[e][f] = min;
        return min;
    }

    public static void main(String[] args) {
        System.out.println(superEggDrop(3,5));
    }
}