public class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> res = new ArrayList<>();
        if(paths == null || paths.length == 0)  return res;
        Map<String, Set<String>> map = new HashMap<>();
        
        for(String path: paths) {
            String[] strs = path.split("\\s+");
            for(int i = 1; i < strs.length; i ++) {
                int idx = strs[i].indexOf("(");
                String content = strs[i].substring(idx);
                String value = strs[0] + "/" + strs[i].substring(0, idx);
                Set<String> values = map.getOrDefault(content, new HashSet<>());
                values.add(value);
                map.put(content, values);
            }
        }
        
        for(String key: map.keySet()) {
            if(map.get(key).size() > 1) {
                List<String> list = new ArrayList<>(map.get(key));
                res.add(list);
            }
        }
        
        return res;
    }
}

/*
这题的主要难点在于字符串的解析，
首先利用正则表达式根据空格将path进行split，然后第一个即为路径，我们直接从第二个开始check，
每次利用indexof截取出content的内容作为map的key，再和路径拼接成为完整的value作为map的set中的值，
最后遍历map，找出重复的content，放入res中.

followup：
1. Imagine you are given a real file system, how will you search files? DFS or BFS ?
In general, BFS will use more memory then DFS. However BFS can take advantage of the locality of files in inside directories, and therefore will probably be faster

2. If the file content is very large (GB level), how will you modify your solution?
In a real life solution we will not hash the entire file content, since it's not practical. 
Instead we will first map all the files according to size. Files with different sizes are guaranteed to be different. 
We will than hash a small part of the files with equal sizes (using MD5 for example). Only if the md5 is the same, we will compare the files byte by byte

3. If you can only read the file by 1kb each time, how will you modify your solution?
This won't change the solution. We can create the hash from the 1kb chunks, and then read the entire file if a full byte by byte comparison is required.

What is the time complexity of your modified solution? What is the most time consuming part and memory consuming part of it? How to optimize?
Time complexity is O(n^2 * k) since in worse case we might need to compare every file to all others. k is the file size

How to make sure the duplicated files you find are not false positive?
We will use several filters to compare: File size, Hash and byte by byte comparisons.
*/