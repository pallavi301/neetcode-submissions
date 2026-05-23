class Solution {
    public boolean isValid(String s) {
        //create a stack of string
        Stack<Character> stack = new Stack<>();
        //whenever you see opening bracket store it
        //whenever you see closing bracket check if it matches most recent opening bracket
        for(char c : s.toCharArray()) {
            //opening bracket
            if(c=='{' || c=='[' || c=='(') {
                stack.push(c);
            } else {
                if(stack.isEmpty()){
                    return false;
                }
                char top = stack.pop();
            //check closing
            if((c == '}' && top != '{') || (c == ']' && top != '[') || (c == ')' && top != '(')) {
                return false;
            }
        }
    }

        return stack.isEmpty();
}
}
