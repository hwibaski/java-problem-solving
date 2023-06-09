package inflearnbasicjava.array.array10;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n + 2][n + 2];

        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < n + 2; j++) {
                if (i == 0 || i == n + 1 || j == 0 || j == n + 1) {
                    arr[i][j] = 0;
                    continue;
                }

                arr[i][j] = sc.nextInt();
            }
        }

        main.solution(n, arr);
    }

    public void solution(int n, int[][] arr) {
        int cnt = 0;
        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < n + 2; j++) {
                if (i == 0 || j == 0) {
                    continue;
                }

                if (arr[i][j] > arr[i - 1][j] && arr[i][j] > arr[i][j + 1] && arr[i][j] > arr[i
                        + 1][j] && arr[i][j] > arr[i][j - 1]) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    public void teacherSolution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = true;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (nx > 0 && nx < n && ny > 0 && ny < n && (arr[nx][ny] >= arr[i][j])) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    answer++;
                }
            }
        }
    }
}
