package array.array01;

import java.util.ArrayList;
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

        main.solution(arr, n);
    }

    public void solution(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                System.out.print(arr[i] + " ");
            } else {
                if (arr[i] > arr[i - 1]) {
                    System.out.print(arr[i] + " ");
                }
            }
        }
    }

    public void solution2(int[] arr, int n) {
        ArrayList<Integer> answer = new ArrayList<>();

        answer.add(arr[0]);
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                answer.add(arr[i]);
            }
        }

        for (int x : answer) {
            System.out.print(x + " ");
        }
    }
}
