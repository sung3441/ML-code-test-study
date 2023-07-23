import java.util.Arrays;
import java.util.Comparator;

public class 파괴되지_않는_건물 {
    public static void main(String[] args) {


        Ball ball1 = new Ball(1, 1, 2);
        Ball ball2 = new Ball(2, 2, 2);
        Ball ball3 = new Ball(3, 5, 2);
        Ball ball4 = new Ball(4, 3, 2);

        Ball[] ball =  {ball1, ball2, ball3, ball4};

        Comparator<Ball> comparatorBall = (balla, ballb) -> ball1.getSize() - ball2.getSize();



    }
    static class Solution {
        public int solution(int[][] board, int[][] skill) {
            int answer = 0;
            return answer;



        }
    }

    static class Ball {
        int idx;
        int size;
        int color;

        @Override
        public String toString() {
            return "Ball{" +
                    "idx=" + idx +
                    ", size=" + size +
                    ", color=" + color +
                    '}';
        }

        public Ball(int idx, int size, int color) {
            this.idx = idx;
            this.size = size;
            this.color = color;
        }

        public int getIdx() {
            return idx;
        }

        public void setIdx(int idx) {
            this.idx = idx;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getColor() {
            return color;
        }

        public void setColor(int color) {
            this.color = color;
        }
    }
}
