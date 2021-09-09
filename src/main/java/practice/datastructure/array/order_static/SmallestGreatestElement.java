package practice.datastructure.array.order_static;

import java.util.*;

public class SmallestGreatestElement {
    public static void main(String[] args) {
        int[] a ={3,10,6,9,19,11};
        System.out.println();
        smallestGreater(a,a.length);
    }

   public static void smallestGreater(int[] a,int n)
   {
       Arrays.sort(a);
       System.out.println(Arrays.toString(a));

       for(int i=0;i<n;i++)
       {
           int ind = search(a,a[i]);
           if(ind<n)
               System.out.print(a[ind]+" ");
           else
               System.out.print("- ");
       }

   }
   public static int search(int[] a,int ele)
   {
       int l =0, h = a.length;
       while(l<h)
       {
           int mid = (l+h)/2;
           if(ele>a[mid])
               l = mid+1;
           else
               h = mid;
       }
       return l+1;
   }
}
