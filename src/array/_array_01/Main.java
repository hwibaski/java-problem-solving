/**
 * 큰 수 출력하기
 *
 * N(1<=M<=100)의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.(첫 번째 수는 무조건 출력한다)
 *
 * ▣ 입력설명
 * 첫 줄에 자연수 N이 주어지고, 그 다음 줄에 N개의 정수가 입력된다.
 *
 * ▣ 출력설명
 * 자신의 바로 앞 수보다 큰 수만 한 줄로 출력한다
 *
 * ▣ 입력예제 1
 * 6
 * 7 3 9 5 6 12
 *
 * ▣ 출력예제 1
 * 7 9 6 12
 */

package array._array_01;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++ ){
            arr[i] = sc.nextInt();
        }

        main.solution(arr, n);
    }

    public void solution(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
           if (i == 0){
               System.out.print(arr[i] + " ");
           } else {
               if (arr[i] > arr[i - 1]) {
                   System.out.print(arr[i] + " ");
               }
           }
        }
    }

    public void solution2(int[] arr, int n) {
        ArrayList<Integer> answer = new ArrayList<>();

        answer.add(arr[0]);
        for(int i = 1; i < n; i++) {
            if (arr[i] > arr[i-1]) {
                answer.add(arr[i]);
            }
        }

        for (int x: answer) {
            System.out.print(x + " ");
        }
    }
}
