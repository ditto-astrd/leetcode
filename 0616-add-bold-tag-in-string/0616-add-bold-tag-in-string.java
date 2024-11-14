class Solution {
    private static final String BOLD_START = "<b>";
    private static final String BOLD_END = "</b>";

    public String addBoldTag(String s, String[] words) {
        int len = s.length();
        boolean[] check = new boolean[len];
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0, end = 0; i < len; i++) {
            for(String word : words) {
                if (s.startsWith(word, i)) {
                    end = Math.max(end, i + word.length());
                }
            }

            check[i] = end > i;
        }

        for (int i = 0; i < len; i++) {
            if (check[i]) {
                int j;
                for (j=i; j < len; j++) {
                    if(!check[j]) break;
                }
                sb.append(BOLD_START + s.substring(i, j) + BOLD_END);
                i = j - 1;
            } else {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}

/**
- 만약 겹치는 words가 존재하면 하나의 태그로 합쳐야 한다.
- 겹치지 않고 연이은 words가 존재하면 하나의 태그로 합쳐야 한다.

1. startWith으로 단어의 시작 지점, 종료 지점을 판별
2. 시작 / 종료지점을 true로 표기할때 이미 true가 된 지점이라면
    -> 앞에 단어랑 위치가 중복된다는 뜻
    -> 2번에서 하려던 시작 or 종료지점 표기를 제거
3. true / false를 토대로 bold체 삽입
 */