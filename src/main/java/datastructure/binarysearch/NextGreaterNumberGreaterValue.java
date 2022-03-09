package datastructure.binarysearch;

import java.util.Arrays;

public class NextGreaterNumberGreaterValue {
    public static void main(String[] args) {

        System.out.println(nextGE(12));
    }
    public static int nextGE(int n)
    {
        String str = Integer.toString(n);
        char[] ch = str.toCharArray();

        int i = ch.length-1;
        while(i>0 && ch[i-1]<=ch[i])
            i--;
        if(i==-1)
            return -1;

        int j = ch.length-1;

        while(ch[i]>= ch[j])
            j--;
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;

        Arrays.sort(ch,i+1,ch.length);

        String st = new String(ch);

        long va = Long.parseLong(st);
        if(va <= Integer.MAX_VALUE)
            return (int) va;
        return -1;

    }
}
