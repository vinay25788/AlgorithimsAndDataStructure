package datastructure.array.order_statics_practis.practise;

public class MaximumRepeatingElement {
    public static void main(String[] args) {
        int[] a = {2, 3, 3, 5, 3, 4, 1, 7,7,7,7};
        int k=8;
        findMaxRepeat(a,k);
    }
    public static void findMaxRepeat(int[] a,int k)
    {
        int n = a.length;

        for(int i=0;i<n;i++)
        {
            a[a[i]%k]+=k;
        }

        int max=Integer.MIN_VALUE;
        int index=-1;
        for(int i=0;i<n;i++)
        {
            if(max<a[i]) {
                max = a[i];
                index = i;
            }
        }
        System.out.println("maximum eleent "+index);
    }
}

