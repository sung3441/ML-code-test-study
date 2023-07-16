class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 1;

        int sum = 0;

        for(int i=2;i<=number;i++) {
            int myPower = 2;
            if(i<4) {
                myPower = myPower > limit?limit:2;
            } else {
                for(int j=2;j<=i/2;j++) {
                    if(i%j==0) {
                        myPower++;
                        if(myPower > limit) {
                            myPower = power;
                            break;
                        }
                    }
                }
            }
            answer+=myPower;
        }
        return answer;
    }
}
