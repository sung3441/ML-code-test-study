package sungil.programmers.level1;

import java.util.HashMap;

public class 체육복 {

    public static void main(String[] args) {
        체육복 s = new 체육복();
        System.out.println("1번 테스트 케이스 : " + (s.solution(5, new int[]{2, 4}, new int[]{1, 3, 5}) == 5));
        System.out.println("2번 테스트 케이스 : " + (s.solution(5, new int[]{2, 4}, new int[]{3}) == 4));
        System.out.println("3번 테스트 케이스 : " + (s.solution(3, new int[]{3}, new int[]{1}) == 2));
    }

    public int solution(int n, int[] lost, int[] reserve) {

        HashMap<Integer, Integer> map = new HashMap();
        int answer = n - lost.length;

        // 체육복 도난 당한 사람 체크
        for (int i = 0; i < lost.length; i++) {
            map.put(lost[i], -1);
        }

        // 여분 체육복 가져온 사람 체크
        for (int i = 0; i < reserve.length; i++) {
            // 여분 체육복 가져온 사람이 도난 당한 경우 처리
            if (map.containsKey(reserve[i])) {
                map.put(reserve[i], 0);
                answer++;
                continue;
            }
            map.put(reserve[i], 1);
        }

        // 체육복 빌려주기
        for (int i = 1; i <= n; i++) {
            if (map.getOrDefault(i, 0) == -1) {
                if (map.getOrDefault(i - 1, 0) == 1) { // 앞 사람한테 빌려주기
                    map.put(i - 1, 0);
                    answer++;
                } else if (map.getOrDefault(i + 1, 0) == 1) { // 뒷 사람한테 빌려주기
                    map.put(i + 1, 0);
                    answer++;
                }
            }
        }
        return answer;
    }
}