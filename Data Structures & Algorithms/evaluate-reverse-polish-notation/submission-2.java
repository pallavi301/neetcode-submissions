class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String st : tokens) {
            if(st.equals("+")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a+b);

            } else if(st.equals("*")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a*b);
            } else if(st.equals("-")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a-b);

            } else if(st.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a/b);
            } else {
                stack.push(Integer.parseInt(st));
            }
        }
        return stack.pop();
    }
}
