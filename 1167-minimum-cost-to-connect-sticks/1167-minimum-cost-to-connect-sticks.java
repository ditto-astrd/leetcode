class Solution {
    public int connectSticks(int[] sticks) {
        if (sticks.length == 1) return 0;
        
        Arrays.sort(sticks);

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int stick : sticks) {
            q.add(stick);
        }

        int cost = 0;

        while(q.size() > 1) {
            int stick1 = q.poll();
            int stick2 = q.peek();
            q.poll();
            int sum = stick1 + stick2;
            cost += sum;
            q.add(sum);
        }

        return cost;
    }
}
/**
스틱이 1개 남을때까지 (= 모두 연결될때까지) 최소한의 비용으로 연결해봐라

- 매번 합이 작아야 함
- 매번 합이 작아야하니까 우선순위 큐에 오름차순으로 정렬해서 더하자
-> 1,3,5,8 -> 4 5 8 -> 9,8 -> 17 = 4 + 9 + 17
 */