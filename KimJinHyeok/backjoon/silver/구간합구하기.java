import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] nList = new int[n+1];
    	int[] nSumList = new int[n+1];
    	
    	for(int i =1;i<=n;i++) {
    		nSumList[i] = nSumList[i-1] + sc.nextInt();
    	}
		
    	for(int i=0;i<m;i++) {
    		int start = sc.nextInt();
    		int end =sc.nextInt();
    		
    		System.out.println(nSumList[end] - nSumList[start-1]);
		}
	}
}
