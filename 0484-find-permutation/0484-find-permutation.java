class Solution {
    public int[] findPermutation(String s) {
        final char D = 'D';
        final char I = 'I';
        int len = s.length();
        int[] ans = new int[len + 1];
        Stack<Integer> st = new Stack<>();
        int num = 1, index = 0;
        
        st.push(num++);
        
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == I) {
                while(!st.isEmpty()) {
                    ans[index++] = st.pop();
                }
            }
            st.push(num++);
        }

        while(!st.isEmpty()) {
            ans[index++] = st.pop();
        }

        return ans;
    }
}

/**
- I, D로만 문자열이 이루어짐
- I 는 num[i] < num[i+1]
- D 는 num[i] > num[i+1]
- 이걸 만족하는 가장 작은 값의 int[] 배열을 반환하기 (lexicographically smallest)
 */

 /**
 1. 우선 stack에 1을 그냥 저장
 2. I면 현재까지 스택에 저장된 모든 값을 배열에 저장
 3. D면 현재 숫자를 그냥 스택에 저장
  */