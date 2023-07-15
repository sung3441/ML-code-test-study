package sungil.programmers.level2;

import java.util.Arrays;

public class 구명보트 {

    public static void main(String[] args) {
        구명보트 s = new 구명보트();
        System.out.println("1번 테스트 케이스 : " + (s.solution(new int[]{70, 50, 80, 50}, 100) == 3));
        System.out.println("2번 테스트 케이스 : " + (s.solution(new int[]{70, 80, 50}, 100) == 3));
    }

    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people); // 무게 순으로 정렬

        // 제일 가벼운 두 사람의 합이 보트의 제한 무게보다 크다면 인원 수 만큼 보트 필요
        if (people.length > 1 && people[0] + people[1] > limit) {
            return people.length;
        }

        for (int i = people.length - 1, min = 0; min <= i; i--) {
            if (people[i] + people[min] <= limit) { // 제일 무거운 사람 + 제일 가벼운 사람
                min++; // 제일 가벼운 사람 보트에 태웠다면 다음 가벼운 사람으로 넘김
            }
            answer++;
        }
        return answer;
    }
}
