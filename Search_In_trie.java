class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord = false;
}

public class Search_In_trie {
    private final TrieNode root;

    public Search_In_trie() {
        root = new TrieNode();
    }

    public void insert(String key) {
        TrieNode node = root;
        for (int level = 0; level < key.length(); level++) {
            int idx = key.charAt(level) - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
        }
        node.isEndOfWord = true;
    }

    public boolean search(String key) {
        TrieNode node = root;
        for (int level = 0; level < key.length(); level++) {
            int idx = key.charAt(level) - 'a';
            if (node.children[idx] == null) {
                return false;
            }
            node = node.children[idx];
        }
        return node != null && node.isEndOfWord;
    }

    public static void main(String[] args) {
        Search_In_trie trie = new Search_In_trie();
        trie.insert("hello");
        trie.insert("hey");
        trie.insert("heat");

        System.out.println(trie.search("hello")); 
        System.out.println(trie.search("hey"));   
        System.out.println(trie.search("he"));    
        System.out.println(trie.search("heat"));  
        System.out.println(trie.search("hero"));  
    }
}
