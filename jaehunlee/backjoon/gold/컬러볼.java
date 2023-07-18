import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 컬러볼 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.valueOf(st.nextToken());
        List<Ball> ballList = new ArrayList<>();
        for (int i = 0; i < a; i++) {
            st = new StringTokenizer(br.readLine());
            int color = Integer.valueOf(st.nextToken());
            int size = Integer.valueOf(st.nextToken());
            ballList.add(new Ball(color, size, 0));
            int zero = 0;
            for (int j = zero; j < ballList.size(); j++) {
                Ball ball = ballList.get(j);
                if (ball.getColor() != color && ball.getSize() > size) {
                    ball.setCatchValue(ball.getCatchValue() + size);
                }
            }
        }
        for (int i = 0; i < ballList.size(); i++) {
            System.out.println(ballList.get(i).getCatchValue());
        }

    }

    static class Ball {
        int color;
        int size;
        int catchValue;

        @Override
        public String toString() {
            return "Ball{" +
                    "color=" + color +
                    ", size=" + size +
                    ", catchValue=" + catchValue +
                    '}';
        }

        Ball(int color, int size, int catchValue) {
            this.color = color;
            this.size = size;
            this.catchValue = catchValue;
        }

        public int getColor() {
            return color;
        }

        public int getSize() {
            return size;
        }

        public int getCatchValue() {
            return catchValue;
        }

        public void setCatchValue(int catchValue) {
            this.catchValue = catchValue;
        }
    }

}

