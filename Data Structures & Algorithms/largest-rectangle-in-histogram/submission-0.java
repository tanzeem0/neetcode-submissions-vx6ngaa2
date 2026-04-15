class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<heights.length;i++)
        {
            // NSE Logic
            while(!st.isEmpty() && heights[st.peek()] > heights[i]){
                int ind = st.pop();
                maxArea = Math.max(heights[ind] * (i-(st.isEmpty() ? -1 : st.peek()) -1),maxArea);
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int ind = st.pop();
            maxArea = Math.max(heights[ind] * (heights.length-(st.isEmpty() ? -1 : st.peek()) -1),maxArea);
        }
        return maxArea;
    }
}