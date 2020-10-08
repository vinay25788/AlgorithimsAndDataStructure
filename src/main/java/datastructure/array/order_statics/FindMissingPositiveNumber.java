package datastructure.array.order_statics;

public class FindMissingPositiveNumber {
    public static void main(String[] args) {
        int a[] = {0, 10, 2, -10, -20};
        System.out.println("smallest positive number " + find(a));

        System.out.println("smallest positive number "+findMissingPositive(a));
    }
    public static int findMissingPositive(int [] a)
    {
        int shipt = saggregatePositive(a);
        int[] a2 = new int[a.length-shipt];
        int j=0;
        for(int i=shipt ;i<a.length;i++)
        {
            a2[j] = a[i];
            j++;
        }
        return findUsingSameArray(a2);
    }

    public static int findUsingSameArray(int[] a2)
    {
        int n= a2.length;
        for(int i=0;i<n;i++)
        {
            int x = Math.abs(a2[i]);
            if(x -1 <n && a2[x-1]>0 )
                a2[x-1] = -a2[x-1];
        }
        for(int i=0;i<n;i++)
        {
            if(a2[i]>0)
                return i+1;
        }
        return n+1;
    }

    public static int saggregatePositive(int[] a)
    {
        int j=0;
        for(int i=0;i<a.length;i++)
        {
            if(a[i]<0)
            {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                j++;
            }
        }
        return j;
    }

    public static int find(int[] a) {
        int n = a.length;
        boolean[] present = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            if (a[i] <= n && a[i] > 0)
                present[a[i]] = true;
        }

        for (int i = 1; i <= n; i++)
            if (!present[i])
                return i;
        return n + 1;
    }
}
