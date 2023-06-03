package inflearnbasicjava.array.array05;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        main.solution(n);
    }


    /**
     * 시간초과
     */
    public void solution(int n) {
        int cnt = 0;
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    cnt++;
                }
            }
            if (cnt == 2) {
                answer++;
            }
            cnt = 0;
        }

        System.out.println(answer);
    }

    public void solution2(int n) {
        int answer = 0;
        int[] ch = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            if (ch[i] == 0) {
                answer++;

                // 특정 수의 배수를 체크하는 반복문 j = j + i가 포인트!
                for (int j = i; j <= n; j = j + i) {
                    ch[j] = 1;
                }
            }
        }

        System.out.println(answer);
    }
}
