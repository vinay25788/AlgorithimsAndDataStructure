package datastructure.dynamicprograming;

public class CountTheSubsetOfGivenDiff {

    public static void main(String[] args) {
        int[] a ={1,1,2,3};
        int diff = 1;


        System.out.println(calculateCount(a,diff));
    }

    public static int calculateCount(int[] a,int diff)
    {
       int sum = 0;

       for(int i=0;i<a.length;i++)
           sum+=a[i];

       int s1 = (sum+diff)/2;

       int[][] t = new int[a.length+1][s1+1];

       for(int i=0;i<a.length+1;i++)
           for(int j=0;j<s1+1;j++)

           {
               if(i==0)
                   t[i][j] =0;
               if(j==0)
                   t[i][j] = 1;
           }

       for(int i=1;i<a.length+1;i++)
       {
           for(int j=1;j<s1+1;j++)
           {
               if(a[i-1]<=j)
               {
                   t[i][j] = t[i-1][j] + t[i-1][j-a[i-1]];
               }
               else
                   t[i][j] = t[i-1][j];
           }
       }

       return t[a.length][s1];
    }
}
