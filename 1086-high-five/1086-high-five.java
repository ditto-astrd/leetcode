class Solution {
    public int[][] highFive(int[][] items) {
        final int TOP = 5;
        TreeMap<Integer, PriorityQueue<Integer>> map = new TreeMap<>();

        for (int[] item : items) {
            int id = item[0], score = item[1];
            if (!map.containsKey(id)) {
                map.put(id, new PriorityQueue<Integer>());  
            }

            map.get(id).add(score);
            if (map.get(id).size() > TOP) {
                map.get(id).poll();
            }
        }

        List<int[]> result = new ArrayList<>();

        for (int id : map.keySet()) {
            int sum = 0;
            while (map.get(id).size() > 0) {
                sum += map.get(id).poll();
            }
            result.add(new int[]{id, sum / 5});
        }
        
        int[][] answer = new int[result.size()][];
        return result.toArray(answer);
    }
}
/**
TOP 5로 평균점수가 좋은 학생의 [id, top5 avrg]를 출력

1. Map에 각 학생들의 아이디와 점수 합산해서 저장
2. 각 점수들의 합을 / 5로 저장
3. map에 저장된 값을 [kay, value]로 저장 
 */