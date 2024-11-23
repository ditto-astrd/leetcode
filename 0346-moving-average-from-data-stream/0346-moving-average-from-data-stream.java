class MovingAverage {
    private Queue<Integer> q = new LinkedList<>();
    private int size = 0;
    private double total = 0;

    public MovingAverage(int size) {
        this.size = size;
    }
    
    public double next(int val) {
        if (q.size() == size) {
            total -= q.poll();
        }

        q.offer(val);
        total += val;

        return total / q.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */