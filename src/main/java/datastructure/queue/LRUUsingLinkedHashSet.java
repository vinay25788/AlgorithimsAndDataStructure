package datastructure.queue;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

public class LRUUsingLinkedHashSet {

    Set<Integer> cache;
    int capacity;

    public LRUUsingLinkedHashSet(int capacity)
    {
        this.cache = new LinkedHashSet<Integer>(capacity);
        this.capacity = capacity;
    }

    public void refer(int key)
    {
        if(get(key) == false)
            put(key);
    }

    public boolean get(int key)
    {
        if(!cache.contains(key))
            return false;
        cache.remove(key);
        cache.add(key);
        return true;
    }

    public void put(int key)
    {
        if(cache.size() == capacity)
        {
            int firstKey = cache.iterator().next();
            cache.remove(firstKey);
        }
        cache.add(key);
    }

    public void display()
    {
        LinkedList<Integer> list = new LinkedList<>(cache);

        Iterator<Integer> it = list.descendingIterator();
        while(it.hasNext())
            System.out.print(it.next()+" ");

    }
    public static void main(String[] args) {
        LRUUsingLinkedHashSet cache = new LRUUsingLinkedHashSet(4);
        cache.refer(1);
        cache.refer(2);
        cache.refer(3);
        cache.refer(1);
        cache.refer(4);
        cache.refer(5);
        cache.display();
    }






}
