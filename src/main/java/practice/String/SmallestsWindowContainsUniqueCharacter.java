package practice.String;

public class SmallestsWindowContainsUniqueCharacter {
    public static void main(String[] args) {
        String str ="aabcbcdbca";
        uniqueCharacter(str);
    }
    public static void uniqueCharacter(String str)
    {
        int[] countChar = new int[256];
        boolean[] visited = new boolean[256];
        int distinctCount =0;
        for(int i=0;i<str.length();i++)
        {
            if(!visited[str.charAt(i)] )
            {
                visited[str.charAt(i)] = true;
                distinctCount++;
            }
        }
        System.out.println(" distinct count "+distinctCount);
        int count =0;
        int start =0,startIndex=0;
        int minLength = Integer.MAX_VALUE;
        for(int i=0;i<str.length();i++)
        {
            countChar[str.charAt(i)]++;

            if(countChar[str.charAt(i)] == 1)
                count++;

            if(count == distinctCount)
            {
                //aabcbcdbca

                while(countChar[str.charAt(start)]>1)
                {
                    if(countChar[str.charAt(start)] >1 )
                    countChar[str.charAt(start)]--;

                    start++;
                }

                int len = i - start+1;
                if(len< minLength)
                {
                    minLength = len;
                    startIndex = start;
                }

            }


        }
        System.out.println(str.substring(startIndex, startIndex+minLength));
    }
}
