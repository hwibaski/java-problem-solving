package BOJ.solved.BOJ11659;

import java.util.Scanner;

public class BOJ11659MySolve {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dataN = sc.nextInt();
        int qN = sc.nextInt();
        int[] data = new int[dataN];

        for(int i = 0; i < dataN; i++) {
            data[i] = sc.nextInt();
        }
        int[] dataSum = new int[data.length];

        for(int i = 0; i < dataSum.length; i++) {
            if (i == 0) {
                dataSum[i] = data[i];
                continue;
            }
            dataSum[i] = dataSum[i-1] + data[i];
        }

        int startIdx = 0;
        int endIdx = 0;
        int[] answer = new int[qN];

        for (int i = 0; i < qN; i++) {
            startIdx = sc.nextInt();
            endIdx = sc.nextInt();
            if (startIdx == 1) {
                answer[i] = dataSum[endIdx - 1];
            } else {
                answer[i] = dataSum[endIdx - 1] - dataSum[startIdx - 2];
            }
        }

        for (int el: answer) {
            System.out.println(el);
        }
    }
}
