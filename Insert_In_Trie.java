class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord;

    TrieNode() {
        isEndOfWord = false;
    }
}

public class Insert_In_Trie {
    private TrieNode root;

    public Insert_In_Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null)
                node.children[index] = new TrieNode();
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    public static void main(String[] args) {
        Insert_In_Trie trie = new Insert_In_Trie();
        trie.insert("apple");
        trie.insert("app");
        trie.insert("bat");
        System.out.println("Words inserted into Trie.");
    }
}
