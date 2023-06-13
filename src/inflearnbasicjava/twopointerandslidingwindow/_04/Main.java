package inflearnbasicjava.twopointerandslidingwindow._04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        main.solution(n, m, arr);
    }

    // 시간 초과
    public void solution(int n, int m, int[] arr) {
        int answer = 0;

        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int p1 = i;
                while (p1 <= j) {
                    sum += arr[p1++];
                }
                if (sum == m) {
                    answer++;
                }
                sum = 0;
            }
        }

        System.out.println(answer);
    }

    public void teacherSolution(int n, int m, int[] arr) {
        int answer = 0;
        int sum = 0;
        int lt = 0;

        for (int rt = 0; rt < n; rt++) {
            sum += arr[rt];
            if (sum == m) {
                answer++;
            }
            while (sum >= m) {
                sum -= arr[lt++];
                if (sum == m) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
