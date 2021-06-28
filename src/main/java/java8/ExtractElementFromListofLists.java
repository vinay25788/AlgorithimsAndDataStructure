package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ExtractElementFromListofLists {
    public static void main(String[] args) {
        List<List<String>> listOfList = new ArrayList<>();

        List<String> l1 = Arrays.asList("one","two");
        List<String> l2 = Arrays.asList("three","four");
        List<String> l3 = Arrays.asList("five","six");
        List<String> l4 = Arrays.asList("one","two");

        listOfList.add(l1);
        listOfList.add(l2);
        listOfList.add(l3);
        listOfList.add(l4);

        List<String> result;
        result = listOfList.stream().flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(result);
    }
}
