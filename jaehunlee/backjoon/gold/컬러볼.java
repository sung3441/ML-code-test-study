import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 컬러볼 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.valueOf(st.nextToken());
        int[] balls = new int[a*2];

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine());
                balls[i++] = Integer.valueOf(st.nextToken());
            }
        }


    }
}
