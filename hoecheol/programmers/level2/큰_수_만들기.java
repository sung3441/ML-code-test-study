import java.util.Arrays;

class 큰_수_만들기 {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        int cnt = 0;

        for(int i = 0; i < number.length()-k; i++){
            int max = 0;
            for(int j = index; j <= i + k; j++){
                if(max < number.charAt(j)-'0'){
                    max = number.charAt(j)-'0';
                    cnt = j + 1;
                }
            }
            sb.append(max);
            index = cnt;
        }

        return sb.toString();
    }
}
