package datastructure.string;

public class MaxConsecutiveRepeatingCharacter {
    public static void main(String[] args) {
        String st = "aaaabbaaccde";
        findMaxRepeating(st);
    }
    public static void findMaxRepeating(String st)
    {
        int n = st.length();
        int count =0;
        char res = st.charAt(0);
        int curCount =1;
        for(int i=0;i<n;i++)
        {
            if(i<n-1&& st.charAt(i) == st.charAt(i+1))
                curCount++;
            else
            {
                if(curCount>count)
                {
                    count = curCount;
                    res = st.charAt(i);
                }
                curCount =1;

            }

        }
        System.out.println(res);

    }
}
