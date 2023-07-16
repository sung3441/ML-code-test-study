class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        int sum = m + section[0];
        
        for(int target : section){
            if(sum - 1 < target){
                answer++;
                sum = m + target;
            }
        }
        
        return answer;
    }
}
