package practice.datastructure.array.searching;

public class PrintCommonElement {
    public static void main(String[] args) {
        int a[] = {1, 5, 10, 20, 40, 80};
        int b[] = {6, 7, 20, 80, 100};
        int c[] = {3, 4, 15, 20, 30, 70, 80, 120};
        findCommon(a,b,c);
    }
    public static void findCommon(int[] a,int[] b,int [] c)
    {
        int n = a.length,m=b.length,o = c.length;

        int i=0,j=0,k=0;

        while(i<n && j<m && k<o)
        {
            if(a[i] == b[j] && b[j] == c[k])
            {
                System.out.print(a[i]+" ");
                i++;j++;k++;
            }
            else if ( a[i]<b[j])
                i++;
            else if ( b[j]<c[k])
                j++;
            else
                k++;
        }
    }
}
