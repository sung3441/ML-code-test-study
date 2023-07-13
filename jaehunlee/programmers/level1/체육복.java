import java.util.Arrays;

public class 체육복 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(5, new int[]{1, 5}, new int[]{1, 3});
    }

    static class Solution {
        public int solution(int n, int[] lost, int[] reserve) {
            Arrays.sort(lost);
            Arrays.sort(reserve);

            int answer = n;

            for (int i = 0; i < lost.length; i++) {
                for (int j = 0; j < reserve.length; j++) {
                    if (lost[i] == reserve[j]) {
                        lost[i] = -3;
                        reserve[j] = -1;
                        break;
                    }
                }
            }

            for (int i = 0; i < lost.length; i++) {
                for (int j = 0; j < reserve.length; j++) {
                    if (lost[i] != -3) {
                        if (lost[i] - 1 == reserve[j]) {
                            lost[i] = -3;
                            reserve[j] = -1;
                            break;
                        }
                        if (lost[i] + 1 == reserve[j]) {
                            lost[i] = -3;
                            reserve[j] = -1;
                            break;
                        }
                    }
                }
            }
            for (int lostStu : lost) {
                if (lostStu != -3) answer--;
            }

            return answer;
        }
    }
}
