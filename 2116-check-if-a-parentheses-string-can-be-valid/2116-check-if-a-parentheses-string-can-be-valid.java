class Solution {
    public boolean canBeValid(String s, String locked) {
        if (s.length() % 2 > 0) return false;       // "(" 처럼 입력되는 경우는 무조건 불가능
        
        char[] chrs = s.toCharArray();
        char[] locks = locked.toCharArray();

        Stack<Integer> origin = new Stack<>();  // 고정적으로 저장되는 문자열
        Stack<Integer> extra = new Stack<>();   // 변경 가능한 문자열 

        for (int i = 0; i < chrs.length; i++) {
            if (locks[i] == '0') {  // 여차하면 변경 가능
                extra.push(i);
            } else if (chrs[i] == '(') {    // 변경 불가능
                origin.push(i);
            } else if (chrs[i] == ')') {    
                if (!origin.isEmpty()) {
                    origin.pop();
                } else if (!extra.isEmpty()){
                    extra.pop();
                } else {
                    return false;
                }
            }
        }

        // 마지막이 '('인데 못바꾸는 경우 고려
        while(!origin.isEmpty() && !extra.isEmpty() && origin.peek() < extra.peek()) {
            origin.pop();
            extra.pop();
        }     

        return origin.isEmpty() ? true : false;
    }
}

/**
조건
1. 비지 않은 문자열로 ( ) 로만 구성
2. locked에서 0은 바꿀수 있음을, 1은 못바꾸는걸 뜻함
3. 2번의 조건을 통해 s가 유효한 문자열로 유지 or 변경 가능할지 판단

- stack..?
 */