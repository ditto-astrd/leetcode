class Solution {
    public int totalFruit(int[] fruits) {
        if (fruits.length <= 2) {
            return fruits.length;
        } 

        int ans = 0, left = 0, right = 0;
        Map<Integer, Integer> basket = new HashMap<>();

        while (right < fruits.length) {
            basket.put(fruits[right], basket.getOrDefault(fruits[right], 0) + 1);

            while (basket.size() > 2) {
                int leftFruit = fruits[left++];
                basket.put(leftFruit, basket.get(leftFruit) - 1);
                if (basket.get(leftFruit) == 0) {
                    basket.remove(leftFruit);
                }
            }

            ans = Math.max(ans, right - left + 1);
            right++;
        }

        return ans;
    }
}

/**
- 바구니는 2개, 각 바구니는 1개의 타입만 가질 수 있음
    - 바구니에 담을 수 있는 과일의 양은 제한 X
- 이동 후 마주친 트리에서 반드시 1개를 수확해야 함
    - 어느 지점에서 수확을 시작하건 상관 없으며, 반드시 오른쪽(배열의 마지막 인덱스 방향)으로 가야함 
    - 수확이 불가능한 나무를 마주하면 수집 종료
 */

 /**
 - 투 포인터로 시작 (left = 0, right = 0)
 - right을 오른쪽으로 움직이며, 최대 수집 과일의 개수는 매번 갱신
 - 만약 2 타입의 과일을 초과할 경우 -> 2개 이하의 타입이 될때까지 left를 움직여 줌
  */