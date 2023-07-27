package sungil.baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 컬러볼 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Ball[] balls = new Ball[n];
        int[] result = new int[n];
        int[] colors = new int[n + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            balls[i] = new Ball(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(balls, Comparator.comparingInt(b -> b.size));

        int sum = 0;
        int targetIndex = 0;
        for (int i = 0; i < n; i++) {
            Ball currentBall = balls[i];
            while (currentBall.size > balls[targetIndex].size) {
                sum += balls[targetIndex].size;
                colors[balls[targetIndex].color] += balls[targetIndex].size;
                targetIndex++;
            }
            result[currentBall.index] = sum - colors[currentBall.color];
        }

        for (int i = 0; i < n; i++) {
            sb.append(result[i]).append("\n");
        }
        System.out.println(sb);
    }

    static class Ball {
        int index;
        int color;
        int size;

        public Ball(int index, int color, int size) {
            this.index = index;
            this.color = color;
            this.size = size;
        }
    }
}
