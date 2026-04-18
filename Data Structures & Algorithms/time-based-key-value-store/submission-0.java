class TimeMap {
    HashMap<String,List<String>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        String combineVal = timestamp + "," + value;
        map.computeIfAbsent(key,k -> new ArrayList<>()).add(combineVal);
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        List<String> list = map.get(key);
        int s = 0, e = list.size()-1;
        String res = "";
        while(s<=e)
        {
            int m = (s+e)/2;
            String midStr = list.get(m);
            int midtimestamp = Integer.parseInt(midStr.substring(0,midStr.indexOf(",")));
            if(midtimestamp <= timestamp){
                res = midStr.substring(midStr.indexOf(",")+1,midStr.length());
                s = m+1;
            }else
                e = m-1;
        }
        return res;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */