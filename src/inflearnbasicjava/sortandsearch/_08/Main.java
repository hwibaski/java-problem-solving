package inflearnbasicjava.sortandsearch._08;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        main.solution(t, arr);
    }

    public void solution(int t, int[] arr) {
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        int mid;
        int answer = 0;

        while (left <= right) {
            mid = (left + right) / 2;

            if (t > arr[mid]) {
                left = mid + 1;
            } else if (t < arr[mid]) {
                right = mid - 1;
            } else {
                answer = mid;
                break;
            }
        }
        System.out.println(answer + 1);
    }
}
