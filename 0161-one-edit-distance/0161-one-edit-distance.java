class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();

        if (Math.abs(sLen - tLen) > 1) return false;
        if (s.equals(t)) return false;

        boolean isEdited = false;
        int sPos = 0, tPos = 0;

        while (sPos < sLen && tPos < tLen) {
            if (s.charAt(sPos) == t.charAt(tPos)) {
                sPos++;
                tPos++;
                continue;
            }

            if (isEdited) return false;

            if (sLen < tLen) {
                tPos++;
            } else if(sLen == tLen) {
                sPos++;
                tPos++;
            } else {
                sPos++;
            }
            isEdited = true;
        }


        return true;
    }
}
/**
케이스별로 분리

1. 길이 차이가 2 이상이면 무조건 fail

2. 비교해서 문자가 다를때, isEdited = true로 변경
- 문자열 길이가 둘다 똑같으면 그냥 계속 비교 시작
- 문자열 길이 차이가 1이면 
  - 작은거 insert -> 문자열 길이 큰것의 position ++
  - 큰거 delete -> 문자열 길이 큰것의 position ++
  - 결국은 문자열 큰것만 이동

2-1. isEdited = true인데 문자가 다른 상황이 재발하면 무조건 false
 */