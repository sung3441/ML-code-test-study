import java.util.ArrayList;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        ArrayList basket = new ArrayList();
        
        for(int move : moves) { // 어느 라인 내려갈지
            for(int i = 0; i < board.length; i++) { // 인형 뽑기통 깊이만큼 반복
                int doll = board[i][move-1];
                
                if(doll != 0) { //현재 포크레인의 위치에 인형이 있으면
                    basket.add(doll);
                    board[i][move-1] = 0;
                    
                    if(basket.size() > 1 && basket.get(basket.size()-1) == basket.get(basket.size()-2)) {
                        basket.remove(basket.size()-1);
                        basket.remove(basket.size()-1);
                        answer += 2;
                    }
                    break;
                }
            }
        }
        return answer;
    }
}
