package inflearnbasicjava.twopointerandslidingwindow._01;

import java.util.ArrayList;
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

    public void solution(int n, int[] a, int m, int[] b) {
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i] < b[j]) {
                    answer.add(a[i]);
                    break;
                } else {
                    answer.add(b[j]);
                }
            }
        }

        for (int i : answer) {
            System.out.println(i);
        }
    }

    public void teacherSolution(int n, int[] a, int m, int[] b) {
        List<Integer> answer = new ArrayList<>();
        int p1 = 0;
        int p2 = 0;

        while (p1 < n && p2 < m) {
            if (a[p1] < b[p2]) {
                answer.add(a[p1++]);
            } else {
                answer.add(b[p2++]);
            }
        }

        while (p1 < n) {
            answer.add(a[p1++]);
        }

        while (p2 < m) {
            answer.add(a[p2++]);
        }

        for (int i : answer) {
            System.out.println(i);
        }
    }
}
