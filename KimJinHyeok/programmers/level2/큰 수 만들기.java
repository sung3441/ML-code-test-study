import java.util.Arrays;
class Solution {
    public String solution(String number, int k) {
		Solution s = new Solution();
		
    	String answer = "";
    	int resultLeng = number.length() - k;
    	
    	String[] numList = number.split("");
    	
    	int maxIdx;
    	
    	while (answer.length() != resultLeng) {
    		maxIdx = s.findMaxIdx(number, k+1);
    		answer +=  number.charAt(maxIdx);
    		k -= maxIdx;
    		if(answer.length() == resultLeng) {
    			break;
    		} else {
    			number = number.substring(maxIdx+1,number.length());
    			if(k == 0) {
    				answer += number;
        		}
    		}
    	}
    	
		return answer;
    }
    public int findMaxIdx(String number,int limit) {
    	int max =  number.charAt(0)-'0';
    	int maxIdx = 0;
    	for (int i=1;i<limit;i++) {
    		if(max == 9) {
    			break;
    		}
    		if(max < number.charAt(i)-'0'){
    			max = number.charAt(i)-'0';
    			maxIdx = i;
    		}
    	}
    	return maxIdx;
    }
}
