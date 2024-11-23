class FirstUnique {
    private Queue<Integer> q = new LinkedList<>();
    private Map<Integer, Integer> map = new HashMap<>();

    public FirstUnique(int[] nums) {
        for (int num : nums) {
            q.offer(num);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
    }
    
    public int showFirstUnique() {
        while (!q.isEmpty() && map.get(q.peek()) != 1) {
            q.remove();
        }

        if (!q.isEmpty()) return q.peek();

        return -1;
    }
    
    public void add(int value) {
        q.offer(value);
        map.put(value, map.getOrDefault(value, 0) + 1);
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */