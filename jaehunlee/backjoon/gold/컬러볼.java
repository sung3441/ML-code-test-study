import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 컬러볼 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.valueOf(st.nextToken());
        List<Ball> ballList = new LinkedList<>();
        int[] colors = new int[N+1];
        int[] answer = new int[N+1];

        Comparator<Ball> ballSizeSort = Comparator.comparingInt(Ball::getSize);

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int color = Integer.valueOf(st.nextToken());
            int size = Integer.valueOf(st.nextToken());
            Ball ball = new Ball(i, color, size);
            ballList.add(ball);
        }

        ballList.sort(ballSizeSort);

        Arrays.stream(answer).skip(1).forEach(System.out::println);

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

