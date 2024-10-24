class Solution {
    public int shortestWay(String source, String target) {
        int pos = 0;
        int ans = 0;

        while(pos < target.length()) {
            int prevPos = pos;
            
            for (int i = 0; i < source.length(); i++) {
                if (pos < target.length() && source.charAt(i) == target.charAt(pos)) pos++;
            }
            
            if (prevPos == pos) return -1;

            ans++;
        }

        return ans;
    }
}

/**
- subsquence = 원문 문자열에서 일부 문자를 제거해서 나온 문자
  - 이때 상대적인 위치는 변경하면 안됨
- source에서 target을 만들기 위한 subsequence의 최소 개수
- 불가능하면 -1 return

1. target 길이 만큼 while문을 돌림
2. 내부에서 source길이만큼 for문을 돌리고, source.charAt(i)와 target.charAt(pos)가 같으면 pos++

 */