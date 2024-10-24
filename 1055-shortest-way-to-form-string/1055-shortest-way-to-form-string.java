class Solution {
    public int shortestWay(String source, String target) {
        int pos = 0;
        int ans = 0;

        while(pos < target.length()) {
            int prevPos = pos;
            
            /* source길이만큼 for문을 돌리고, source.charAt(i)와 target.charAt(pos)가 같으면 pos++ */
            for(int i=0; i<source.length(); i++){
                if(pos < target.length() && source.charAt(i) == target.charAt(pos)) pos++;
            }

            if(prevPos == pos) return -1;
            ans++;
        }

        return ans;
    }
}


/*
    1. 
 */