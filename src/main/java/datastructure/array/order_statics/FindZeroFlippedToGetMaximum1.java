package datastructure.array.order_statics;

public class FindZeroFlippedToGetMaximum1 {
    public static void main(String[] args) {
        int m =2;
        int a[] = new int[]{1, 0, 0, 1, 1, 0, 1, 0, 1, 1};
        find(a,m);
    }
    public static void find(int[] a,int m)
    {
        int wR=0,wL=0,zeroCount=0,bestWindow =0,bestL=0;
        int n = a.length;
        while(wR<n)
        {
            if(zeroCount<=m)
            {
                if(a[wR] == 0)
                    zeroCount++;
                wR++;
            }
            if(zeroCount>m)
            {
                if(a[wL] ==0)
                    zeroCount--;
                wL++;
            }
            if(wR - wL >bestL && zeroCount <= m)
            {
                bestL = wL;
                bestWindow = wR-wL;
            }

        }

        for(int i=0;i<bestWindow;i++)
        {
            if(a[bestL+i] ==0)
                System.out.print( bestL+i+"  ");
        }
    }
}
