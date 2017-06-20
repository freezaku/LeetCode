public class Solution{
  class TrieNode {
    int[] children;
    boolean isLeaf;
    public TrieNode() {
      children = new int[26];
      isLeaf = false;
    }
  }

  class Trie {
    TrieNode root;
    public Trie() {
      root = new TrieNode();
    }
    public void add(String s) {
      if(s == null || s.length() == 0)  return;
      TrieNode cur = root;
      for(char chr: s.toCharArray()) {
        int index = chr - 'a';
        if(cur.children[index] == null) cur.children[index] = new TrieNode()
        cur = cur.children[index];
      }
      cur.isLeaf = true;
    }
  }

  public List<String> getKEditDistance(String[] words, String target, int k) {
    List<String> result = new ArrayList<>();
     
    if (words == null || words.length == 0 || target == null || target.length() == 0 || k < 0) {
      return result;
    }
     
    Trie trie = new Trie();
    
    for (String word : words) {
      trie.add(word);
    }
     
    TrieNode root = trie.root;
     
    int[] prev = new int[target.length() + 1];
    for (int i = 0; i < prev.length; i++) {
      prev[i] = i;
    }
     
    getKEditDistanceHelper("", target, k, root, prev, result);
     
    return result;
  }
   
  private void getKEditDistanceHelper(String curr, String target, int k, TrieNode root, int[] prevDist, List<String> result) {
    if (root.isLeaf) {
      if (prevDist[target.length()] <= k) {
        result.add(curr);
      } else {
        return;
      }
    }
     
    for (int i = 0; i < 26; i++) {
      if (root.children[i] == null) {
        continue;
      }
       
      int[] currDist = new int[target.length() + 1];
      currDist[0] = curr.length() + 1;
      for (int j = 1; j < prevDist.length; j++) {
        if (target.charAt(j - 1) == (char) (i + 'a')) {
          currDist[j] = prevDist[j - 1];
        } else {
          currDist[j] = Math.min(Math.min(prevDist[j - 1], prevDist[j]), 
                                 currDist[j - 1]) + 1;
        }
      }
       
      getKEditDistanceHelper(curr + (char) (i + 'a'), target, k, 
         root.children[i], currDist, result);
    }
  }