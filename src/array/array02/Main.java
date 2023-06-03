package array.array02;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        main.solution(n, arr);
    }

    public void solution(int n, int[] arr) {
        int answer = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                answer++;
                max = arr[i];
            }
        }
        System.out.println(answer);
    }
}
