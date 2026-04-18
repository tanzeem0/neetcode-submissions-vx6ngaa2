class TimeMap {
    HashMap<String, List<Pair>> map;

    class Pair {
        int timestamp;
        String value;
        Pair(int t, String v) {
            timestamp = t;
            value = v;
        }
    }

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>())
           .add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";

        List<Pair> list = map.get(key);
        int s = 0, e = list.size() - 1;
        String res = "";

        while (s <= e) {
            int m = s + (e - s) / 2;

            if (list.get(m).timestamp <= timestamp) {
                res = list.get(m).value;
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        return res;
    }
}