package datastructure.string;

// Java program to find the smallest window containing
// all characters of a pattern.

public class AllUniqueCharacterInSmallestWindow {

    public static void main(String[] args) {
        String st = "aabcbcdbca";
        findWindow(st);
    }

    public static void findWindow(String st) {
        int n = st.length();
        boolean[] visited = new boolean[256];
        int distCount = 0;
        for (int i = 0; i < n; i++) {
            if (visited[st.charAt(i)] == false) {
                visited[st.charAt(i)] = true;
                distCount++;
            }
        }
        int start = 0, startIndex = -1;
        int smallestWindow = Integer.MAX_VALUE;
        int count=0;
        int[] curCount = new int[256];
        int j=0;
        for( j=0;j<n;j++)
        {
            char ch = st.charAt(j);
            curCount[ch]++;
            if(curCount[ch] ==1)
                count++;
            if(count == distCount)
            {
                while(curCount[ch]>1)
                {
                    curCount[ch]--;
                    start++;
                }
                int windLength = j-start+1;
                if(smallestWindow>windLength)
                {
                    smallestWindow = windLength;
                    startIndex = start;
                }
            }

        }
        System.out.println(st.substring(startIndex,startIndex+smallestWindow));

    }
}