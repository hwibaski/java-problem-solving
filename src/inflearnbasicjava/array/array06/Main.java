/**
 * 뒤집은 소수
 * <p>
 * N개의 자연수가 입력되면 각 자연수를 뒤집은 후 그 뒤집은 수가 소수이면 그 소수를 출력하는 프로그램을 작성하세요. 예를 들으 32를 뒤집으면 23이고, 23은 소수이다.
 * 그러면 23을 출력한다. 단 910을 뒤집으면 19로 숫자화 해야 한다. 첫 차리부터의 연속된 0은 무시한다.
 * <p>
 * ▣ 입력설명 첫 줄에 자연수의 개수 (3=N<=100)이 주어지고, 그 다움 줄에 N개의 자연수가 주어진다.
 * <p>
 * ▣ 출력설명 첫 줄에 뒤집은 소수를 출력합니다. 출력순서는 입력된 순서대로 출력합니다.
 * <p>
 * ▣ 입력예제 1 9 32 55 62 20 250 370 200 30 100
 * <p>
 * ▣ 출력예제 1 23 2 73 2 3
 */

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
