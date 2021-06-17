package datastructure.string;

public class RemoveCharacterFromFirstStringPresentInSecondString {
    public static void main(String[] args) {
        String str = "geeksforgeeks";
        String mask_str = "mask";
        System.out.println(removeDirtyChars(str, mask_str));
    }
    public static String removeDirtyChars(String str,String mast_str)
    {
        int[] count = new int[26];
        for(int i=0;i<mast_str.length();i++)
            count[mast_str.charAt(i)-'a']++;
        int index=0,resultIndex =0;
        char[] strToArr = str.toCharArray();
        int length = str.length();
        while(index != length)
        {
            if(count[strToArr[index]-'a']==0)
            {
                strToArr[resultIndex] = strToArr[index];
                resultIndex++;
            }
            index++;
        }
        str = new String(strToArr);
        return str.substring(0,resultIndex);
    }
}
