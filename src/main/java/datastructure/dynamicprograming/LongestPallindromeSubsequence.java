package datastructure.dynamicprograming;

public class LongestPallindromeSubsequence {
    public static void main(String[] args) {
        String st="agbdba";
        find(st.toCharArray());
    }
    public static void find(char[] ch)
    {
        int[][] T = new int[ch.length][ch.length];
        for(int i=0;i<T.length;i++)
            T[i][i] = 1;

        for(int l=2;l<=ch.length;l++)
        {
            for(int i=0;i<ch.length-l+1;i++)
            {
                int j = i+l-1;
                if(l==2 && ch[i]==ch[j])
                    T[i][j] = 2;
                else if ( ch[i] == ch[j])
                    T[i][j] = T[i+1][j-1]+2;
                else
                    T[i][j] = Math.max(T[i+1][j],T[i][j-1]);
            }
        }
        System.out.println(T[0][ch.length-1]);
    }
}
