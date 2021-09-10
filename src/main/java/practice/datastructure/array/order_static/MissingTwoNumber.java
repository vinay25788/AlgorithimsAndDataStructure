package practice.datastructure.array.order_static;

public class MissingTwoNumber {
    public static void main(String[] args) {
        int a[] = {1, 3, 5, 6};
        findMissingNumber(a,6);
    }
    public static void findMissingNumber(int[] a,int n)
    {
        int xor = a[0];

        for(int i=1;i<n-2;i++)
            xor^=a[i];
        for(int i=1;i<=n;i++)
            xor^=i;

        int setBit = xor ^ ~(xor-1);

        int x =0, y=0;
        for(int i=0;i<n-2;i++)
        {
            if((a[i] & setBit) >0)
                x = x^a[i];
            else
                y = y ^a[i];

        }
        for(int i=1;i<=n;i++) {
            if (( i & setBit) > 0)
                x = x ^ i;
            else
                y = y ^ i;
        }
        System.out.println(x +" "+ y );

    }
}
