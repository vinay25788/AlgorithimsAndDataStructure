package datastructure.advancedatastructure.trie;

public class PhoneDirectory {
    TrieNode root;

    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        boolean isEndOfWord;

        TrieNode() {
            for (int i = 0; i < 26; i++)
                child[i] = null;
            isEndOfWord = false;
        }
    }


    public void insertToTrie(String[] st) {
        root = new TrieNode();
        for (int i = 0; i < st.length; i++)
            insert(st[i]);
    }

    public void insert(String st) {
        int length = st.length();
        ;
        TrieNode pcrawl = root;
        for (int i = 0; i < st.length(); i++) {
            int index = st.charAt(i)-'a';
            TrieNode nextNode = pcrawl.child[index];
            if (nextNode == null) {
                nextNode = new TrieNode();
                pcrawl.child[index] = nextNode;
            }
            pcrawl = nextNode;
        }
        pcrawl.isEndOfWord = true;
    }

    public void displayContact(String key) {
        TrieNode pcrawl = root;
        String prefix = "";
        int length = key.length();
        int i = 0;
        for (; i < length; i++) {
            prefix += key.charAt(i);
            int lastCharacter = prefix.charAt(i)-'a';
            TrieNode curNode = pcrawl.child[lastCharacter];
            if (curNode == null) {
                System.out.println(" No result  found for " + prefix + " ");
                i++;
                break;
            }
            System.out.println(" suggestion based on " + prefix);
            displayContactUtil(curNode, prefix);
            pcrawl = curNode;
        }
        for(;i<length;i++)
        {
            prefix+= key.charAt(i);
            System.out.println(" no result found for "+prefix);
        }

    }

    public void displayContactUtil(TrieNode curNode, String prefix) {
        if (curNode.isEndOfWord)
            System.out.println(prefix.toString());
        for (int ch = 0; ch<26; ch++) {
            TrieNode nextNode = curNode.child[ch];
            if (nextNode != null)
                displayContactUtil(nextNode, prefix +(char) (ch+'a'));
        }
    }

    public static void main(String[] args) {
        PhoneDirectory obje = new PhoneDirectory();

        String contacts[] = {"gforgeeks", "geeksquiz"};

        obje.insertToTrie(contacts);

        String query = "gekk";

        // Note that the user will enter 'g' then 'e' so
        // first display all the strings with prefix as 'g'
        // and then all the strings with prefix as 'ge'
        obje.displayContact(query);
    }
}
