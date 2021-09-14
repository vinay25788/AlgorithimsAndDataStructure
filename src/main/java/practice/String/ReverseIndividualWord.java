package practice.String;

public class ReverseIndividualWord {
    public static void main(String[] args) {
        String st = "Geeks for Geeks";
        reverse(st);
    }
    private static void reverse(String str)
    {
        int n = str.length();
        int end=0;
        int start=0;
        char chars[] = str.toCharArray();
        for(int i=0;i<n;i++)
        {
            if(chars[i] == ' '|| i == n-1)
            {
                if(i == n-1)
                    end = i;
                else
                end = i-1;
                while(start<end)
                {
                    char temp = chars[start];
                    chars[start] = chars[end];
                    chars[end] = temp;
                    start++;
                    end--;
                }

                start = i+1;
            }

        }

        System.out.println(String.valueOf(chars));
    }
}
