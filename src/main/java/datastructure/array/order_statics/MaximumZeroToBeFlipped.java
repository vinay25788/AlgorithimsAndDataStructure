package datastructure.array.order_statics;

class MaximumZeroToBeFlipped
{
    public static void main(String[] args) {
        int[] a = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1};
        int m = 2;
        findZeroToBeFlipped(a,m);
    }
    public static void findZeroToBeFlipped(int[] a,int m)
    {
        int wR=0,wL=0;
        int bestL =0, bestWindow =0;
        int n = a.length;
        int zeroCount =0;

        while(wR < n)
        {
            if(zeroCount <= m)
            {
                if(a[wR] == 0)
                    zeroCount++;

                wR++;
            }
            if(zeroCount > m)
            {
                if(a[wL] ==0)
                    zeroCount--;
                wL++;
            }
            if(wR - wL > bestWindow && zeroCount<=m )
            {
                bestWindow = wR - wL;
                bestL = wL;
            }
        }

        for(int i=0;i<bestWindow;i++)
            if(a[bestL+i] ==0)
                System.out.print(bestL+i+" ");
    }
}