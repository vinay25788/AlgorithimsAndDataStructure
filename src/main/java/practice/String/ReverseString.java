package practice.String;

public class ReverseString {
    public static void main(String[] args) {
        String str = "internship at geeks for geeks";
        reverse(str);
    }
    public static void reverse(String str)
    {
        int i=0;
        int j = str.length()-1;
        char[] chars = str.toCharArray();
        while(i<j)
        {
            if(chars[i] == ' ')
            {
                i++;
                continue;
            };
                if(chars[j] == ' ')
                {
                    j--;
                    continue;
                }
            char temp = chars[i];
            chars[i] = chars[j] ;
            chars[j]     = temp;
            i++;
            j--;

        }
        System.out.println(String.valueOf(chars));
    }
}
