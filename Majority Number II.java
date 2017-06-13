Given an array of integers and a number k, the majority number is the number that occurs more than 1/k of the size of the array.

Find it.

Example
Given [3,1,2,3,2,3,3,4,4,4] and k=3, return 3.

public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: As described
     * @return: The majority number
     */
    public int majorityNumber(ArrayList<Integer> nums, int k) {
        // write your code
        List<Integer> count = new ArrayList<>();
        List<Integer> candidate = new ArrayList<>();
        
        for(int i = 0; i < nums.size(); i ++) {
            int num = nums.get(i);
            if(candidate.size() < k - 1 && !candidate.contains(num)) {
                candidate.add(num);
                count.add(1);
            } else {
                int index = candidate.indexOf(num);
                if(index != -1) {
                    count.set(index, count.get(index) + 1);
                } else {
                    int zeroIndex = count.indexOf(0);
                    if(zeroIndex != -1) {
                        count.remove(zeroIndex);
                        candidate.remove(zeroIndex);
                        count.add(1);
                        candidate.add(num);
                    } else {
                        for(int j = 0; j < count.size(); j ++) {
                            count.set(j, count.get(j) - 1);
                        }
                    }
                } 
            }
        }
        
        for(int i = 0;i < candidate.size(); i ++) {
            int cot = 0;
            System.out.println("candidate is: " + candidate.get(i));
            for(int num: nums) {
                if(candidate.get(i) == num) {
                    cot ++;
                }
            }

            if(cot > nums.size() / k)   return candidate.get(i);
        }
        return -1;
    }
}

/*
利用两个list，一个存储candidate，一个存储对应candidate出现的次数，
如果candidate数组中不包含这个数，且candidate的size小于k-1，直接将该数加到candidate中，
否则，
如果candidate中有该数，直接将其对应count++，
如果count数组中有0，则将该count位置和对应的candidate去除，再将该数加入candidate和count中，
如果count中没有0，则将所有count进行--，
最后两层循环，遍历candidate和nums，计算candidate出现的次数，满足条件的return
*/
