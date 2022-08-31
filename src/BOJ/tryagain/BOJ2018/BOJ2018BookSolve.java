package BOJ.tryagain.BOJ2018;

import java.util.Scanner;

public class BOJ2018BookSolve {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int startIdx = 1;
        int endIdx = 1;
        int cnt = 1; // N이 15일 경우 바로 포함.
        int sum = 1;

        // 1  2  3  4  5  6  7  8  9  10
        //                   s
        //                      e
        // sum : 20
        while (endIdx != N) {
            if (sum == N) {
                cnt++;
                endIdx++;
                sum += endIdx;
            } else if (sum > N) {
                sum -= startIdx;
                startIdx++;
            } else {
                endIdx++;
                sum += endIdx;
            }
        }
        System.out.println(cnt);
    }
}
