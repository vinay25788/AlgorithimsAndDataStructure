package datastructure.array.order_statics.practice;

public class MaximumZeroToBeFlipped {
    public static void main(String[] args) {
        int[] a = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1};
        int m = 2;
        findZero(a, m);
    }

    public static void findZero(int[] a, int m) {
        int wR = 0, wL = 0, bestIndex = 0, bestWindow = 0;
        int zeroCount = 0;
        int n = a.length;

        while (wR < n) {
            if(zeroCount<=m )
            {
                if(a[wR] ==0)
                    zeroCount++;
                wR++;
            }
            if(zeroCount>m)
            {
                if(a[wL] ==0)
                    zeroCount--;
                wL++;
            }
            if(wR-wL >bestWindow && zeroCount<=m)
            {
                bestWindow = wR-wL;
                bestIndex = wL;
            }
        }
        for(int i=0;i<bestWindow;i++)
            if(a[bestIndex+i] ==0)
                System.out.print( " "+(bestIndex+i));
    }

}
