import java.util.*;
class 옹알이 {

    public int solution (String[] babbling) {
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