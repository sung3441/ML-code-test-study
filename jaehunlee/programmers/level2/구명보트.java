import java.util.Arrays;

public class 구명보트 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer = solution.solution(new int[]{40, 50, 80, 90, 110, 110}, 140);
        System.out.println(answer);
    }

    static class Solution {
        public int solution(int[] people, int limit) {
            int answer = 0;
            Arrays.sort(people);

            for (int i = people.length - 1, start = 0; i >= 0; i--) {

                if (i == start) {
                    answer++;
                    break;
                }

                if (people[i] + people[start] > limit) {
                    answer++;
                } else {
                    answer++;
                    if (i - start == 1) {
                        break;
                    }
                    start++;
                }
            }
            return answer;
        }
    }
}
