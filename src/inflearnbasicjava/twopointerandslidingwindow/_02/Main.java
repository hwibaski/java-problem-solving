package inflearnbasicjava.twopointerandslidingwindow._02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }

        main.solution(n, a, m, b);
    }

    // 시간 초과
    public void solution(int n, int[] a, int m, int[] b) {
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i] == b[j]) {
                    answer.add(a[i]);
                }
            }
        }

        for (int i : answer) {
            System.out.print(i + " ");
        }
    }

    public void teacherSolution(int n, int[] a, int m, int[] b) {
        List<Integer> answer = new ArrayList<>();

        Arrays.sort(a);
        Arrays.sort(b);
        int p1 = 0;
        int p2 = 0;

        while (p1 < n && p2 < m) {
            if (a[p1] == b[p2]) {
                answer.add(a[p1++]);
                p2++;
            } else if (a[p1] < b[p2]) {
                p1++;
            } else {
                p2++;
            }
        }

        for (int x : answer) {
            System.out.println(x);
        }
    }
}
