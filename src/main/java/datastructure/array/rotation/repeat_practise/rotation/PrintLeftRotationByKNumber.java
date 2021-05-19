package datastructure.array.rotation.repeat_practise.rotation;

public class PrintLeftRotationByKNumber {
    public static void main(String[] args) {
        int[] a= new int[]{1, 3, 5, 7, 9};
        int k=2;
        int n = a.length;
        int mod = ( k)%n;
        for(int i=0;i<n;i++)
            System.out.print(a[(mod+i)%n]+" ");

    }
}
