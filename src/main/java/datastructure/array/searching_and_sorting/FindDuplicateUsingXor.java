package datastructure.array.searching_and_sorting;

public class FindDuplicateUsingXor {
    public static void main(String[] args) {
        int[] a = {4, 2, 2,1,1};
        findDuplicate(a);
    }
    public static void findDuplicate(int[] a)
    {
        int xor = a[0];
        int set_bit_number;
        int n = a.length-2;
        for(int i=1;i<a.length;i++)
            xor ^= a[i];
        System.out.println(" xor 1"+ xor);
        for(int i=1;i<=n;i++)
            xor ^= i;
        System.out.println(" xor 1"+ xor);
        set_bit_number = xor & ~(xor-1);
        int x=0,y=0;
        for(int i=0;i<a.length;i++)
        {
            int resultantBit = a[i] ^ set_bit_number;
            if(resultantBit !=0)
                x = x^a[i];
            else
                y = y^a[i];

        }
        for(int i=1;i<=n;i++)
        {
            int resultantBit = i ^ set_bit_number;
            if(resultantBit !=0)
                x = x^i;
            else
                y = y^i;
        }
        System.out.println(" x -->"+x+" y --->"+y);

    }
}
