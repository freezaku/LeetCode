public class Solution {
    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        
        int index = Collections.binarySearch(arr, x);
        
        if(index < 0) {
            index = - (index + 1);
        }
        System.out.println(index);
        
        if(index == 0) {
            for(int i = 0; i < k; i ++) {
                res.add(arr.get(i));
            }
            return res;
        } else if(index == arr.size()) {
            for(int i = arr.size() - k; i < arr.size(); i ++) {
                res.add(arr.get(i));
            }
            return res;
        }
        
        int left = index - 1;
        int right = index;
        int count = 0;
        System.out.println(left + " " + right);
        
        while(count < k && left >= 0 && right < arr.size()) {
            int leftDiff = arr.get(left) - x;
            int rightDiff = arr.get(right) - x;
            if(Math.abs(leftDiff) <= Math.abs(rightDiff)) {
                res.add(arr.get(left));
                left --;
            } else {
                res.add(arr.get(right));
                right ++;
            }
            count ++;
        }
        
        if(count == k) {
            Collections.sort(res);
            return res;
        }
        
        if(left >= 0) {
            while(count < k) {
                res.add(arr.get(left));
                left --;
                count ++;
            }
        } else {
            while(count < k) {
                res.add(arr.get(right));
                right ++;
                count ++;
            }
        }
        
        Collections.sort(res);
        return res;
    }
}