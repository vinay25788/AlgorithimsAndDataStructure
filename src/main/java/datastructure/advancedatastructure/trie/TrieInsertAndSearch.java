package datastructure.advancedatastructure.trie;

public class TrieInsertAndSearch {
    TrieNode root = new TrieNode();

    class TrieNode {
        boolean isEndOfWord;
        TrieNode[] children = new TrieNode[26];

        TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < 26; i++)
                children[i] = null;
        }
    }

    public void insert(String key) {
        int length = key.length();
        TrieNode pcrawl = root;
        for (int i = 0; i < length; i++) {
            int index = key.charAt(i)-'a';
            if (pcrawl.children[index] == null)
                pcrawl.children[index] = new TrieNode();
            pcrawl = pcrawl.children[index];

        }
        pcrawl.isEndOfWord = true;

    }

    public void search(String key) {
        int length = key.length();
        TrieNode pcrawl = root;

        for (int i = 0; i < length; i++) {
            int ch = key.charAt(i)-'a';
            if (pcrawl.children[ch] == null) {
                System.out.println(" not found ");
                return;
            }
            pcrawl = pcrawl.children[ch];
        }
        System.out.println(" found ");
        return;
    }

    public static void main(String[] args) {
        String[] st = {"hi", "this", "kumar", "vinay", "vin", "the"};
        TrieInsertAndSearch obj = new TrieInsertAndSearch();
        for (int i = 0; i < st.length; i++)
            obj.insert(st[i]);
        String[] find = {"kumar", "good", "vin"};
        for (int i = 0; i < find.length; i++)
            obj.search(find[i]);
    }
}
