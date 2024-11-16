class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> ans = new ArrayList<>();
        int st = toBeRemoved[0];
        int ed = toBeRemoved[1];
        
        for (int[] interval : intervals) {
            if (interval[0] < st) {
                ans.add(List.of(interval[0], Math.min(interval[1], st)));
            }

            if (interval[1] > ed) {
                ans.add(List.of(Math.max(ed, interval[0]), interval[1]));
            }   
        }

        return ans;
    }
}

/**
- intervals에서 toBeRemoved에 포함되는 모든 범위를 제거하고 남은 범위를 출력
- intervals는 0번째 인덱스 기준 오름차순으로 정렬되어 있음
- 핵심은 정답에 넣어야하는 값만 로직을 작성해야함 (Example 2 참고)

0. st = toBeRemoved[0], ed = toBeRemoved[1]로 대조값 셋팅
intervals로 for문을 돌려서
1. intervals[0]이 st보다 작다면 interval[0]을 시작으로, interval[1]과 st중 작은 값을 정답으로 저장
2. intervals[1]이 ed보다 크다면 interval[1]을 시작으로, ed와 interval[1] 중 큰 값으로 정답 저장
 */