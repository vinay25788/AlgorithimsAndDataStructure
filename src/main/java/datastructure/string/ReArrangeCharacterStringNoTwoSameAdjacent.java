package datastructure.string;


import java.util.Comparator;
import java.util.PriorityQueue;

class KeyComparator implements Comparator<Key> {

    @Override
    public int compare(Key o1, Key o2) {
        if (o1.freq < o2.freq)
            return 1;
        else if (o1.freq > o2.freq)
            return -1;
            return 0;
    }
}

class Key {
    char value;
    int freq;

    Key(char value, int freq) {
        this.value = value;
        this.freq = freq;
    }
}

public class ReArrangeCharacterStringNoTwoSameAdjacent {
    public static void main(String[] args) {
        String st = "bbbbaa";
        findAdjacent(st);
    }

    public static void findAdjacent(String st) {
        int count[] = new int[26];
        int n = st.length();
        for (int i = 0; i < n; i++)
            count[st.charAt(i) - 'a']++;
        PriorityQueue<Key> pq = new PriorityQueue<>(new KeyComparator());
        for (char c = 'a'; c <= 'z'; c++) {
            int val = c - 'a';
            if (count[val] > 0)
                pq.add(new Key(c, count[val]));
        }

        String str = "";
        Key prev = new Key('#', -1);
        while (!pq.isEmpty()) {
            Key key = pq.poll();
            str += key.value;
            if (prev.freq > 0)
                pq.add(prev);
            (key.freq)--;
            prev = key;

        }
        if (str.length() == st.length())
            System.out.println(str);
        else
            System.out.println("not possible");

    }
}
