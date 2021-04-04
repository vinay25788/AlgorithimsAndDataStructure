package datastructure.array.rotation.repeat_practise;

public class GenerateAllPossibleRotation {
    public static void main(String[] args) {
        int num = 123;
        genrateRotation(num);
    }
    public static void genrateRotation(int num)
    {
        int digit = findDigits(num);
        int pow = (int) Math.pow(10,digit-1);
        for(int i=0;i<digit-1;i++)
        {
            int firstDigit = num/pow;
            int nextNum = ((num *10)+firstDigit)-(firstDigit*pow*10);
            System.out.print(nextNum+" ");

            num = nextNum;
        }
    }
    public static int findDigits(int num)
    {
        int count =0;
        while(num>0)
        {
            count++;
            num = num/10;
        }
        return count;
    }
}
