public class LogSystem {
    Map<String, Integer> map;
    public LogSystem() {
        map = new HashMap<>();
    }
    
    public void put(int id, String timestamp) {
        map.put(timestamp, id);
    }
    
    public List<Integer> retrieve(String s, String e, String gra) {
        String start = process(s, gra, "0000:00:00:00:00:00");
        String end = process(e, gra, "9999:12:31:23:59:59");
        List<Integer> res = new ArrayList<>();
        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            String timestamp = entry.getKey();
            int id = entry.getValue();
            if(start.compareTo(timestamp) <= 0 && end.compareTo(timestamp) >= 0) {
                res.add(id);
            }
        }
        return res;
    }
    
    
    private String process(String str, String gra, String remain) {
        switch(gra) {
            case "Year":
                return str.substring(0, 4) + remain.substring(4);
            case "Month":
                return str.substring(0, 7) + remain.substring(7);
            case "Day":
                return str.substring(0, 10) + remain.substring(10);
            case "Hour":
                return str.substring(0, 13) + remain.substring(13);
            case "Minute":
                return str.substring(0, 16) + remain.substring(16);
            case "Second":
                return str.substring(0, 19) + remain.substring(19);
            default:
                return "";
        }
    }
}

/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(s,e,gra);
 */

/*
用map存储id和timestamp，
对于指定的gra，根据gra来组合新的start和end的范围，
利用substring，从str中获取固定的部分，从remain中获取可以变化的部分。
*/