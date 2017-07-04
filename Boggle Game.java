Given a board which is a 2D matrix includes a-z and dictionary dict, find the largest collection of words on the board, the words can not overlap in the same position. return the size of largest collection.

Have you met this question in a real interview? Yes
Example
Give a board below

[['a', 'b', 'c'],
 ['d', 'e', 'f'],
 ['g', 'h', 'i']]
dict = ["abc", "cfi", "beh", "defi", "gh"]
Return 3 // we can get the largest collection["abc", "defi", "gh"]

public class Solution {
    /**
     * @param board a list of lists of character
     * @param words a list of string
     * @return an integer
     */
    class TrieNode {
        boolean isWord;
        TrieNode[] children;
        Character value;
        public TrieNode() {
            isWord = false;
            children = new TrieNode[26];
            value = null;
        }
        public TrieNode(char chr) {
            isWord = false;
            children = new TrieNode[26];
            value = chr;
        }
    }
    
    class Trie {
        TrieNode root;
        public Trie() {
            root = new TrieNode();
        }
        public void insert(String word) {
            if(word == null || word.length() == 0) {
                return;
            }
            TrieNode cur = root;
            for(char chr: word.toCharArray()) {
                int index = chr - 'a';
                if(cur.children[index] == null) {
                    cur.children[index] = new TrieNode();
                }
                cur = cur.children[index];
            }
            cur.isWord = true;
        }
    }
    
    public int boggleGame(char[][] board, String[] words) {
        // Write your code here
        Trie trie = new Trie();
        for(String word: words) {
            trie.insert(word);
        }
        
        int m = board.length;
        int n = board[0].length;
        List<String> result = new ArrayList<>();
        boolean[][] visited = new boolean[m][n];
        List<String> path = new ArrayList<>();
        findWords(result, board, visited, path, 0, 0, trie.root);
        
        return result.size();
    }
    
    private void findWords(List<String> result, char[][] board, boolean[][] visited, List<String> words, int x, int y, TrieNode root) {
        int m = board.length;
        int n = board[0].length;
        
        for(int i = x; i < m; i ++) {
            for(int j = y; j < n; j ++) {
                List<List<Integer>> nextWordIndexes = new ArrayList<>();
                List<Integer> path = new ArrayList<>();
                getNextWords(nextWordIndexes, board, visited, path, i, j, root);
                
                for(List<Integer> indexes: nextWordIndexes) {
                    String word = "";
                    for(int index: indexes) {
                        int row = index / n;
                        int col = index % n;
                        visited[row][col] = true;
                        word += board[row][col];
                    }
                    words.add(word);
                    if(words.size() > result.size()) {
                        result.clear();
                        result.addAll(words);
                    }
                    findWords(result, board, visited, words, i, j, root);
                    for (int index : indexes) {
                        int row = index / n;
                        int col = index % n;
                        visited[row][col] = false;
                    }
                    words.remove(words.size() - 1);
                }
            }
            y = 0;
        }
    }
    
    int []dx = {0, 1, 0, -1};
    int []dy = {1, 0, -1, 0};

     private void getNextWords(List<List<Integer>> words, char[][] board, boolean[][] visited, List<Integer> path, int i, int j, TrieNode root) {
        int m = board.length;
        int n = board[0].length;
        if(i < 0 || i >= m || j < 0 || j >=n || visited[i][j] || root.children[board[i][j] - 'a'] == null)   return;
        
        TrieNode cur = root.children[board[i][j] - 'a'];
        if(cur.isWord) {
            List<Integer> newPath = new ArrayList<>(path);
            newPath.add(i * n + j);
            words.add(newPath);
            return;
        }
        
        visited[i][j] = true;
        path.add(i * n + j);
        
        for(int k = 0; k < 4; k ++) {
            getNextWords(words, board, visited, path, i + dx[k], j + dy[k], cur);
        }
        
        visited[i][j] = false;
        path.remove(path.size() - 1);
     }
}

/*
令人窒息的Trie秀，基本掌握了Trie这个数据结构，但是用来解决这个问题，还是显得太难了。
构造一个trie tree，放入所有的word，
然后将每个位置作为第一个元素，利用getnextwords进行遍历，
getnextwords用来找以这个位置开头的，能够找到的单词的path，返回这个path，相当于找到了以这个位置开始的所有可能组成的单词，
在findwords中，利用这个path，每次构造出一个单词，放入words中，
相当于测试添加这个word之后，能够寻找res的一个可能性，若words的size大于已有的res，则更新res，
然后再在该位置上继续使用findwords进行寻找，就是再在添加了一个word，在很多位置的visited已经变为true之后，继续寻找单词，
注意在第一次循环j从y开始之后，要将y置为0，保证下一行从第0列开始。
*/