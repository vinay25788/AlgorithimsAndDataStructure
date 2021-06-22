package datastructure.string;

public class SmallestWindowContainingAllCharacterFromAnotherString {
    public static void main(String[] args) {
        String s1 = "ADOBECODEBANC";
        String s2 = "ABC";
        findWindow(s1.toLowerCase(),s2.toLowerCase());

    }
    public static void findWindow(String s1,String s2)
    {
        int[] countCharacter = new int[26];
        int n1 =  s1.length();
        int n2 = s2.length();
        int count =0;
        for(int i=0;i<n2;i++)
        {
            if(countCharacter[s2.charAt(i)-'a'] ==0)
                count++;
            countCharacter[s2.charAt(i)-'a'] ++;
        }
        int i=0,j=0;
        int ans = Integer.MAX_VALUE;
        int start =-1;
        while(j<n1)
        {
            countCharacter[s1.charAt(j)-'a']--;
            if(countCharacter[s1.charAt(j)-'a']==0)
                count--;
            if(count==0)
            {
                while(count ==0)
                {
                    if(ans>j-i+1)
                    {
                        ans = j-i+1;
                        start = i;
                    }
                    countCharacter[s1.charAt(i)-'a']++;
                    if(countCharacter[s1.charAt(i)-'a']>0)
                        count++;
                    i++;

                }

            }
            j++;
        }
        if(ans != Integer.MAX_VALUE)
            System.out.println(s1.substring(start,start+ans));
    }
}
