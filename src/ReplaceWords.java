/*
https://leetcode.com/problems/replace-words/description/
The only modification to the standard Trie, is that we need a function getShortestPrefix that returns the shortest prefix of the given word in the trie, if the shortest prefix exists or return the original word. Once we have this, all we have to do is iterate through the sentence and replace each word with the getShortestPrefix(word) in the trie.
In English, we have a concept called root, which can be followed by some other words to form another longer word - let's call this word successor. For example, the root an, followed by other, which can form another word another.

Now, given a dictionary consisting of many roots and a sentence. You need to replace all the successor in the sentence with the root forming it. If a successor has many roots can form it, replace it with the root with the shortest length.

You need to output the sentence after the replacement.

Example 1:
Input: dict = ["cat", "bat", "rat"]
sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"
*/
public String replaceWords(List<String> dict, String sentence) {
    Trie trie = new Trie(256);
    dict.forEach(s -> trie.insert(s));
    List<String> res = new ArrayList<>();
    Arrays.stream(sentence.split(" ")).forEach(str -> res.add(trie.getShortestPrefix(str)));
    return res.stream().collect(Collectors.joining(" "));
}


class Trie {
    private int R;
    private TrieNode root;

    public Trie(int R) {
        this.R = R;
        root = new TrieNode();
    }

    // Returns the shortest prefix of the word that is there in the trie
    // If no such prefix exists, return the original word
    public String getShortestPrefix(String word) {
        int len =  getShortestPrefix(root, word, -1);
        return (len < 1) ? word : word.substring(0, len);
    }

    private int getShortestPrefix(TrieNode root, String word, int res) {
        if(root == null || word.isEmpty()) return 0;
        if(root.isWord) return res + 1;
        return getShortestPrefix(root.next[word.charAt(0)], word.substring(1), res+1);
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        insert(root, word);
    }

    private void insert(TrieNode root, String word) {
        if (word.isEmpty()) { root.isWord = true; return; }
        if (root.next[word.charAt(0)] == null) root.next[word.charAt(0)] = new TrieNode();
        insert(root.next[word.charAt(0)], word.substring(1));
    }

    private class TrieNode {
        private TrieNode[] next = new TrieNode[R];
        private boolean isWord;
    }
}
