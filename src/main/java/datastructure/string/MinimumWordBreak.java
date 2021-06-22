package datastructure.string;

public class MinimumWordBreak {

    TrieNode root = new TrieNode();
    int minWordBreak = Integer.MAX_VALUE;

    class TrieNode {
        boolean isEndOfFile;
        TrieNode[] childrens = new TrieNode[26];

        TrieNode() {
            isEndOfFile = false;
            for (int i = 0; i < 26; i++)
                childrens[i] = null;
        }
    }

    public void insert(String key) {
        int length = key.length();
        TrieNode pcrawl = root;
        int index = 0;
        for (int i = 0; i < length; i++) {
            index = key.charAt(i) - 'a';
            if (pcrawl.childrens[index] == null)
                pcrawl.childrens[index] = new TrieNode();
            pcrawl = pcrawl.childrens[index];
        }
        pcrawl.isEndOfFile = true;
    }

    void minWordBreak(String key) {
        minWordBreak = Integer.MAX_VALUE;
        minWordBreakUtil(root, key, 0, minWordBreak, 0);
    }

    public void minWordBreakUtil(TrieNode root, String key, int start, int wordBreak, int level) {
        TrieNode pcrawl = root;
        if (start == key.length()) {
            wordBreak = Math.min(wordBreak, level - 1);
            if (minWordBreak > wordBreak)
                minWordBreak = wordBreak;
            return;
        }

        for (int i = start; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (pcrawl.childrens[index] == null)
                return;
            if (pcrawl.childrens[index].isEndOfFile)
                minWordBreakUtil(root, key, i + 1, wordBreak, level + 1);
            pcrawl = pcrawl.childrens[index];
        }
    }

    public static void main(String[] args) {
        String keys[] = {"cat", "mat", "ca", "ma",
                "at", "c", "dog", "og", "do"};
        MinimumWordBreak obj = new MinimumWordBreak();
        int i;
        for (i = 0; i < keys.length; i++)
            obj.insert(keys[i]);

        obj.minWordBreak("catmatat");

        System.out.println(obj.minWordBreak);

    }


}
