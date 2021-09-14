package practice.String;

public class URLify {

    public static void main(String[] args) {
        String st = "vinay kumar  ";
        createUrlify(st);
    }

    private static void createUrlify(String st) {
        int n = st.length();
        char[] chs = st.toCharArray();
        int countSpace = 0, i = 0;
        for (i = 0; i < n; i++)
            if (chs[i] == ' ')
                countSpace++;



        while (chs[i - 1] == ' ') {
            countSpace--;
            i--;
        }

        int newLength = i + countSpace * 2;
        char[] newArray = new char[newLength];
        int index = newLength - 1;

        for (int j = i-1; j >= 0; j--) {
            if (chs[j] == ' ') {
                newArray[index] = '0';
                newArray[index - 1] = '2';
                newArray[index - 2] = '%';
                index = index - 3;
            } else {
                newArray[index] = chs[j];
                index--;
            }
        }
        System.out.println(String.valueOf(newArray));

    }
}
