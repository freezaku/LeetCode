class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_map<char, int> map;
        int res = 0;
        
        for(int i = 0, j = 0; i < s.size(); i ++) {            
            if(map.find(s[i]) != map.end()) {
                j = max(j, (map.find(s[i])->second));
            }
            
            res = max(res, i - j + 1);
            map[s[i]] = i + 1;
        }
        
        return res;
    }
};
