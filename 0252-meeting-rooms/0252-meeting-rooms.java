class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {return o1[0] - o2[0];});
    
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i-1][1] > intervals[i][0]) return false;
        }

        return true;
    }
}

/**
1. 회의 시작 시간을 기준으로 오름차순 정렬
2. 이전 회의 종료시간 <-> 현재 회의 시작시간을 기점으로 회의에 참석할 수 있는지 판별
 */