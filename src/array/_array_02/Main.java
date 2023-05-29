/**
 * 보이는 학생
 *
 * 선생님이 N명의 학생을 일렬로 세웠습니다. 일렬로 서 있는 학생의 키가 앞에서부터 순서대로 주어질 때, 맨 앞에 서 있는 선생님이 볼 수 있는 학생의 수를
 * 구하는 프로그램을 작성하세요. (어떤 학생이 자기 앞에 서 있는 학생들보다 크면 그 학생은 보이고, 작거나 같으면 보이지 않습니다.)
 *
 * ▣ 입력설명
 * 첫 줄에 정수 N(5<=N<=100,000)이 입력된다. 그 다음줄에 N명의 학생의 키가 앞에서부터 순서대로 주어진다.
 *
 * ▣ 출력설명
 * 선생님이 볼 수 있는 최대 학생수를 출력한다.
 *
 * ▣ 입력예제 1
 * 8
 * 130 135 148 140 145 150 150 153
 *
 * ▣ 출력예제 1
 * 5
 */

package array._array_02;

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
        int max = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                answer++;
                max = arr[i];
            }
        }
        System.out.println(answer);
    }
}
