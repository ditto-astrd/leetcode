class Solution {
    public int countElements(int[] arr) {
        if(arr.length == 1) return 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;

        for(int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for(int key : map.keySet()) {
            if(map.containsKey(key + 1)) {
                int value = map.get(key);
                ans += value;
            }
        }

        return ans;
    }
}