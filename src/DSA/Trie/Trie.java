package DSA.Trie;

import java.util.*;

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isWord = false;
    int wordCount = 0; // Count of words ending at this node
    int prefixCount = 0; // Count of words passing through this node

    // Optional: store the actual word for easier retrieval
    String word = null;
}

public class Trie {
    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public Trie(String[] words) {
        this();
        for (String word : words) {
            insert(word);
        }
    }

    // ==================== BASIC OPERATIONS ====================

    /**
     * Insert a word into the DSA.Trie
     */
    public void insert(String word) {
        if (word == null || word.isEmpty()) return;

        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node.prefixCount++;
            node = node.children.computeIfAbsent(c, k -> new TrieNode());
        }
        node.prefixCount++;

        if (!node.isWord) {
            node.isWord = true;
            node.word = word;
            node.wordCount++;
        } else {
            node.wordCount++; // Handle duplicate insertions
        }
    }

    /**
     * Search for a full word in the DSA.Trie
     */
    public boolean search(String word) {
        if (word == null) return false;

        TrieNode node = findNode(word);
        return node != null && node.isWord;
    }

    /**
     * Check if any word starts with the given prefix
     */
    public boolean startsWith(String prefix) {
        if (prefix == null) return false;
        return findNode(prefix) != null;
    }

    /**
     * Delete a word from the DSA.Trie
     */
    public boolean delete(String word) {
        if (word == null || !search(word)) return false;

        return deleteHelper(root, word, 0);
    }

    private boolean deleteHelper(TrieNode node, String word, int index) {
        if (index == word.length()) {
            node.isWord = false;
            node.word = null;
            node.wordCount = 0;
            node.prefixCount--;
            return node.children.isEmpty(); // Return true if node can be deleted
        }

        char c = word.charAt(index);
        TrieNode child = node.children.get(c);

        boolean shouldDeleteChild = deleteHelper(child, word, index + 1);

        if (shouldDeleteChild) {
            node.children.remove(c);
        }

        node.prefixCount--;

        // Return true if current node can be deleted
        return !node.isWord && node.children.isEmpty();
    }

    // ==================== SEARCH AND RETRIEVAL ====================

    /**
     * Get all words with the given prefix using DFS
     */
    public List<String> collectAllWordsDFS(String prefix) {
        List<String> result = new ArrayList<>();
        TrieNode node = findNode(prefix);

        if (node != null) {
            StringBuilder sb = new StringBuilder(prefix);
            dfs(node, sb, result);
        }
        return result;
    }

    private void dfs(TrieNode node, StringBuilder sb, List<String> result) {
        if (node.isWord) {
            result.add(sb.toString());
        }

        for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
            sb.append(entry.getKey());
            dfs(entry.getValue(), sb, result);
            sb.setLength(sb.length() - 1); // backtrack
        }
    }

    /**
     * Get all words with the given prefix using BFS
     */
    public List<String> collectAllWordsBFS(String prefix) {
        List<String> result = new ArrayList<>();
        TrieNode startNode = findNode(prefix);

        if (startNode == null) return result;

        Queue<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(startNode, prefix));

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            TrieNode node = current.node;
            String currentStr = current.str;

            if (node.isWord) {
                result.add(currentStr);
            }

            for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
                queue.offer(new Pair(entry.getValue(), currentStr + entry.getKey()));
            }
        }

        return result;
    }

    /**
     * Get all words in the DSA.Trie
     */
    public List<String> getAllWords() {
        return collectAllWordsDFS("");
    }

    /**
     * Find longest common prefix of all words
     */
    public String longestCommonPrefix() {
        StringBuilder result = new StringBuilder();
        TrieNode node = root;

        while (node.children.size() == 1 && !node.isWord) {
            Map.Entry<Character, TrieNode> entry = node.children.entrySet().iterator().next();
            result.append(entry.getKey());
            node = entry.getValue();
        }

        return result.toString();
    }

    /**
     * Auto-complete: get suggestions for a prefix (limited count)
     */
    public List<String> autoComplete(String prefix, int maxSuggestions) {
        List<String> result = new ArrayList<>();
        TrieNode node = findNode(prefix);

        if (node != null) {
            StringBuilder sb = new StringBuilder(prefix);
            autoCompleteDFS(node, sb, result, maxSuggestions);
        }

        return result;
    }

    private void autoCompleteDFS(TrieNode node, StringBuilder sb, List<String> result, int maxSuggestions) {
        if (result.size() >= maxSuggestions) return;

        if (node.isWord) {
            result.add(sb.toString());
        }

        for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
            if (result.size() >= maxSuggestions) break;
            sb.append(entry.getKey());
            autoCompleteDFS(entry.getValue(), sb, result, maxSuggestions);
            sb.setLength(sb.length() - 1);
        }
    }

    // ==================== PATTERN MATCHING ====================

    /**
     * Search with wildcard support ('.' matches any character)
     */
    public boolean searchWithWildcard(String pattern) {
        return searchWildcardHelper(root, pattern, 0);
    }

    private boolean searchWildcardHelper(TrieNode node, String pattern, int index) {
        if (index == pattern.length()) {
            return node.isWord;
        }

        char c = pattern.charAt(index);
        if (c == '.') {
            for (TrieNode child : node.children.values()) {
                if (searchWildcardHelper(child, pattern, index + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            TrieNode child = node.children.get(c);
            return child != null && searchWildcardHelper(child, pattern, index + 1);
        }
    }

    /**
     * Find all words matching a pattern with wildcards
     */
    public List<String> findWordsWithPattern(String pattern) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        findPatternHelper(root, pattern, 0, sb, result);
        return result;
    }

    private void findPatternHelper(TrieNode node, String pattern, int index, StringBuilder sb, List<String> result) {
        if (index == pattern.length()) {
            if (node.isWord) {
                result.add(sb.toString());
            }
            return;
        }

        char c = pattern.charAt(index);
        if (c == '.') {
            for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
                sb.append(entry.getKey());
                findPatternHelper(entry.getValue(), pattern, index + 1, sb, result);
                sb.setLength(sb.length() - 1);
            }
        } else {
            TrieNode child = node.children.get(c);
            if (child != null) {
                sb.append(c);
                findPatternHelper(child, pattern, index + 1, sb, result);
                sb.setLength(sb.length() - 1);
            }
        }
    }

    // ==================== STATISTICS ====================

    /**
     * Count total number of words in the DSA.Trie
     */
    public int countWords() {
        return countWordsHelper(root);
    }

    private int countWordsHelper(TrieNode node) {
        int count = node.isWord ? node.wordCount : 0;
        for (TrieNode child : node.children.values()) {
            count += countWordsHelper(child);
        }
        return count;
    }

    /**
     * Count words with given prefix
     */
    public int countWordsWithPrefix(String prefix) {
        TrieNode node = findNode(prefix);
        return node != null ? countWordsHelper(node) : 0;
    }

    /**
     * Get frequency of a specific word
     */
    public int getWordFrequency(String word) {
        TrieNode node = findNode(word);
        return (node != null && node.isWord) ? node.wordCount : 0;
    }

    /**
     * Find shortest word in the DSA.Trie
     */
    public String findShortestWord() {
        StringBuilder result = new StringBuilder();
        findShortestWordHelper(root, new StringBuilder(), result);
        return result.length() > 0 ? result.toString() : null;
    }

    private boolean findShortestWordHelper(TrieNode node, StringBuilder current, StringBuilder result) {
        if (node.isWord) {
            if (result.length() == 0 || current.length() < result.length()) {
                result.setLength(0);
                result.append(current);
            }
            return true;
        }

        boolean found = false;
        for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
            current.append(entry.getKey());
            if (findShortestWordHelper(entry.getValue(), current, result)) {
                found = true;
            }
            current.setLength(current.length() - 1);
        }
        return found;
    }

    /**
     * Find longest word in the DSA.Trie
     */
    public String findLongestWord() {
        StringBuilder result = new StringBuilder();
        findLongestWordHelper(root, new StringBuilder(), result);
        return result.length() > 0 ? result.toString() : null;
    }

    private void findLongestWordHelper(TrieNode node, StringBuilder current, StringBuilder result) {
        if (node.isWord && current.length() > result.length()) {
            result.setLength(0);
            result.append(current);
        }

        for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
            current.append(entry.getKey());
            findLongestWordHelper(entry.getValue(), current, result);
            current.setLength(current.length() - 1);
        }
    }

    // ==================== UTILITY METHODS ====================

    /**
     * Helper method to find a node for given prefix
     */
    private TrieNode findNode(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            node = node.children.get(c);
            if (node == null) return null;
        }
        return node;
    }

    /**
     * Check if DSA.Trie is empty
     */
    public boolean isEmpty() {
        return root.children.isEmpty();
    }

    /**
     * Clear all words from the DSA.Trie
     */
    public void clear() {
        root.children.clear();
        root.isWord = false;
        root.prefixCount = 0;
        root.wordCount = 0;
    }

    /**
     * Print all words in the DSA.Trie in lexicographical order
     */
    public void printAllWords() {
        System.out.println("All words in DSA.Trie:");
        List<String> words = getAllWords();
        Collections.sort(words);
        for (String word : words) {
            System.out.println("  " + word);
        }
    }

    /**
     * Print DSA.Trie structure (for debugging)
     */
    public void printStructure() {
        System.out.println("DSA.Trie structure:");
        printStructureHelper(root, "", 0);
    }

    private void printStructureHelper(TrieNode node, String prefix, int depth) {
        if (node.isWord) {
            System.out.println("  ".repeat(depth) + prefix + " (WORD, count: " + node.wordCount + ")");
        }

        for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
            printStructureHelper(entry.getValue(), prefix + entry.getKey(), depth + 1);
        }
    }

    // Helper class for BFS
    private static class Pair {
        TrieNode node;
        String str;

        Pair(TrieNode node, String str) {
            this.node = node;
            this.str = str;
        }
    }

    // ==================== DEMO ====================

    public static void main(String[] args) {
        System.out.println("=== Enhanced DSA.Trie Operations Demo ===\n");

        String[] words = {"apple", "app", "apps", "application", "apply", "banana", "band", "bandana", "cat", "car", "card", "care", "careful"};
        Trie trie = new Trie(words);

        // Add some duplicates to test frequency
        trie.insert("app");
        trie.insert("apple");

        System.out.println("=== Basic Operations ===");
        System.out.println("Search 'app': " + trie.search("app"));
        System.out.println("Search 'application': " + trie.search("application"));
        System.out.println("Search 'apply': " + trie.search("apply"));
        System.out.println("Starts with 'app': " + trie.startsWith("app"));
        System.out.println("Starts with 'xyz': " + trie.startsWith("xyz"));
        System.out.println();

        System.out.println("=== Word Collection ===");
        System.out.println("Words with prefix 'app': " + trie.collectAllWordsDFS("app"));
        System.out.println("Words with prefix 'car': " + trie.collectAllWordsBFS("car"));
        System.out.println("Auto-complete 'ban' (max 3): " + trie.autoComplete("ban", 3));
        System.out.println();

        System.out.println("=== Pattern Matching ===");
        System.out.println("Search pattern 'a..': " + trie.searchWithWildcard("a.."));
        System.out.println("Words matching 'ca.': " + trie.findWordsWithPattern("ca."));
        System.out.println("Words matching 'app.': " + trie.findWordsWithPattern("app."));
        System.out.println();

        System.out.println("=== Statistics ===");
        System.out.println("Total words: " + trie.countWords());
        System.out.println("Words with prefix 'app': " + trie.countWordsWithPrefix("app"));
        System.out.println("Frequency of 'app': " + trie.getWordFrequency("app"));
        System.out.println("Frequency of 'apple': " + trie.getWordFrequency("apple"));
        System.out.println("Shortest word: '" + trie.findShortestWord() + "'");
        System.out.println("Longest word: '" + trie.findLongestWord() + "'");
        System.out.println("Longest common prefix: '" + trie.longestCommonPrefix() + "'");
        System.out.println();

        System.out.println("=== Deletion ===");
        System.out.println("Delete 'apps': " + trie.delete("apps"));
        System.out.println("Search 'apps' after deletion: " + trie.search("apps"));
        System.out.println("Words with prefix 'app' after deletion: " + trie.collectAllWordsDFS("app"));
        System.out.println();

        System.out.println("=== Structure Display ===");
        trie.printStructure();
        System.out.println();

        trie.printAllWords();
    }
}