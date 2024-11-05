class Solution {
    public int calculateTime(String keyboard, String word) {
        Map<Character, Integer> keyboardPosition = new HashMap<>();
        int answer = 0, beforePosition = 0;

        for (int i = 0; i < keyboard.length(); i++) {
            char key = keyboard.charAt(i);
            keyboardPosition.put(key, i);
        }

        for (int i = 0; i < word.length(); i++) {
            int currentPosition = keyboardPosition.get(word.charAt(i));
            int gap = Math.abs(beforePosition - currentPosition);
            answer += gap;
            beforePosition = currentPosition;
        }

        return answer;
    }
}