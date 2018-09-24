/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    const numHash = {};
    
    for(let i = 0; i < nums.length; i ++) {
        if(numHash[target - nums[i]] != undefined) {
            return [numHash[target - nums[i]], i];
        }
        
        numHash[nums[i]] = i;
    }
};