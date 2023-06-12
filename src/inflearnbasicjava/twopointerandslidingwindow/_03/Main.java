package inflearnbasicjava.twopointerandslidingwindow._03;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        main.solution(n, k, arr);
    }

    // 시간 초과
    public void solution(int n, int k, int[] arr) {
        int max = 0;
        int end = k;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            if (end == n) {
                break;
            }
            for (int j = i; j < end; j++) {
                sum += arr[j];
            }
            end++;
            max = Math.max(sum, max);
        }

        System.out.println(max);
    }

    public void teacherSolution(int n, int k, int[] arr) {
        int max = 0;
        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += arr[i];
            max = sum;
        }

        for (int i = k; i < n; i++) {
            sum += (arr[i] - arr[i - k]);
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}
