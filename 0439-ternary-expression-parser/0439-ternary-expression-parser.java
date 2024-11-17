class Solution {
    public String parseTernary(String ex) {
        Stack<Character> st = new Stack<>();
        final char CONDITION = '?';
        final char SKIP = ':';
        final char PASS = ':';
        final char TRUE = 'T';

        for (int i = ex.length() - 1; i >= 0; i--) {
            char c = ex.charAt(i);
            if (c == CONDITION) {
                char val1 = st.pop();
                char val2 = st.pop();
                if (ex.charAt(i-1) == TRUE) st.push(val1);
                else st.push(val2);
                i--;
            } else if (c == SKIP) {
                continue;
            } else {
                st.push(c);
            }
        }

        return st.pop().toString();
    }
}
/**

1. 문자열 마지막부터 시작 
2. ':'는 무시하고, 현재 값이 ?가 아니라면 이전 값을 stack에 저장
(ex : 3:4에서 3의 인덱스에 도달했을 경우, 4는 stack에 저장)
3. 현재 값이 ?이라면
- 다음 값이 T면 stack의 가장 맨 앞 값을 제거하고 이전값을 stack에 저장
- 다음 값이 F라면 이전 값을 저장하지 않고 넘어감
4. 이 과정을 for문을 돌때까지 반복하여 마지막에 남은 stack값 반환
 */