import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
    	Arrays.sort(people);
    	
    	int num = 0;
    	int result=0;
    	
		for(int i = people.length - 1; i >= num  ; i--) {
			if(people[i] + people[num] <= limit) {
				 num++;
			}
			result++;
    	}

		return result;
    }
}
