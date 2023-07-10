package inflearnbasicjava.sortandsearch._06;

import java.util.ArrayList;
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

    public void solution(int n, int[] arr) {
        int[] copied = new int[n];

        for (int i = 0; i < n; i++) {
            copied[i] = arr[i];
        }

        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            if (arr[i] != copied[i]) {
                System.out.print((i + 1) + " ");
            }
        }
    }

    public void teacherSolution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();

        int[] tmp = arr.clone();
        Arrays.sort(tmp);

        for (int i = 0; i < n; i++) {
            if (arr[i] != tmp[i]) {
                answer.add(i + 1);
            }
        }

        for (Integer integer : answer) {
            System.out.print(integer + " ");
        }
    }
}
