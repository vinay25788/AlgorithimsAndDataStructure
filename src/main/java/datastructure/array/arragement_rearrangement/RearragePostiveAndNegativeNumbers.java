package datastructure.array.arragement_rearrangement;

public class RearragePostiveAndNegativeNumbers {
    public static void main(String[] args) {
        int[] a ={-1,2,-3,4,5,-6,-7};
        reArragement(a);
        for(int el:a)
            System.out.print("  "+el);
    }
    public static void reArragement(int[] a)
    {
        int i=-1, temp =0;
        for( int j=0;j<a.length;j++)
        {
            if(a[j] < 0)
            {
                i++;
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        int pos = i+1, neg=0;
        while(pos< a.length && neg< pos && a[neg]<0)
        {
            temp = a[neg];
            a[neg] = a[pos];
            a[pos] = temp;
            pos++;
            neg+=2;
        }
    }
}
