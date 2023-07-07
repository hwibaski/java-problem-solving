package inflearnbasicjava.sortandsearch._05;

import java.util.Arrays;
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

    /**
     * 해시맵으로 풀 수도 있다!!
     * 해시맵은 n으로 풀 수 있음
     * 정렬은 nlogn으로 풀 수 있음
     */
    public void solution(int n, int[] arr) {
        String answer = "U";
        Arrays.sort(arr);
//        int[] array = Arrays.stream(arr).sorted().toArray(); -> 시간 초과

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                answer = "D";
            }
        }

        System.out.println(answer);
    }
}
