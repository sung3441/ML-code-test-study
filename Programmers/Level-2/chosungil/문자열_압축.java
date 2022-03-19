class Solution {
    public int solution(String s) {
        int minLength = 1001;
        
        for (int i = 1; i <= s.length() / 2; i++) { // 압축 길이는 s length의 / 2를 넘어갈 수 없음
            int cnt = 1;
            String str = ""; // 특정 길이로 압축했을 때 결과
            String subStrMemory = ""; // 이전 반복문에서 subString 해둔 값 보관용

            for (int j = 0; j + i <= s.length(); j += i) {
                String subStr = s.substring(j, j + i);
                if (subStrMemory.equals(subStr)) {
                    cnt++;
                    continue;
                } else {
                    str += cnt > 1 ? cnt + subStrMemory : subStrMemory; // 값이 다르면 이 전 값을 더해야함
                    subStrMemory = subStr;
                    cnt = 1;
                }
            }
            str += cnt > 1 ? cnt + subStrMemory : subStrMemory; // 마지막 값은 더해지지 않았으므로 반복문 종료 후 처리

            if (s.length() % i != 0) { // 길이만큼 나눴을 때 계산에 포함되지 않은 나머지 값 더하기
                 str += s.substring(s.length() - (s.length() % i), s.length());
            }

            minLength = str.length() < minLength ? str.length() : minLength;
        }
     
        return minLength != 1001 ? minLength : 1;
    }
}
