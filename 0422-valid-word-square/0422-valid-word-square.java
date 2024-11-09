
class Solution {
    public boolean validWordSquare(List<String> words) {
        for(int i = 0; i < words.size(); i++) {
            String temp1 = "";
            String temp2 = "";
            for(int j = 0; j < words.get(i).length(); j++){
                Character c1 = words.get(i).charAt(j);
                Character c2 = 'A';
                if(words.size() >= j+1 && words.get(j).length() >= i+1) { 
                    c2 = words.get(j).charAt(i);
                }
                temp1 += c1.toString();
                temp2 += c2.toString();
                if(!temp1.equals(temp2)) return false;
            }
        }
        return true;
    }
}