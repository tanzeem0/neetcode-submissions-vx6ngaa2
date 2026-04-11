class Solution {
    private boolean checkIfValidParan(char c,Stack<Character> stack){
        if((c == ')' && stack.peek() == '(') || 
            (c == '}' && stack.peek() == '{') || 
            (c == ']' && stack.peek() == '['))
            return true;
        return false;
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c:s.toCharArray()){
            if(c =='(' || c =='{' || c == '['){
                stack.push(c);
            }else{
                if(!stack.isEmpty() && checkIfValidParan(c,stack)){
                    System.out.println(stack.peek());
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty() ? true : false;
    }
}