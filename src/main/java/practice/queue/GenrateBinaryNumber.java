package practice.queue;

import java.util.LinkedList;
import java.util.Queue;

public class GenrateBinaryNumber {

    private static void generateNumber(int n)
    {
        Queue<String> que = new LinkedList<>();
        que.add("1");
        while(n-->0)
        {
            String s1 = que.remove();
            System.out.println(s1);
            String s2 = s1;
            que.add(s1+"0");
            que.add(s2+"1");
        }
    }
    public static void main(String[] args) {
        int n =3;
        generateNumber(n);
    }
}
