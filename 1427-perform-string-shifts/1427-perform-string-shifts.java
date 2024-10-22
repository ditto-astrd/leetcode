class Solution {
    public String stringShift(String s, int[][] shift) {
        int movement = 0;
        String ans = "";
        int len = s.length();

        for (int[] arr : shift) {
            if (arr[0] == 0) movement -= arr[1];
            else movement += arr[1];        
        }

        movement %= len;

        if (movement > 0) {
            ans += s.substring(len - movement);
            ans += s.substring(0, len - movement);
        } else if (movement == 0) {
            return s;
        } else {
            ans += s.substring(Math.abs(movement));
            ans += s.substring(0, Math.abs(movement));
        }

        return ans;
    }
}
/**
0 왼쪽, 1 오른쪽
1. 전체 움직임을 계산
2. 최종 움직임에서 문자열 재생성
ex ) +2 -> 문자열 마지막에서부터 2개 가져오기 + 나머지 그대로 갖다 붙이기
ex ) -2 -> 앞에 문자열 2개를 맨 뒤로 붙이기 
 */