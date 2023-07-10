import java.util.*;

class Solution {
    public int 옹알이1 (String[] babbling) {
        int answer = 0;
        String[] announce = {"aya", "ye", "woo", "ma"};

        for(String babStr : babbling){
            for(String annoStr : announce){
                babStr = babStr.replaceFirst(annoStr, " ");
            }
            if(babStr.replaceAll(" ","").equals("")) answer++;
        }

        return answer;
    }
}