package inflearnbasicjava.array.array03;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        main.solution(n, a, b);
    }

    public void solution(int n, int[] a, int[] b) {
        for (int i = 0; i < n; i++) {
            if (a[i] == 1 && b[i] == 2) {
                System.out.println("B");
            } else if (a[i] == 1 && b[i] == 3) {
                System.out.println("A");
            } else if (a[i] == 2 && b[i] == 1) {
                System.out.println("A");
            } else if (a[i] == 2 && b[i] == 3) {
                System.out.println("B");
            } else if (a[i] == 3 && b[i] == 1) {
                System.out.println("B");
            } else if (a[i] == 3 && b[i] == 2) {
                System.out.println("A");
            } else {
                System.out.println("D");
            }
        }
    }

    public void solution2(int n, int[] a, int[] b) {
        for (int i = 0; i < n; i++) {
            if (a[i] == b[i]) {
                System.out.println("D");
            } else if (a[i] == 1 && b[i] == 3) {
                System.out.println("A");
            } else if (a[i] == 2 && b[i] == 1) {
                System.out.println("A");
            } else {
                System.out.println("B");
            }
        }
    }
}
