import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간_합_구하기_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.valueOf(st.nextToken());
        int b = Integer.valueOf(st.nextToken());
        int[] temp = new int[a + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= a; i++) {
            temp[i] = temp[i - 1] + Integer.valueOf(st.nextToken());
        }

        for (int i = 0; i < b; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.valueOf(st.nextToken());
            int end = Integer.valueOf(st.nextToken());
            System.out.println(temp[end] - temp[start - 1]);
        }
    }
}
