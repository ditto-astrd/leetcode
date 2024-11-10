
class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> map = new HashMap<>();
        
        for(String s : strings) {
            char[] chars = s.toCharArray();
            char start = chars[0];
            int gap = start - 'a';
            for(int i = 0; i < chars.length; i++) {
                chars[i] -= gap;
                if(chars[i] < 'a') chars[i] += 26;
            }
            String key = String.valueOf(chars);
            if(!map.containsKey(key)) map.put(key, new ArrayList<String>());
            map.get(key).add(s);
        }
        
        return new ArrayList<List<String>>(map.values());
    }
}

/*
1. strings에 저장된 모든 문자열을 'a'부터 시작할 수 있도록 Shift 범위를 계산
2. 1에서 구한 값만큼 모든 문자열을 이동한 뒤, Hashmap에 저장
 */