package datastructure.array.order_statics;

public class MaximumRepeatingElement {
    public static void main(String[] args) {

        int a[] = {2, 3, 3, 5, 3, 4, 1, 7};
        int k=8;
        System.out.println(find(a,k));
    }
    public static int find(int[] a,int k)
    {
        int n = a.length;
        for(int i=0;i<n;i++)
        {
            a[a[i]%k]+=k;
        }

        int max = a[0];
        int result =0;
        for(int i=0;i<n;i++)
            if(a[i]>max)
            {
                max = a[i];
                result = i;
            }

         for(int i=0;i<n;i++)
             a[i] = a[i]%k;
         return result;
    }
}
