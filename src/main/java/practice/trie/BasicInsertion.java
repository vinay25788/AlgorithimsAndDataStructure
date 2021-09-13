package practice.trie;

class TrieNode
{

    char data;
    TrieNode[] child = new TrieNode[26];
    boolean isEndOfWord = false;

    TrieNode()
    {

        this.isEndOfWord = false;
        for(int i=0;i<26;i++)
            child[i] = null;
    }

}
class Trie
{
   static TrieNode root;

    public static void insert(String key) {
        TrieNode crawl = root;
        int n = key.length();


        for (int i = 0; i < n; i++)
        {
            int ch = key.charAt(i)-'a';

            if(crawl.child[ch] == null)
                crawl.child[ch] = new TrieNode();
            crawl = crawl.child[ch];
        }
        crawl.isEndOfWord = true;
    }

    public static void search(String key)
    {
        int n = key.length();
        TrieNode crawl = root;
        for(int i=0;i<n;i++)
        {
            int ch = key.charAt(i)-'a';
            if(crawl.child[ch] == null)
            {
                System.out.println(" not found ");
                return;
            }
            crawl = crawl.child[ch];
        }

        System.out.println(" found "+crawl.isEndOfWord);
    }
}


public class BasicInsertion {

    public static void main(String[] args) {
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their"};

   Trie.root = new TrieNode();

   for(int i=0;i< keys.length;i++)
       Trie.insert(keys[i]);

        Trie.search("the");
        Trie.search("vinay");



    }
}
