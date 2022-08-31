package BOJ.tryagain.BOJ10986;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ10986BookSolve {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        long[] S = new long[N];
        long[] C = new long[M];
        long answer = 0;

        // 구간합 배열 생성
        S[0] = sc.nextInt();
        for (int i = 1; i < N; i++) {
            S[i] = S[i - 1] + sc.nextInt();
        }
        System.out.println(Arrays.toString(S));

        for (int i = 0; i < N; i++) {
            int remainder = (int) (S[i] % M);
            System.out.println("remainder = " + remainder);

            if (remainder == 0) answer++;

            C[remainder]++;
        }
        System.out.println(Arrays.toString(C));

        for (int i = 0; i < M; i++) {
            if (C[i] > 1) {
                answer = answer + (C[i] * (C[i] - 1) / 2);
            }
        }
        System.out.println(answer);
    }

}
