public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for(String word: wordDict) {
            set.add(word);
        }
        return dfs(s, set, new HashMap<String, List<String>>());
    }
    
    private List<String> dfs(String s, Set<String> set, Map<String, List<String>> map) {
        if(map.containsKey(s))  return map.get(s);
        
        List<String> res = new ArrayList<>();
        if(s.length() == 0) {
            res.add("");
            return res;
        }
        
        for(String word: set) {
            if(s.startsWith(word)) {
                List<String> sublist = dfs(s.substring(word.length()), set, map);
                for(String next: sublist) {
                    if(!next.isEmpty()) {
                        res.add(word + " " + next);
                    } else {
                        res.add(word);
                    }
                }
            }
        }
        
        map.put(s, res);
        
        return res;
    }
}

/*
这题很容易想到利用记忆化搜索的方法解决，但是如何构造这个记忆化搜索的形式不容易想到。
这题利用的是一个map，key为对应的单词，value为这个单词可以进行的切割的各种方式。

进入dfs辅助函数，若该s已经存在于map中，直接返回其对应的value，
否则，构造res，用他来存储当前对应s的切割方式，
检查s的长度，若s长度为0，将res中加入一个 "" 即可，直接返回，
否则，遍历set中的单词，看有没有单词能作为s的开头，
若可以，将该单词之后的部分作为新的s，进入下一层dfs，得到sublist，
对于sublist中的每个单词，根据其长度和res进行融合并放入res中，
最后将该s和得到的对应res放入map，并返回res
*/