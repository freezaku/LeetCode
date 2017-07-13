public class Solution {
    public List<String> wordsAbbreviation(List<String> dict) {
        int n = dict.size();
        int[] prefix = new int[n];
        String[] ans = new String[n];
        
        for(int i = 0; i < n; i ++) {
            String word = dict.get(i);
            prefix[i] = 1;
            ans[i] = getAbbr(word, 1);
        }
        
        for(int i = 0; i < n; i ++) {
            while(true) {
                Set<Integer> set = new HashSet<>();
                for(int j = i + 1; j < n; j ++) {
                    if(ans[j].equals(ans[i]))   set.add(j);
                }
                if(set.size() == 0) break;
                set.add(i);
                for(int index: set) {
                    prefix[index] ++;
                    ans[index] = getAbbr(dict.get(index), prefix[index]);
                }
            }
        }
        
        return Arrays.asList(ans);
    }
    
    private String getAbbr(String word, int prefix) {
        if(prefix >= word.length() - 2) return word;
        StringBuilder sb = new StringBuilder();
        sb.append(word.substring(0, prefix));
        sb.append(word.length() - 1- prefix);
        sb.append(word.charAt(word.length() - 1));
        return sb.toString();
    }
}

/*
思路不难想，但是有点复杂。
用prefix数组存储对于每个word，保存的前面的数位的个数，用于指示压缩。
ans数组存储每个word压缩过后的值。
然后开始遍历ans，根据要求，不能出现重复的abbr，
因此使用while循环，对于每个word，找其后是否出现了跟他相同的abbr，若有，加入set中，
若set为空的话，则表明没有重复的了，break，
若有的话，将set中重复的abbr取出，将其prefix ++，再次获得一个新的abbr，放入ans中，
直到没有重复且遍历完ans为止
*/