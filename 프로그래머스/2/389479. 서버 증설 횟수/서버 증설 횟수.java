class Solution {
    public int solution(int[] players, int m, int k) {
        int[] provision = new int[24];
        int currentActive = 0;
        int answer = 0;
        
        for(int i=0;i<24;i++){
            if(i-k>=0)
                currentActive -= provision[i-k];
            int needed = players[i] / m;
            
            if(currentActive < needed) {
                int toProvision = needed - currentActive;
                provision[i] = toProvision;
                currentActive += toProvision;
                answer += toProvision;
            }
        }
        
        return answer;
    }
}