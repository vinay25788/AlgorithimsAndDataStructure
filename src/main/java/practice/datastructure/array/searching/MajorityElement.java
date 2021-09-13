package practice.datastructure.array.searching;

import java.util.Arrays;

public class MajorityElement {
    public static void main(String[] args) {
        int[] a={ 1, 1, 2, 1, 3, 5, 1 };
        findMajority(a);
    }
    public static void findMajority(int[] a)
    {
        Arrays.sort(a);

        int temp = a[0], occuance =-1, count =0,ele=-1,n = a.length;

        for(int i=1;i<n;i++)
        {
            if(temp == a[i])
            {
                count++;
            }
            else
            {
                temp = a[i];
                count =1;
            }

            if(occuance<count)
            {
                occuance = count;
                ele = a[i];
                if(occuance >=n/2)
                    break;

            }

        }
        if(ele !=-1)
        {
            System.out.println(ele);

        }
    }
}
