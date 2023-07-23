import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 컬러볼 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.valueOf(st.nextToken());
        List<Ball> ballList = new LinkedList<>();
        int[] sizeArr = new int[a+2];

        Comparator<Ball> ballSizeSort = Comparator.comparingInt(Ball::getSize);
        Comparator<Ball> ballIdxSort = Comparator.comparingInt(Ball::getIdx);

        for (int i = 1; i <= a; i++) {
            st = new StringTokenizer(br.readLine());
            int color = Integer.valueOf(st.nextToken());
            int size = Integer.valueOf(st.nextToken());
            Ball ball = new Ball(i, color, size);
            ballList.add(ball);
        }

        ballList.sort(ballSizeSort);

        int totalSize = 0;
        for (Ball ball : ballList) {
            int ballColor = ball.getColor();
            int ballSize = ball.getSize();
            ball.setResult(totalSize - sizeArr[ballColor]);
            totalSize += ballSize;
            sizeArr[ballColor] += ballSize;
        }

        ballList.sort(ballIdxSort);
        ballList.forEach(it -> System.out.println(it.getResult()));

    }

    static class Ball {
        int idx;
        int color;
        int size;
        int result;

        public Ball(int idx, int color, int size) {
            this.idx = idx;
            this.color = color;
            this.size = size;
        }

        public int getIdx() {
            return idx;
        }

        public int getColor() {
            return color;
        }

        public int getSize() {
            return size;
        }

        public int getResult() {
            return result;
        }

        public void setResult(int result) {
            this.result = result;
        }
    }

}

