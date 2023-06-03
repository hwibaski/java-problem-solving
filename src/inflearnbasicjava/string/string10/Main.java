/**
 * 가장 짧은 문자거리
 * <p>
 * 한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출 력하는 프로그램을 작성하세요.
 * <p>
 * ▣ 입력설명 첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다. 문자열의 길이는 100을 넘지 않는다.
 * <p>
 * ▣ 출력설명 첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.
 * <p>
 * ▣ 입력예제 1 teachermode e
 * <p>
 * ▣ 출력예제 1 10121012210
 */

package inflearnbasicjava.string.string10;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char c = sc.next().charAt(0);
        main.solution(str, c);
    }

    public void solution(String str, char c) {
        int[] answer = new int[str.length()];

        int p = 1000;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                p = 0;
                answer[i] = p;
            } else {
                p++;
                answer[i] = p;
            }
        }

        p = 1000;

        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == c) {
                p = 0;
            } else {
                p++;
                answer[i] = Math.min(answer[i], p);
            }
        }

        for (int x : answer) {
            System.out.print(x + " ");
        }
    }
}
