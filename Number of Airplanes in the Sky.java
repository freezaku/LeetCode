Given an interval list which are flying and landing time of the flight. How many airplanes are on the sky at most?

 Notice

If landing and flying happens at the same time, we consider landing should happen at first.

Have you met this question in a real interview? Yes
Example
For interval list

[
  [1,10],
  [2,3],
  [5,8],
  [4,7]
]
Return 3


/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * @param intervals: An interval array
     * @return: Count of airplanes are in the sky.
     */
    class Point {
        int time;
        int flag;
        public Point(int time, int flag) {
            this.time = time;
            this.flag = flag;
        }
    }
    public int countOfAirplanes(List<Interval> airplanes) { 
        // write your code here
        int res = 0;
        List<Point> list = new ArrayList<>();
        for(Interval airplane: airplanes) {
            list.add(new Point(airplane.start, 1));
            list.add(new Point(airplane.end, -1));
        }
        Collections.sort(list, 
            new Comparator<Point>() {
                public int compare(Point a, Point b) {
                    if(a.time == b.time)    return a.flag - b.flag;
                    return a.time - b.time;
                }
            }
        );
        int sum = 0;
        for(Point point: list) {
            sum += point.flag;
            res = Math.max(res, sum);
        }
        return res;
    }
}

/*
就是找interval重合最多的地方，
1. 可以使用hashmap
2. 比较简便的就是这种方法，
利用一个point类型，将起飞和降落的时间，及其类型存储在point中，
然后按照时间进行排序，若时间相同，按照题目描述，先降落后起飞，
然后遍历这个list，
遇到起飞的point，就 ++，
遇到降落的piint，就 --，
利用res来track这个出现的最大值
*/