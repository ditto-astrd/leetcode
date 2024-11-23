class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int idx = 0;
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < pushed.length; i++) {
            while (!st.isEmpty() && st.peek() == popped[idx]) {
                st.pop();
                idx++;
            }

            st.push(pushed[i]);
        }
        
        while (!st.isEmpty() && st.peek() == popped[idx++]) {
            st.pop();
        }

        return st.isEmpty() ? true : false;
    }
}

/**
- push 순서, pop 순서가 주어졌을때 이게 가능한지 판단하기
 */

 /**
 
  */