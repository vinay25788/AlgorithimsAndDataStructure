package datastructure.array.arragement_rearrangement;

import java.util.*;

public class GenerateBiggerNumberFromGivenArrayList {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("54","546","548","60");
        generate(list);
    }
    public static void generate(List<String> list)
    {
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String x, String y) {
               String xy = x+y;
               String yx = y+x;
                return xy.compareTo(yx)>0?-1:1;
            }
        });

        for(String st:list)
            System.out.print(st);
    }
}
