package datastructure.string;

public class ExcelColumnNumberToEnglish {
    public static void main(String[] args) {
        int col = 676;
        convert(col);
    }
    public static void convert(int col)
    {
        StringBuilder sb = new StringBuilder();
        while(col>0)
        {
            int rem = col%26;
            if(rem ==0)
            {
                sb.append("Z");
                col = (col/26)-1;
            }
            else
            {
                sb.append((char) ((rem-1)+'A'));
                col = col/26;
            }
        }

        System.out.println(sb.reverse());
    }
}
