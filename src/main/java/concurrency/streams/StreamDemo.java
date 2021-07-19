package concurrency.streams;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Person
{
    String firstName;
    String lastName;

    Person(String firstName,String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
public class StreamDemo {
    public static void main(String[] args) {
        int[] a=new int[100];
        for(int i=0;i<100;i++)
            a[i] = i;
        IntStream integerStream = Arrays.stream(a);
        integerStream.forEach(i-> System.out.print(i+" "));
        IntStream stream = Arrays.stream(a);
        System.out.println();
        System.out.println("********parallel************");
        stream.parallel().forEach(i-> System.out.print(i+" "));

        System.out.println();
        System.out.println("limit ");
        IntStream stream2 = Arrays.stream(a);
        stream2.limit(10).forEach(i-> System.out.print(i+" "));
        IntStream strem3 = Arrays.stream(a);
        System.out.println();
        System.out.println("map");
        strem3.limit(10).map(i->i*i).forEach(System.out::println);
        System.out.println(" reduce function ");
        IntStream stream4 = Arrays.stream(a);
        OptionalInt max= stream4.max();
        System.out.println(max.getAsInt());
        IntStream stream5 = Arrays.stream(a);
        List<Integer> list =  stream5.map(i->i*2).filter(i->i%2==0).boxed().collect(Collectors.toList());
        System.out.println();
        System.out.println(" converting to list ");
        System.out.println(list.toString());

        Stream<Integer> stream6 = Stream.of(1,2,4,5,6,7,8);
        List<Integer> ls = stream6.map(i->i*2).collect(Collectors.toList());
        System.out.println(" collector using toList");
        System.out.println(ls.toString());

        List<Person> personList = new ArrayList<>();
        personList.add(new Person("vinay","kumar"));
        personList.add(new Person("kumar","garg"));
        personList.add(new Person ("shivani","kumari"));
        ConcurrentMap<Object, Object> map = personList.stream().parallel().collect(Collectors.toConcurrentMap(key->key.firstName, value->value.lastName,(s1, s2)->s1+" , "+s2));
        map.forEach((key,value)-> System.out.println(key.toString()+" "+value.toString()));
        System.out.println(" for each ordered");
        List<Double> doubles = Arrays.asList(1.0, 7.0,5.0,3.0);
        System.out.println(" double using for each ordered ");
        doubles.parallelStream().sorted().forEachOrdered(i-> System.out.println(i));
        System.out.println(" for each ");
        List<Double> doublesWithSimpleForEach = Arrays.asList(1.0, 7.0,5.0,3.0);
        System.out.println(" double using for each ");
        doublesWithSimpleForEach.parallelStream().sorted().forEach(i-> System.out.println(i));

    }
}
