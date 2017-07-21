public class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        Set<String> prefix = new HashSet<>();
        
        Arrays.sort(words, new Comparator<String>() {
            public int compare(String a, String b) {
                return a.length() - b.length();
            }
        });
        
        for(String word: words) {
            if(helper(word, prefix))    res.add(word);
            prefix.add(word);
        }
        
        return res;
    }
    
    private boolean helper(String word, Set<String> prefix) {
        if(prefix.isEmpty())    return false;
        boolean[] dp = new boolean[word.length() + 1];
        dp[0] = true;
        
        for(int i = 1; i <= word.length(); i ++) {
            for(int j = 0; j < i; j ++) {
                if(!dp[j])  continue;
                if(prefix.contains(word.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[word.length()];
    }
}

/*
将数组按照长度排序，这样可以保证我们不会遗漏需要的结果word，
遍历数组，每个word都需要一个个放入prefix的set中，
对于每个word，进入helper函数，构造一个boolean的dp数组，
然后看这个word，能不能由prefix内的worddict构成，
将该word利用两个for循环进行分割，contains他的substring，就将其置为true，
最后返回dp[n]，为true表明这个word满足条件
*/

public class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        Trie tree = new Trie();
        for (String s: words) {
            tree.insert(s);
        }
        for (String s: words) {
            if (helper(s, tree))    res.add(s);
        }
        return res;
    }
    public boolean helper(String s, Trie tree) {
        TrieNode cur = tree.root;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            int index = arr[i] - 'a';
            cur = cur.children[index];
            if (cur == null)    return false;
            String suffix = s.substring(i+1);
            // tree.search(suffix) means the combination for this s consists of two words: cur + suffix
            // helper(suffix, tree) means there will be further level searching, the combination consists of more than two words
            if (cur.isWord && (tree.search(suffix) || helper(suffix, tree)))  return true;
        }
        return false;
    }
    class TrieNode {
        char val;
        boolean isWord;
        TrieNode[] children;
        public TrieNode(char val) {
            this.val = val;
            this.isWord = false;
            children = new TrieNode[26];
        }
    }
    class Trie {
        TrieNode root;
        public Trie() {
            this.root = new TrieNode(' ');
        }
        public void insert(String s) {
            TrieNode cur = root;
            char[] arr = s.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                int index = arr[i] - 'a';
                if (cur.children[index] == null)    cur.children[index] = new TrieNode(arr[i]);
                cur = cur.children[index];
            }
            cur.isWord = true;
        }
        public boolean search(String s) {
            TrieNode cur = root;
            char[] arr = s.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                int index = arr[i]-'a';
                if (cur.children[index] == null)    return false;
                cur = cur.children[index];
            }
            return cur.isWord;
        }
    }
}
/*
直接利用trie tree的基本构成形式，没有添加其他的特殊方法和变量，
在helper函数中，也是利用不断的substring，
对于每个substring的处理的结果，分为前后两部分，
若前部分isword为true，而后部分suffix能够找到或者能够使用更多的word构成，则直接返回true
*/