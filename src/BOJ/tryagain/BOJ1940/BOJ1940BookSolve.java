package BOJ.tryagain.BOJ1940;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1940BookSolve {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        int cnt = 0;
        int startIdx = 0;
        int endIdx = N - 1;
        while(startIdx <endIdx) {
            if(A[startIdx] + A[endIdx] < M) {
                startIdx++;
            } else if (A[startIdx] + A[endIdx] > M) {
                endIdx--;
            } else {
                cnt++;
                startIdx++;
                endIdx--;
            }
        }
        System.out.println(cnt);
        bf.close();
    }
}
