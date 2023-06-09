package inflearnbasicjava.array.array12;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        main.teacherSolution(m, n, arr);
    }

    // 못 풀었음
    public void solution(int m, int n, int[][] arr) {
        int answer = 0;
//        int cur = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    int cur = arr[i][k];
                    int curRank = k;

                }
            }
        }
    }

    public void teacherSolution(int m, int n, int[][] arr) {
        int answer = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= m; j++) {
                int cnt = 0;
                for (int k = 0; k < n; k++) {
                    int pi = 0;
                    int pj = 0;
                    for (int s = 0; s < m; s++) {
                        if (arr[k][s] == i) {
                            pi = s;
                        }
                        if (arr[k][s] == j) {
                            pj = s;
                        }
                    }
                    if (pi < pj) {
                        cnt++;
                    }
                }
                if (cnt == n) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
