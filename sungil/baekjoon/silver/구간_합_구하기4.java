package sungil.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간_합_구하기4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int numCount = Integer.parseInt(st.nextToken());
        int lineCount = Integer.parseInt(st.nextToken());
        int[] sumArr = new int[numCount + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < sumArr.length - 1; i++) {
            sumArr[i + 1] = sumArr[i] + Integer.parseInt(st.nextToken());
        }

        while (lineCount-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(sumArr[end] - sumArr[start - 1]).append("\n");
        }
        System.out.print(sb);
    }
}
