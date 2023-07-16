import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
    	int result=0;

    	Solution sol = new Solution();
    	
    	Arrays.sort(reserve);
    	Arrays.sort(lost);
    	
    	Map student = new HashMap<Integer,String>();

    	for(int i=1;i<=n;i++) {
    		student.put(i,"1");
    	}
    	
    	for(int i=0;i<lost.length;i++) {
			student.put(lost[i],"0");
    	}
    	for(int i=0;i<reserve.length;i++) {
    		if("0".equals(student.get(reserve[i]))) {
        		student.put(reserve[i],"1");
    		} else if("0".equals(student.get(reserve[i]-1))) {
    			if(!"0".equals(student.get(reserve[i]))) {
            		student.put(reserve[i]-1,"1");
        		}
    		} else if(i < reserve.length && "0".equals(student.get(reserve[i]+1))) {
    			if(i+1 == reserve.length || (i+1 != reserve.length && reserve[i]+1 != reserve[i+1])) {
    				student.put(reserve[i]+1,"1");
    			}
    		}
    	}

    	for(int i=1;i<=n;i++) {
    		if("1".equals(student.get(i))) {
    			result++;
    		}
    	}
        
        return result;
    }
}
