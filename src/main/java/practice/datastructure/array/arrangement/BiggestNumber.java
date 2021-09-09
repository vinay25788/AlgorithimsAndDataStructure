package practice.datastructure.array.arrangement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BiggestNumber {
    public static void main(String[] args) {
        List<String> ls = new ArrayList<>();
        ls.add("54");
        ls.add("546");
        ls.add("548");
        ls.add("60");
        createNumber(ls);
    }
    public static void createNumber(List<String> ls)
    {
        Collections.sort(ls, new Comparator<String>() {
            @Override
            public int compare(String x, String y) {

                String xy = x+y;
                String yx = y+x;

                return yx.compareTo(xy);
            }
        });

        for(String el: ls)
            System.out.print(el);
    }
}
