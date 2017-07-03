Given a set of words without duplicates, find all word squares you can build from them.

A sequence of words forms a valid word square if the kth row and column read the exact same string, where 0 ≤ k < max(numRows, numColumns).

For example, the word sequence ["ball","area","lead","lady"] forms a word square because each word reads the same both horizontally and vertically.

b a l l
a r e a
l e a d
l a d y
 Notice

There are at least 1 and at most 1000 words.
All words will have the exact same length.
Word length is at least 1 and at most 5.
Each word contains only lowercase English alphabet a-z.
Have you met this question in a real interview? Yes
Example
Given a set ["area","lead","wall","lady","ball"]
return [["wall","area","lead","lady"],["ball","area","lead","lady"]]
Explanation:
The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).

Given a set ["abat","baba","atan","atal"]
return [["baba","abat","baba","atan"],["baba","abat","baba","atal"]]
Explanation:
The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).

public class Solution {
    /**
     * @param words a set of words without duplicates
     * @return all word squares
     */
    class TrieNode {
        List<String> wordList;
        TrieNode[] children;
        Character value;
        public TrieNode() {
            value = null;
            wordList = new ArrayList<>();
            children = new TrieNode[26];
        }
        public TrieNode(char chr) {
            value = chr;
            wordList = new ArrayList<>();
            children = new TrieNode[26];
        }
    }
    
    class Trie {
        TrieNode root;
        public Trie(String[] words) {
            root = new TrieNode();
            for(String word: words) {
                TrieNode cur = root;
                for(char chr: word.toCharArray()) {
                    int index = chr - 'a';
                    if(cur.children[index] == null) {
                        cur.children[index] = new TrieNode(chr);
                    }
                    cur.children[index].wordList.add(word);
                    cur = cur.children[index];
                }
            }
        }
        public List<String> findCandidate(String prefix) {
            List<String> list = new ArrayList<>();
            TrieNode cur = root;
            for(char chr: prefix.toCharArray()) {
                int index = chr - 'a';
                if(cur.children[index] == null) return list;
                cur = cur.children[index];
            }
            list.addAll(cur.wordList);
            return list;
        }
    }
    
    public List<List<String>> wordSquares(String[] words) {
        // Write your code here
        List<List<String>> res = new ArrayList<>();
        if(words == null || words.length == 0)  return res;
        Trie trie = new Trie(words);
        int len = words[0].length();
        List<String> list = new ArrayList<>();
        for(String word: words) {
            list.add(word);
            search(trie, res, list, len);
            list.remove(list.size() - 1);
        }
        return res;
    }
    
    private void search(Trie trie, List<List<String>> res, List<String> list, int len) {
        if(list.size() == len) {
            res.add(new ArrayList<>(list));
            return;
        }
        int idx = list.size();
        StringBuilder prefix = new StringBuilder();
        for(String word: list) {
            prefix.append(word.charAt(idx));
        }
        List<String> candidates = trie.findCandidate(prefix.toString());
        for(String candidate: candidates) {
            list.add(candidate);
            search(trie, res, list, len);
            list.remove(list.size() - 1);
        }
    }
}

/*
一个月之内做的第二遍，依然不太会，偶尔看看
*/