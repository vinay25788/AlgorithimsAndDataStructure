package practice.datastructure.array.searching;

public class OddOccurance {
    public static void main(String[] args) {
       int[] a ={4, 2, 4, 5, 2, 3, 3, 1};
       printOddOccurance(a);
    }
    public static void printOddOccurance(int[] a)
    {
        int n = a.length;
        int xor =a[0];
        for(int i=1;i<n;i++)
            xor ^=a[i];

        int setBit = xor & ~(xor-1);
        int x=0,y=0;

        for(int i=0;i<n;i++)
        {
            if((setBit & a[i])>0)
                x ^=a[i];
            else
                y ^=a[i];
        }
        System.out.println(x +"  "+y);
    }
}
