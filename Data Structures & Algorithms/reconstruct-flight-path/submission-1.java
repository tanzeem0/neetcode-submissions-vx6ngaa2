class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        // Eulerian Circuit - 
        /**
            1. From a start point go as deep as possible untill nowhere can be reached.
            2. While returning add the nodes to answer
            3. Reverse and return it
         */
        List<String> res = new ArrayList<>();
        // Adjacency list with reverse lexicographic ordering
        Map<String,PriorityQueue<String>> adj = new HashMap<>();
        for(List<String> ticket:tickets){
            String src = ticket.get(0), dst = ticket.get(1);
            adj.computeIfAbsent(src,k->new PriorityQueue<>()).offer(dst);
        }

        // Stack to mimic the itineary
        Stack<String> st = new Stack<>();
        st.push("JFK");
        while(!st.isEmpty()){
            String src = st.peek();
            // either src does not have a outer edge or it has exhausted all its edges
            if(!adj.containsKey(src) || adj.get(src).isEmpty()){
                res.add(st.pop());
            }else{
                st.push(adj.get(src).poll());
            }
        } 
        Collections.reverse(res);
        return res;
    }
}