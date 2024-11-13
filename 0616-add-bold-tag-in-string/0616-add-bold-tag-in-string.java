class Solution {
    public String addBoldTag(String s, String[] words) {
        boolean[] check = new boolean[s.length()];
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0, end = 0; i < s.length(); i++) {
            for(String word : words) {
                if(s.startsWith(word, i)) {
                    end = Math.max(end, i + word.length());
                }
            }
            check[i] = end > i;
        }
        
        for(int i = 0; i < s.length(); i++) {
            if(check[i]) {
                int j = i;
                for(j = i; j < s.length(); j++) {
                    if(!check[j]) break;
                }
                sb.append("<b>"+s.substring(i,j)+"</b>");
                i=j-1;
            } else sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}

/**
1. startWith으로 단어의 시작 지점, 종료 지점을 판별
2. 시작 / 종료지점을 true로 표기할때 이미 true가 된 지점이라면
    -> 앞에 단어랑 위치가 중복된다는 뜻
    -> 2번에서 하려던 시작 or 종료지점 표기를 제거
3. true / false를 토대로 bold체 삽입
 */