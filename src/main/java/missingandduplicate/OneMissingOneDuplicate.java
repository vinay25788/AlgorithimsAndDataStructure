package missingandduplicate;

public class OneMissingOneDuplicate {
    public static void main(String[] args) {
        int[] a ={2,3,1,5,1};

        findMissingAndDuplicate(a);
    }

    public static void findMissingAndDuplicate(int[] a)
    {
        for(int i=0;i<a.length;)
        {
            if(a[i] != a[a[i]-1])
            {
                int val = a[a[i]-1];
               int temp = a[i];


               a[a[i]-1] = temp;
                a[i] = val;
            }
            else
                i++;
        }

        for(int i=0;i<a.length;i++)
        {
            if(i+1 != a[i])
            {
                System.out.println("duplicate "+a[i]+" missing "+(i+1));
            }
        }
    }

    public static void swap(int[] a,int x,int y)
    {
        int temp = x;
        a[x] = a[y];
        a[y] = temp;
    }
}
