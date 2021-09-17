package practice.String;

public class RemoveCharacterToMakeAnagram {
    public static void main(String[] args) {
        String str1 = "bcadeh", str2 = "hea";
        removeCharacter(str1,str2);
    }

    public static void removeCharacter(String s1,String s2)
    {
        int[] count1 = new int[26];
        for(int i=0;i<s1.length();i++)
            count1[s1.charAt(i)-'a']++;
        for(int i=0;i<s2.length();i++)
            count1[s2.charAt(i)-'a']--;
        int res =0;
        for(int i=0;i<s1.length();i++)
            res+= Math.abs(count1[s1.charAt(i)-'a']);

        System.out.println(res);
    }
}
