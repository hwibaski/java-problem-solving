package BOJ.tryagain.BOJ1940;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1940MySolve {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        int cnt = 0;

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 풀이 2 : 시간 초과
        Arrays.sort(A);
        int startIdx = 0;
        int endIdx = A.length - 1;
        int sum = 0;

        while (startIdx != endIdx) {
            sum = A[startIdx] + A[endIdx];

            if (sum < M) {
                startIdx++;
            } else if (sum == M) {
                cnt++;
                endIdx--;
            }
        }
        System.out.println(cnt);


        // 풀이 1: 답이 맞지 않음.
//        for (int i = 0; i < N; i++) {
//            for (int j = 1; j < N; j++) {
//                if (A[i] + A[j] == M) {
//                    System.out.println("("+A[i]+", "+ A[j]+")");
//                    cnt++;
//                }
//            }
//        }

    }
}
