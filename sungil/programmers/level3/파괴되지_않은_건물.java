package sungil.programmers.level3;

public class 파괴되지_않은_건물 {

    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int[][] arr = new int[board.length + 2][board[0].length + 2];

        for (int[] s : skill) {
            int type = s[0] == 1 ? -1 : 1;
            int degree = s[5] * type;

            arr[s[1] + 1][s[2] + 1] += degree;
            arr[s[3] + 2][s[4] + 2] += degree;
            arr[s[1] + 1][s[4] + 2] += degree * -1;
            arr[s[3] + 2][s[2] + 1] += degree * -1;
        }

        for (int i = 1; i < arr.length - 1; i++) {
            for (int j = 1; j < arr[i].length - 1; j++) {
                arr[i][j] += arr[i - 1][j] + arr[i][j - 1] - arr[i - 1][j - 1];
                if (arr[i][j] + board[i - 1][j - 1] > 0) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
