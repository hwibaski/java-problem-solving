package inflearnbasicjava.array.array09;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        main.solution(n, arr);

    }

    public void solution(int n, int[][] arr) {
        int max = 0;
        int sum = 0;
        int garoSum = 0;
        int seroSum = 0;
        int aSum = 0;
        int bSum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                garoSum += arr[i][j];
                seroSum += arr[j][i];
                if (i + j == (n + 1)) {
                    aSum += arr[i][j];
                }

                if (i == j) {
                    bSum += arr[i][j];
                }
            }
            if (garoSum > max) {
                max = garoSum;
            } else if (seroSum > max) {
                max = seroSum;
            }
            garoSum = 0;
            seroSum = 0;
        }

        if (bSum > max) {
            max = bSum;
        }

        if (aSum > max) {
            max = aSum;
        }

        System.out.println(max);
    }

    public void teacherSolution(int n, int[][] arr) {
        int answer = Integer.MIN_VALUE;

        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < n; i++) {
            sum1 = sum2 = 0;
            for (int j = 0; j < n; j++) {
                sum1 += arr[i][j];
                sum2 += arr[j][i];
            }
            answer = Math.max(answer, sum1);
            answer = Math.max(answer, sum2);
        }
        sum1 = sum2 = 0;

        for (int i = 0; i < n; i++) {
            sum1 += arr[i][i];
            sum2 += arr[i][n - i - 1];
        }
        answer = Math.max(answer, sum1);
        answer = Math.max(answer, sum2);

        System.out.println(answer);
    }
}
