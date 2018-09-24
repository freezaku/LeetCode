/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
    if(!s || s.length == 0)  return 0;
    
    let hash = {};
    let maxLen = 0;
    for(let i = 0, j = 0; j < s.length; j ++) {
        const chr = s[j];
        if(hash[chr] != undefined) {
            i = Math.max(i, hash[chr] + 1);
        }
        
        hash[chr] = j;
        maxLen = Math.max(maxLen, j - i + 1);
    }
    
    return maxLen;
};