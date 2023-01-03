//Solution 1
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String t : tokens){
            if("+-*/".contains(t))
              st.push(eval(st.pop(), st.pop(), t));
            else
              st.push(Integer.parseInt(t));
        }

       
        return st.pop();

    }
     private int eval(int b, int a, String op){
            if("+".equals(op))
            return a+b;
            else if("-".equals(op))
            return a-b;
            else if("*".equals(op))
            return a*b;
            else
            return a/b;
        }
}

//Solution 2
class Solution {

    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();

        for(String element: tokens){
            if(isOperatorCheck(element)){

                int element2 = Integer.parseInt(stack.pop());
                int element1 = Integer.parseInt(stack.pop());
                int output = 0;

                if(element.equals("*")){
                    output = element1*element2;
                } else if(element.equals("/")){
                    output = element1/element2;
                }else if(element.equals("+")){
                    output = element1+element2;
                }else if(element.equals("-")){
                    output = element1-element2;
                }
                stack.push(output+"");
            } else {
                stack.push(element);
            }
        }

        return Integer.parseInt(stack.peek());
    }

    private boolean isOperatorCheck(String element){
        if(element.equals("*") || element.equals("+") || element.equals("-") || element.equals("/")){
            return true;
        } else {
            return false;
        }
    }
}
