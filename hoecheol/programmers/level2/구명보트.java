import java.util.*;

class 구명보트 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int cnt = 0;

        Arrays.sort(people);

        for(int i = 0; i < people.length; i++){
            if(people[i] > limit - people[0]){
                answer++;
                people[i] = -1;
            }else{
                cnt++;
            }
        }

        for(int i = 0; i < people.length; i++){
            for(int j = people.length-1; j > i; j--){
                if(people[i] != -1 && people[j] != -1){
                    if(people[i] + people[j] <= limit){
                        answer++;
                        people[i] = -1;
                        people[j] = -1;
                    }
                }
            }
        }
        if(cnt % 2 != 0){
            answer++;
        }

        return answer;
    }
}
