class Solution {
    public String simplifyPath(String path) {
        String[] strs = path.split("/");
        Deque<String> deque = new LinkedList<>();
        
        for(String str: strs) {
            if(str.equals(""))  continue;
            if((deque.isEmpty() && str.equals("..")) || str.equals("."))   continue;
            if(str.equals("..")) {
                deque.pop();
            } else {
                deque.push(str);
            }
        }
        
        String res = "";
        while(!deque.isEmpty()) {
            res = "/" + deque.pop() + res;
        }
        
        if(res.length() == 0) {
            return "/";
        } else {
            return res;
        }
        
    }
}

/*
 利用stack解决，注意遇到".."的时候，要判断当前deque是否为空
 
 注意点：
 1. 使用stack，最好用deque来代替，deque有两种实现方式，ArrayDeque方法或者LinkedList来实现。
 2. deque为双端队列，可以选择在头或者尾加上活着删去元素
*/