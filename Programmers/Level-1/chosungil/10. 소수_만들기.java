import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Map<Integer, HashSet<String>> sosuMap = new HashMap<>();

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (isSosu(sum)) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }

    boolean isSosu(int num) {
        for (int i = 2; i <= num; i++) {
            if (num % i == 0 && num != i) {
                return false;
            }
        }
        return true;
    }
}
