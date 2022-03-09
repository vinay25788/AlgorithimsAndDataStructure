package slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstNegativeNumberInSlidingWindow {

    public static long[]  printFirstNegativeInteger(long a[], int n, int K)
    {
        long[] res = new long[n-K+1];
        int i=0,j=0;
        int ind =0;
        List<Long> list = new ArrayList<>();

        while(j<n)
        {
            if(a[j]<0)
            {
                list.add(a[j]);

            }

            if(j-i+1<K)
                j++;
           else if(j-i+1 == K)
            {
                if(list.size()==0)
                {
                    res[ind++] = 0;
                    j++;
                    i++;
                    continue;
                }
                else
                {
                    res[ind++] = list.get(0);
                }
                if(list.get(0) == a[i])
                    list.remove(0);
                i++;
                j++;
            }


        }
        return res;
    }

    public static void main(String[] args) {
        long[] a = {-8, 2, 3, -6, 10};
        int n = a.length;
        int k = 2;
        System.out.println(Arrays.toString(printFirstNegativeInteger(a,n,k)));
    }
}
