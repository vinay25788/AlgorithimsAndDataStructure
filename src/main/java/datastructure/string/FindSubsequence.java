package datastructure.string;

public class FindSubsequence {
    public static void main(String[] args) {
        String s1 = "vny";
        String s2 = "vinay";
        System.out.println(findSubsequence(s1, s2));
    }

    public static boolean findSubsequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int i = 0, j = 0;
        for (i = 0, j = 0; i < n && j < m; j++) {
            if (s1.charAt(i) == s2.charAt(j))
                i++;

        }
        return i == n;
    }
}
