package datastructure.dynamicprograming.practise;

public class LongestSubSequence {
    public static void main(String[] args) {
        String st1= "abcdef";
        String st2 = "adf";
        lcs(st1.toCharArray(),st2.toCharArray());
    }
    public static void lcs(char[] st1,char[] st2)
    {
        int[][] T = new int[st1.length+1][st2.length+1];
        for(int i=1;i<=st1.length;i++)
        {
            for(int j=1;j<=st2.length;j++)
            {
                if(st1[i-1] == st2[j-1])
                    T[i][j] = T[i-1][j-1]+1;
                else
                    T[i][j] = Math.max(T[i-1][j],T[i][j-1]);
            }
        }
        System.out.println(T[st1.length][st2.length]);
    }
}
