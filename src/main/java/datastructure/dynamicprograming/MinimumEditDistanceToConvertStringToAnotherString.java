package datastructure.dynamicprograming;

public class MinimumEditDistanceToConvertStringToAnotherString {
    public static void main(String[] args) {
        String str1 = "azced";
        String str2 = "abcdef";
        find(str1.toCharArray(),str2.toCharArray());
    }
    public static void find(char[] s1,char[] s2)
    {
        int[][] T= new int[s1.length+1][s2.length+1];


        for(int i=1;i<=s1.length;i++)
        {
            for(int j=1;j<=s2.length;j++)
            {
                if(s1[i-1] == s2[i-1])
                    T[i][j] = T[i-1][j-1];
                else
                    T[i][j] = 1+min(T[i][j-1],T[i-1][j-1],T[i-1][j]);
            }
        }

        System.out.println(T[s1.length][s2.length]);

    }
    public static int min(int a,int b,int c)
    {
        int l = Math.min(a,b);
        return Math.min(l,c);
    }
}

/*
In resultant metrixs if we are moving diagonal then replace, for left it is delete;
 */
