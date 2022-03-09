package datastructure_pattern.slidingwindow;

public class CountConsecutive1GreaterThanZero {
    static  public boolean checkZeroOnes(String s) {

        int i=0,j=0,count1s = 0 , maxLength = Integer.MIN_VALUE;
        int n = s.length();
        boolean flag = false;
        while(j<n)
        {
            if(s.charAt(j) == '1')
                count1s++;
            else if((j-i+1)>count1s)
            {
                int  countZero = (j-i+1) - count1s;
                if(count1s > countZero)
                {
                    flag = true;
                }

                i=j;
                count1s=0;
            }
            j++;
        }

        return flag;

    }

    public static void main(String[] args) {
        System.out.println(checkZeroOnes("111000"));
    }
}
