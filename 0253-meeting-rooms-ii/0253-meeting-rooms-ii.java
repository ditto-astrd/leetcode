class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int answer = 1;
        
        Arrays.sort(intervals, (o1, o2) -> {
            return o1[0] - o2[0];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] >= pq.peek()) {
                pq.poll();
                pq.add(intervals[i][1]);
                continue;
            }

            pq.add(intervals[i][1]);
            answer++;
        }

        return answer;
    }
}

/**
미팅을 모두 끝내기 위한 최소한의 미팅룸 개수 반환

1. 시작시간을 기점으로 오름차순 정렬
2. 첫 번째 회의 종료 시간을 우선순위 큐에 저장
- 두 번째부터 for문 시작
- 큐에 있는 값보다 현재 회의 시작시간이 작다면 정답 + 1을 해주고 현재 회의 종료 시간을 추가
- 반대로 큐에 있는 값보다 현재 회의 시작시간이 크다면 큐를 pop해주고 현재 회의 종료 시간을 추가
3. 정답 반환
 */