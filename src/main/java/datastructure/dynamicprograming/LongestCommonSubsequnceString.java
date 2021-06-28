package datastructure.dynamicprograming;

public class LongestCommonSubsequnceString {
    public static void main(String[] args) {
        String s1 = "vinaykumar";
        String s2 ="vamar";
        find(s1.toCharArray(),s2.toCharArray());
    }
    public static void find(char[] s1,char[] s2)
    {
        int[][] k = new int[s2.length+1][s1.length+1];

        int max=0;

        for(int i=1;i<k.length;i++)
        {
            for(int j=1;j<k[i].length;j++)
            {
                if(s1[i-1]==s2[i-1])
                    k[i][j] = k[i-1][j-1]+1;
                else
                    k[i][j] = Math.max(k[i-1][j],k[i][j-1]);
                if(max<k[i][j])
                    max = k[i][j];
            }
        }
        System.out.println(max);
    }

}
