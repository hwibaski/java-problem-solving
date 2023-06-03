package inflearnbasicjava.array.array07;

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
        int plus = 0;
        boolean cont = false;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 1 && cont) {
                answer = answer + plus + 1;
                plus++;
                cont = true;
            } else if (arr[i] == 1 && !cont) {
                answer += 1;
                plus++;
                cont = true;
            } else if (arr[i] == 0) {
                plus = 0;
                cont = false;
            }
        }

        System.out.println(answer);
    }

    public void solution2(int n, int[] arr) {
        int answer = 0;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                cnt++;
                answer += cnt;
            } else {
                cnt = 0;
            }
        }

        System.out.println(answer);
    }
}
