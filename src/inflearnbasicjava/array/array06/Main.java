package inflearnbasicjava.array.array06;

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
        main.solution(n, arr);


    }

    /**
     * 시간 초과
     */
    public void solution(int n, int[] arr) {
        int[] rev = new int[n];

        for (int i = 0; i < n; i++) {
            int tmp = arr[i];
            String str = String.valueOf(tmp);
            StringBuilder stringBuilder = new StringBuilder();

            for (int j = str.length() - 1; j >= 0; j--) {
                if (str.charAt(j) != '0') {
                    stringBuilder.append(str.charAt(j));
                }
            }

            rev[i] = Integer.parseInt(stringBuilder.toString());

        }

        int cnt = 0;
        for (int x : rev) {
            cnt = 0;
            for (int i = 1; i <= x; i++) {
                if (x % i == 0) {
                    cnt++;
                }
            }
            if (cnt == 2) {
                System.out.print(x + " ");
            }
        }
    }

    public void solution2(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int tmp = arr[i];
            int res = 0;
            while (tmp > 0) {
                int t = tmp % 10;
                res = res * 10 + t;
                tmp = tmp / 10;
            }
            if (isPrime(res)) {
                answer.add(res);
            }
        }
    }

    public boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
