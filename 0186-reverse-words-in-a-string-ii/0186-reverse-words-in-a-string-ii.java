class Solution {
    public void reverseWords(char[] s) {
        int len = s.length;
        reverse(0, len - 1, s);

        int left = 0;

        for (int i = 0; i < len; i++) {
            if (s[i] == ' ') {
                reverse(left, i - 1, s);
                left = i + 1;
            }
        }

        reverse(left, len - 1, s);
    }

    private void reverse(int left, int right, char[] s) {
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }
}

/**
- 추가 배열 할당은 불가능
- 공백을 기준으로 문자가 나뉘는 상황

1. 투 포인터로 문자열을 거꾸로 배치하기
- the value -> eulav eht
3. 공백을 기준으로 내부 투 포인터를 또 진행해서 거꾸로 재배치하기
- eulav에서 투 포인터 진행, eht에서 투 포인터 진행
 */