package inflearnbasicjava.twopointerandslidingwindow._05;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            arr[i] = i + 1;
        }

        main.solution(n, arr);
    }

    public void solution(int n, int[] arr) {
        int ans = 0;
        int lt = 0;
        int sum = 0;

        for (int rt = 0; rt < n - 1; rt++) {
            sum += arr[rt];
            if (sum == n) {
                ans++;
            }
            while (sum > n) {
                sum -= arr[lt++];
                if (sum == n) {
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }
}
