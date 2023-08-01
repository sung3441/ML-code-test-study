import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static class Ball implements Comparable<Ball>{
		int size;
		int color;
		
	        public Ball(int color, int size) {
	            this.color = color;
	            this.size = size;
	        }
	        @Override
	        public int compareTo(Ball nextBall) {
	        	return Integer.compare(this.size, nextBall.size);
	        }
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int ballCnt = sc.nextInt();
		String[] ballList = new String[ballCnt];
		Ball[] balls = new Ball[ballCnt];

		// 색별로 모아주기 
		HashMap<Integer,ArrayList<Integer>> ballMap = new HashMap<>();
		HashMap<Integer,ArrayList<Integer>> ballAccMap = new HashMap<>();
		
	    	for(int i =0;i < ballCnt;i++) {
	    		int color = sc.nextInt();
			int size = sc.nextInt();
			balls[i] = new Ball(color,size);
			ballList[i] = size+"-"+color;
			
			if(ballAccMap.get(color) == null){
				ballAccMap.put(color, new ArrayList<Integer>(Arrays.asList(0)));
				ballMap.put(color, new ArrayList<Integer>(Arrays.asList(0)));
			}
	    	}

		// 사이즈 기준 sort 
		Arrays.sort(balls); 
		
		int sum = 0;
		for(int i=0;i<balls.length;i++) {
			int size = balls[i].size;
			int color = balls[i].color;
			
			//0번에 누적			
			ballAccMap.get(color).add(sum - ballAccMap.get(color).get(0));
			ballAccMap.get(color).set(0,ballAccMap.get(color).get(0)+size);
			ballMap.get(color).add(size);
			sum+=size;
		}
		
		for(String num : ballList) {
			int size = Integer.parseInt(num.split("-")[0]);
			int color = Integer.parseInt(num.split("-")[1]);
			int index = ballMap.get(color).indexOf(size);
			System.out.println(ballAccMap.get(color).get(index));
		}
	}
}
