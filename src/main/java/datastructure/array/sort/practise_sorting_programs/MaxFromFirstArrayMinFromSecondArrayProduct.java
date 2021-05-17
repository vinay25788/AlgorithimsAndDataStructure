package datastructure.array.sort.practise_sorting_programs;

public class MaxFromFirstArrayMinFromSecondArrayProduct {
    public static void main(String[] args) {
        int[] a ={2,3,5,6,7,8};
        int[] b ={5,3,7,9,2};
        findProduct(a,b);
    }
    public static void findProduct(int[] a,int[] b)
    {
        int max = a[0],min=b[0];
        int n = a.length, m = b.length;
        int i=0;
        for( i=0;i<n && i< m; i++)
        {
            if(max<a[i])
                max = a[i];
            if(min>b[i])
                min = b[i];
        }
        while(i<n)
        {
            if(max<a[i])
                max = a[i++];
        }
        while(i<m)
        {
            if(min>b[i])
                min = b[i++];
        }
        System.out.println("Product of max min "+(max*min));
    }
}
