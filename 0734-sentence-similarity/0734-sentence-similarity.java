class Solution {
    public boolean areSentencesSimilar(String[] s1, String[] s2, List<List<String>> similarPairs) {
        if (s1.length != s2.length) return false;

        Map<String, Set<String>> pairs = new HashMap<>();

        for (List<String> pair : similarPairs) {
            String a = pair.get(0);
            String b = pair.get(1);

            pairs.computeIfAbsent(a, t -> new HashSet<>()).add(b);
            pairs.computeIfAbsent(b, t -> new HashSet<>()).add(a);
        }

        for (int i = 0; i < s1.length; i++) {
            if (s1[i].equals(s2[i])) continue;

            if (pairs.containsKey(s1[i]) && pairs.get(s1[i]).contains(s2[i])) continue;

            return false;
        }

        return true;
    }
}

/**

- similarPairs는 유사한 단어들의 짝을 저장한 리스트
- sentence1와 sentence2가 유사한지 판단해라
    - 조건 1 : sentence1와 sentence2는 같은 길이를 가져야 함
    - 조건 2 : sentence1[i]와 sentence2[i]는 같은 쌍이어야 함 (= similarPairs에 저장되기) 

0. sentence1와 sentence2의 길이가 다르면 무조건 false (= ealry return)
1. similarPairs의 짝을 양방향으로 map에 저장
2. sentence1의 단어를 모두 set에 저장하고 sentence2의 단어도 모두 set에 저장
3. 2번에 있는것들을 모두 for문을 돌려서 1번에서 구한 map에 있는 쌍들을 제거해나가기

 */