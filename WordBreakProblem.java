import java.util.*;

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd;

    TrieNode() {
        isEnd = false;
    }
}

class Trie {
    TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (node.children[idx] == null)
                node.children[idx] = new TrieNode();
            node = node.children[idx];
        }
        node.isEnd = true;
    }

    boolean search(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (node.children[idx] == null)
                return false;
            node = node.children[idx];
        }
        return node.isEnd;
    }
}

public class WordBreakProblem {
    Trie trie;

    WordBreakProblem() {
        trie = new Trie();
    }

    boolean wordBreak(String s) {
        if (s.isEmpty()) return true;

        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);
            String suffix = s.substring(i);

            if (trie.search(prefix) && wordBreak(suffix))
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        WordBreakProblem solver = new WordBreakProblem();
        List<String> wordDict = Arrays.asList("leet", "code", "break");
        String s = "leetcode";

        for (String word : wordDict)
            solver.trie.insert(word);

        System.out.println("Can be segmented: " + solver.wordBreak(s));
    }
}

