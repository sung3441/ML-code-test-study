import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 컬러볼 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.valueOf(st.nextToken());
        List<Ball> ballList = new ArrayList<>();
        for (int i = 0; i < a; i++) {
            Ball ball = new Ball();
            st = new StringTokenizer(br.readLine());
            ball.setNum(Integer.valueOf(st.nextToken()));
            ball.setSize(Integer.valueOf(st.nextToken()));
            ballList.add(ball);
        }
    }

    static class Ball {
        private int num;
        private int size;

        @Override
        public String toString() {
            return "Ball{" +
                    "num=" + num +
                    ", size=" + size +
                    '}';
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }
    }
}

