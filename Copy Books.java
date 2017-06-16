Description
Given n books and the ith book has A[i] pages. You are given k people to copy the n books.

n books list in a row and each person can claim a continous range of the n books. For example one copier can copy the books from ith to jth continously, but he can not copy the 1st book, 2nd book and 4th book (without 3rd book).

They start copying books at the same time and they all cost 1 minute to copy 1 page of a book. What the best strategy to assign books so that the slowest copier can finish at earliest time?


Example
Given array A = [3,2,4], k = 2.

Return 5( First person spends 5 minutes to copy book 1 and book 2 and second person spends 4 minutes to copy book 3. )

public class Solution {
    /**
     * @param pages: an array of integers
     * @param k: an integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        // write your code here
        if (pages.length == 0) {
            return 0;  
        }

        int sum = 0;
        int max = pages[0];
        for(int page: pages) {
            sum += page;
            max = Math.max(max, page);
        }
        int start = max;
        int end = sum;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(countPeople(mid, pages) > k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
    private int countPeople(int limit, int[] pages) {
        if (pages.length == 0) {
            return 0;
        }
        
        int sum = pages[0];
        int people = 1;
        
        for(int i = 1; i < pages.length; i ++) {
            if(sum + pages[i] > limit) {
                sum = 0;
                people ++;
            }
            sum += pages[i];
        }

        return people;
    }
}

/*
最大值最小化问题。
讲一个序列分割成m个连续子序列，使子序列中最大的值最小。
我们可以将优化问题转化为判定问题，
利用二分法，判定当最大值最小为P的时候，用m个子序列能否完成这个任务。

此题中，求出sum和max，则最大值一定在这两个范围之内，
利用二分法获得该值，
然后将该值作为limit传入countPeople函数，计算出在满足该limit的情况下，需要多少人来完成，
计算出的人数若大于k的话，则说明该最大值过小，需要人数太多，需要增大最大值，每个人承担更多的copy任务，
将start = mid + 1；
反之，若人数小于k，则说明最大值过大，不需要k个人就能完成，有人空闲，需要减小最大值，每个人承担更少的copy任务，
将end = mid - 1；

注意在countPeople函数中的人数计算，当sum加上该数就要超过limit的时候，
要将sum归零，people ++
*/