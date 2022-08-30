package BOJ.BOJ11660;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11660MySolve {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int twoDimArraySize = Integer.parseInt(stringTokenizer.nextToken());
        int qN = Integer.parseInt(stringTokenizer.nextToken());

        int[][] twoDimArray = new int[twoDimArraySize + 1][twoDimArraySize + 1];
        int[][] sumArray = new int[twoDimArraySize+ 1][twoDimArraySize+ 1];

        for (int i = 1; i <= twoDimArraySize; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            for (int j = 1; j <= twoDimArraySize; j++) {
                twoDimArray[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        for (int i = 1; i <= twoDimArraySize; i++) {
            for (int j = 1; j <= twoDimArraySize; j++) {
                sumArray[i][j] = sumArray[i][j-1] + sumArray[i -1][j] - sumArray[i-1][j-1] + twoDimArray[i][j];
            }
        }

        for (int i = 0; i < qN; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(stringTokenizer.nextToken());
            int y1 = Integer.parseInt(stringTokenizer.nextToken());
            int x2 = Integer.parseInt(stringTokenizer.nextToken());
            int y2 = Integer.parseInt(stringTokenizer.nextToken());

            int result = sumArray[x2][y2] - sumArray[x1 - 1][y2] - sumArray[x2][x1 - 1] + sumArray[x1 - 1][y1 - 1];
            System.out.println(result);
        }
    }
}
