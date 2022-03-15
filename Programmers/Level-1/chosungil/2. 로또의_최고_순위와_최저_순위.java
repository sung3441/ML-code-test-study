class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int zeroCnt = 0;
        int winCnt = 0;
        int answer[] = new int[2];
        
        for(int lotto : lottos) {
            if(lotto == 0) {
                zeroCnt++;
                continue;
            }
            for(int win_num : win_nums) {
                if(lotto == win_num) {
                    winCnt++;
                    break;
                }
            }
        }    
        int max = (winCnt == 0 && zeroCnt == 0) ? 6 : 7 - (winCnt + zeroCnt);
        int min = (winCnt == 0) ? 6 : 7 - winCnt;

        answer[0] = max;
        answer[1] = min;
        
        return answer;
    }
}
