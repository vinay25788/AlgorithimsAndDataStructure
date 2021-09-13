package practice.String;

public class GenerateBinaryString {
    public static void main(String[] args) {
        generate(0,0,"",4);
    }
    public static void generate(int ones,int zeros,String str
            , int len)
    {
        /*if (len == str.length()) {
            System.out.print(str + " ");
            return;
        }

        // Append a 1 and recur
        generate(ones + 1, zeros, str + "1", len);

      // If there are more 1's, append a 0 as well, and recur
        if (ones > zeroes) {
            generate(ones, zeroes + 1, str + "0", len);
        }*/
        if(len == str.length())
        {
            System.out.println(str+" ");
            return;
        }
        generate(ones+1,zeros,str+"1",len);
        if(ones>zeros)
        {
            generate(ones,zeros+0,str +"0" ,len);
        }
    }
}
