package datastructure.array.order_statics;

public class FindElementsArrayGreaterThanTwoTwoElement {
    public static void main(String[] args) {
        int[] a= {6,4,2,1,20,30,25,100};
        find(a);
    }
    public static void find(int[] a)
    {
        int n= a.length;
        int first=-1,second =-1;
        for(int i=0;i<n;i++)
        {
            if(first<a[i])
            {
                second = first;
                first = a[i];
            }
            else if( second < a[i])
            {
                second = a[i];
            }
        }

        for(int i=0;i<n;i++)
        {
            if(a[i]< second)
                System.out.print(" "+a[i]);
        }
    }
}

