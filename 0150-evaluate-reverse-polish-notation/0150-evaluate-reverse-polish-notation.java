// 
import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        String operators = "+-*/";
        
        for (String token : tokens) {
            if (operators.indexOf(token) != -1) {
                int d2 = st.pop();
                int d1 = st.pop();
                int res = 0;
                
                if (token.equals("+")) {
                    res = d1 + d2;
                } else if (token.equals("-")) {
                    res = d1 - d2;
                } else if (token.equals("/")) {
                    res = d1 / d2;
                } else if (token.equals("*")) {
                    res = d1 * d2;
                }
                // FIX: Move this OUT of the "else if" so ALL math operations get pushed
                st.push(res); 
                
            } else {
                // FIX: Move this completely out of the operator "if" block
                st.push(Integer.parseInt(token));
            }
        }
        // FIX: The final answer is the last remaining element in the stack
        return st.pop(); 
    }
}
