package sungil.programmers.level2;

public class 큰_수_만들기 {

    public String solution(String n, int k) {

        StringBuilder number = new StringBuilder();
        int maxIndex = getMaxNumFirstIndex(n, k); // 가장 큰 값의 첫 index 구하기

        number.append(n.substring(maxIndex));
        int count = k - (n.length() - number.length());
        int index = 1;

        while (count > 0) {
            boolean flag = true;

            for (int i = index; i < number.length() - 1; i++) {
                char c = number.charAt(i);
                if (number.length() > 2 && number.charAt(i + 1) > c) { // 내 다음 숫자와 비교
                    number.deleteCharAt(i);
                    flag = false;
                    index = i - 1; // 다음 반복의 시작 인덱스로 설정
                    count--;
                    break;
                }
            }
            if (flag) { // flag가 true면 보다 작은 수가 없다는 얘기이므로, 현재 number에서 남은 k의 수만큼 뒤에서 제거
                return number.substring(0, number.length() - count);
            }
        }
        return number.toString();
    }

    int getMaxNumFirstIndex(String numStr, int k) {
        int maxIndex = 0;
        char max = (char) 0;

        for (int i = 0; i <= k; i++) {
            char c = numStr.charAt(i);
            if (c > max) {
                maxIndex = i;
                max = c;
            }
        }
        return maxIndex;
    }
}