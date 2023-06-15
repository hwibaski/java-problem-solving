package inflearnbasicjava.twopointerandslidingwindow._06;

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

        main.solution(n, arr, k);
    }

    // 못 풀었음
    public void solution(int n, int[] arr, int k) {
        int max = 0;
        int cnt = k;
        int lt = 0;
//        int rt = 0;
//
//        for (int rt = 0; rt < n; rt++) {
//            if (arr[rt] == 0 && cnt > 0) {
//                cnt--;
//            }
//
//            if (cnt == 0 && rt - lt > max) {
//                max = rt - lt;
//                cnt = k;
//                lt = rt;
//            }
//        }

        for (int rt = 0; rt < n; rt++) {
            if (arr[rt] == 0) {
                cnt--;
            }

            if (cnt == -1 && rt - lt > max) {
                max = rt - lt;
                cnt = k;

                while (arr[lt] != 0) {
                    lt++;
                }
            }
        }


        System.out.println(max);
    }

    public void teacherSolution(int n, int[] arr, int k) {
        int answer = 0;
        int cnt = 0;
        int lt = 0;

        for (int rt = 0; rt < n; rt++) {
            if (arr[rt] == 0) {
                cnt++;
            }
            while (cnt > k) {
                if (arr[lt] == 0) {
                    cnt--;
                }
                lt++;
            }
            answer = Math.max(answer, rt - lt + 1);
        }
    }
}
